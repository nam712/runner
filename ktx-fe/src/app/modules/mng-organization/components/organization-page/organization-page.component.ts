import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { OrganizationService } from '../../services/organization.service';
import { OrganizationFormComponent } from '../organization-form/organization-form.component';
import { CommonUtils } from 'angularx-score';

@Component({
  selector: 'app-organization-page',
  templateUrl: './organization-page.component.html',
  styleUrls: ['./organization-page.component.scss']
})
export class OrganizationPageComponent extends BaseComponent {
  formConfig = {
    path: [''],
    code: [''],
    name: [''],
  };
  formSearch: FormGroup;
  dataTable: any = {};
  ref: DynamicDialogRef | undefined;
  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public orgService: OrganizationService
  ) {
    super(_injector);
    this.formSearch = this.buildForm({}, this.formConfig);
    this.doSearchOrg();
  }


  onSelectNode(event: any) {
    this.f['path'].setValue(`/${event.key}/`);
    this.doSearchOrg();
  }

  prepareCreateOrUpdate(id?: number) {
    let data = null;
    if (!!id) {
      this.orgService.findOne(id).subscribe(res => {
        data = res?.data;
        data.isStudy = !!data.isStudy;
        this.handleOpenDialog(data);
      })
    } else {
      this.handleOpenDialog(data);
    }
  }

  handleOpenDialog(data?: any) {
    this.ref = this.dialogService.open(OrganizationFormComponent, {
      header: 'Đơn vị',
      width: CommonUtils.setWidthDiaglog('50%'),
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      data: data
    });
    this.ref.onClose.subscribe((res) => {
      if (res) {
        this.doSearchOrg();
      }
    });
  }

  doSearchOrg(event?: any) {
    if (!event) {
      event = {rows : 10, resetTable: true};
    }
    this.orgService.search(this.formSearch.value, event)
    .subscribe(res => {
      this.dataTable = res?.data || [];
    });
  }

  get f() {
    return this.formSearch.controls;
  }

  onSearch() {
    
  }

  onDeleteOrg(id: number) {
    this.confirmMessage('Bạn có muốn xóa thông tin?', () => {// on accepted
      this.orgService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearchOrg();
          }
        });
    }, () => {// on rejected
    });
  }
}
