import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BaseComponent, CommonUtils } from 'angularx-score';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RoomTypeService } from '../../services/room-type.service';
import { RoomTypeFormComponent } from '../room-type-form/room-type-form.component';
import { ContractService } from '../../services/contract.service';
import { ContractFormComponent } from '../contract-form/contract-form.component';

@Component({
  selector: 'app-contract-page',
  templateUrl: './contract-page.component.html',
  styleUrls: ['./contract-page.component.scss']
})
export class ContractPageComponent extends BaseComponent {
  formSearch: FormGroup;
  formConfig = {
    code: [''],
    status: [null],
    studentCode: [''],
    roomCode: [''],
  };
  dataTable: any = {};
  ref: DynamicDialogRef | undefined;
  courceList = [];
  statusOptions = [
    { value: null, label: 'Tất cả' },
    { value: 'ACTIVE', label: 'Còn hiệu lực' },
    { value: 'INACTIVE', label: 'Hết hạn' },
  ]
  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public contractService: ContractService,
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
    this.contractService.search(this.formSearch.value, event)
    .subscribe(res => {
      const source = res?.data || {};
      this.dataTable = source;
      this.dataTable.first = parseInt(this.dataTable.first);
    });
  }

  prepareCreateOrUpdate(id: number) {
    let data = null;
    if (!!id) {
      this.contractService.findOne(id).subscribe(res => {
        data = res?.data;
        this.handleOpenDialog(data);
      })
    } else {
      this.handleOpenDialog(data);
    }
  }


  handleOpenDialog(data?: any) {
    this.ref = this.dialogService.open(ContractFormComponent, {
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
      this.contractService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }

  onCancel(contract: any) {
    this.confirmMessage(`Bạn có muốn hủy hợp đồng số ${contract.code} không?`, () => {// on accepted
      this.contractService.cancelContract(contract.code)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }

}