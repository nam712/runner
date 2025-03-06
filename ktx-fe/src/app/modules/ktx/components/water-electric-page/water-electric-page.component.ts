import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BaseComponent, CommonUtils } from 'angularx-score';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { WaterElectricService } from '../../services/water-electric.service';
import { WaterElectricFormComponent } from '../water-electric-form/water-electric-form.component';
import { KTXCommonUtils } from 'src/app/shared/ktx-common-utils.service';
import { RoomService } from '../../services/room.service';

@Component({
  selector: 'app-water-electric-page',
  templateUrl: './water-electric-page.component.html',
  styleUrls: ['./water-electric-page.component.scss']
})
export class WaterElectricPageComponent extends BaseComponent {
  formSearch: FormGroup;
  formConfig = {
    month: [new Date().getMonth() + 1, []],
    year: [new Date().getFullYear(), []],
    roomCode: ['', []],
    type: [null, []],
  };
  dataTable: any = {};
  ref: DynamicDialogRef | undefined;
  roomList = [];
  yearList = [];
  monthList = [];
  typeOptions = [
    { value: null, label: 'Tất cả' },
    { value: 'ELECTRIC', label: 'Điện' },
    { value: 'WATER', label: 'Nước' },
  ]
  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public waterElectricService: WaterElectricService,
    public roomService: RoomService,
  ) {
    super(_injector);
    this.formSearch = this.buildForm({}, this.formConfig);
    this.doSearch();
    this.loadRoomList();
    this.yearList = KTXCommonUtils.createYearOptions();
    this.monthList = KTXCommonUtils.createMonthOptions();
  }

  get f() {
    return this.formSearch.controls;
  }

  doSearch(event?: any) {
    if (!event) {
      event = {rows : 10, resetTable: true};
    }
    this.waterElectricService.search(this.formSearch.value, event)
    .subscribe(res => {
      const source = res?.data || {};
      this.dataTable = source;
      this.dataTable.first = parseInt(this.dataTable.first);
    });
  }

  prepareCreateOrUpdate(id: number) {
    let data = null;
    if (!!id) {
      this.waterElectricService.findOne(id).subscribe(res => {
        data = res?.data;
        this.handleOpenDialog(data);
      })
    } else {
      this.handleOpenDialog(data);
    }
  }


  handleOpenDialog(data?: any) {
    this.ref = this.dialogService.open(WaterElectricFormComponent, {
      header: !!data?.id ? 'Cập nhật điện/nước' : 'Thêm mới điện/nước',
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
      this.waterElectricService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }

  loadRoomList() {
    this.roomService.findAll().subscribe(res =>{
      this.roomList = res?.data || [];
    })
  }
}