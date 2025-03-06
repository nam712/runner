import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BaseComponent, CommonUtils } from 'angularx-score';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RoomService } from '../../services/room.service';
import { KTXCommonUtils } from 'src/app/shared/ktx-common-utils.service';
import { WaterElectricBillFormComponent } from '../water-electric-bill-form/water-electric-bill-form.component';
import { WaterElectricBillService } from '../../services/water-electric-bill.service';
import { WaterElectricBillDetailComponent } from '../water-electric-bill-detail/water-electric-bill-detail.component';

@Component({
  selector: 'app-water-electric-bill-page',
  templateUrl: './water-electric-bill-page.component.html',
  styleUrls: ['./water-electric-bill-page.component.scss']
})
export class WaterElectricBillPageComponent extends BaseComponent {
  formSearch: FormGroup;
  formConfig = {
    month: [new Date().getMonth() + 1, []],
    year: [new Date().getFullYear(), []],
    roomCode: ['', []],
    code: ['', []],
    status: [null, []],
  };
  dataTable: any = {};
  ref: DynamicDialogRef | undefined;
  roomList = [];
  yearList = [];
  monthList = [];
  statusOptions = [
    { value: null, label: 'Tất cả' },
    { value: 'PAID', label: 'Đã thanh toán' },
    { value: 'NOT_YET', label: 'Chưa thanh toán' },
  ]
  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public waterElectricBillService: WaterElectricBillService,
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
    this.waterElectricBillService.search(this.formSearch.value, event)
    .subscribe(res => {
      const source = res?.data || {};
      this.dataTable = source;
      this.dataTable.first = parseInt(this.dataTable.first);
    });
  }

  prepareCreateOrUpdate(id: number) {
    let data = null;
    if (!!id) {
      this.waterElectricBillService.findOne(id).subscribe(res => {
        data = res?.data;
        this.handleOpenDialog(data);
      })
    } else {
      this.handleOpenDialog(data);
    }
  }


  handleOpenDialog(data?: any) {
    this.ref = this.dialogService.open(WaterElectricBillFormComponent, {
      header: 'Lập hóa đơn điện/nước',
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
      this.waterElectricBillService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }

  payBill(code: string) {
    this.confirmMessage(`Bạn có muốn xóa thanh toán hóa đơn ${code} không?`, () => {// on accepted
      this.waterElectricBillService.pay(code)
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

  viewDetailBill(id: number) {
    this.waterElectricBillService.findOne(id).subscribe(res => {
      this.ref = this.dialogService.open(WaterElectricBillDetailComponent, {
        header: 'Chi tiết hóa đơn điện/nước',
        width: CommonUtils.setWidthDiaglog('50%'),
        contentStyle: { overflow: 'auto' },
        baseZIndex: 10000,
        maximizable: true,
        data: res.data
      });
      this.ref.onClose.subscribe((res) => {
        if (res) {
          this.doSearch();
        }
      });
    })
  }
}
