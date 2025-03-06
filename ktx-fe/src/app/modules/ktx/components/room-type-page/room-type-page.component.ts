import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BaseComponent, CommonUtils } from 'angularx-score';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RoomTypeService } from '../../services/room-type.service';
import { RoomTypeFormComponent } from '../room-type-form/room-type-form.component';

@Component({
  selector: 'app-room-type-page',
  templateUrl: './room-type-page.component.html',
  styleUrls: ['./room-type-page.component.scss']
})
export class RoomTypePageComponent extends BaseComponent {
  formSearch: FormGroup;
  formConfig = {
    code: [''],
    name: [''],
  };
  dataTable: any = {};
  ref: DynamicDialogRef | undefined;
  courceList = [];
  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public roomTypeService: RoomTypeService,
  ) {
    super(_injector);
    this.formSearch = this.buildForm({}, this.formConfig);
    this.doSearch();
  }

  get f() {
    return this.formSearch.controls;
  }

  doSearch(event?: any) {
    if (!event) {
      event = {rows : 10, resetTable: true};
    }
    this.roomTypeService.search(this.formSearch.value, event)
    .subscribe(res => {
      const source = res?.data || {};
      this.dataTable = source;
      this.dataTable.first = parseInt(this.dataTable.first);
    });
  }

  prepareCreateOrUpdate(id: number) {
    let data = null;
    if (!!id) {
      this.roomTypeService.findOne(id).subscribe(res => {
        data = res?.data;
        this.handleOpenDialog(data);
      })
    } else {
      this.handleOpenDialog(data);
    }
  }


  handleOpenDialog(data?: any) {
    this.ref = this.dialogService.open(RoomTypeFormComponent, {
      header: !!data?.id ? 'Cập nhật loại phòng' : 'Thêm mới loại phòng',
      width: CommonUtils.setWidthDiaglog('50%'),
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      data: data
    });
    this.ref.onClose.subscribe((res) => {
      if (res) {
        this.doSearch();
      }
    });
  }

  onDelete(id: number) {
    this.confirmMessage('Bạn có muốn xóa thông tin?', () => {// on accepted
      this.roomTypeService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }


}