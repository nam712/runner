import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BaseComponent, CommonUtils } from 'angularx-score';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RoomService } from '../../services/room.service';
import { RoomFormComponent } from '../room-form/room-form.component';
import { RoomTypeService } from '../../services/room-type.service';
import { RoomStudentComponent } from '../room-student/room-student.component';

@Component({
  selector: 'app-room-page',
  templateUrl: './room-page.component.html',
  styleUrls: ['./room-page.component.scss']
})
export class RoomPageComponent extends BaseComponent {
  formSearch: FormGroup;
  formConfig = {
    code: [''],
    name: [''],
    roomTypeCode: [''],
  };
  dataTable: any = {};
  ref: DynamicDialogRef | undefined;
  roomTypeList = [];
  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public roomService: RoomService,
    public roomTypeService: RoomTypeService,
  ) {
    super(_injector);
    this.formSearch = this.buildForm({}, this.formConfig);
    this.doSearch();
    this.loadRoomTypeList();
  }

  get f() {
    return this.formSearch.controls;
  }

  doSearch(event?: any) {
    if (!event) {
      event = {rows : 10, resetTable: true};
    }
    this.roomService.search(this.formSearch.value, event)
    .subscribe(res => {
      const source = res?.data || {};
      this.dataTable = source;
      this.dataTable.first = parseInt(this.dataTable.first);
    });
  }

  prepareCreateOrUpdate(id: number) {
    let data = null;
    if (!!id) {
      this.roomService.findOne(id).subscribe(res => {
        data = res?.data;
        this.handleOpenDialog(data);
      })
    } else {
      this.handleOpenDialog(data);
    }
  }


  handleOpenDialog(data?: any) {
    this.ref = this.dialogService.open(RoomFormComponent, {
      header: !!data?.id ? 'Cập nhật phòng' : 'Thêm mới phòng',
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
      this.roomService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }

  loadRoomTypeList() {
    this.roomTypeService.findAll().subscribe(res =>{
      this.roomTypeList = res?.data || [];
    })
  }

  viewStudent(event: Event, roomCode: string) {
    event.preventDefault();
    this.ref = this.dialogService.open(RoomStudentComponent, {
      header: 'Danh sách sinh viên',
      width: CommonUtils.setWidthDiaglog('50%'),
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      data: {roomCode}
    });
    this.ref.onClose.subscribe((res) => {
      if (res) {
        this.doSearch();
      }
    });
  }
}