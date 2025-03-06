import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { RoleService } from '../../../services/role.service';
import { RoleFormComponent } from '../role-form/role-form.component';
import { MenuFormComponent } from '../menu-form/menu-form.component';
import { ResourceActionFormComponent } from '../resource-action-form/resource-action-form.component';
import { CommonUtils } from 'angularx-score';

@Component({
  selector: 'app-role-page',
  templateUrl: './role-page.component.html',
  styleUrls: ['./role-page.component.scss']
})
export class RolePageComponent extends BaseComponent {
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
    public roleService: RoleService,
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
    this.roleService.search(this.formSearch.value, event)
    .subscribe(res => {
      const source = res?.data || {};
      this.dataTable = source;
      this.dataTable.first = parseInt(this.dataTable.first);
    });
  }

  prepareCreateOrUpdate(id: number) {
    let data = null;
    if (!!id) {
      this.roleService.findOne(id).subscribe(res => {
        data = res?.data;
        this.handleOpenDialog(data);
      })
    } else {
      this.handleOpenDialog(data);
    }
  }


  handleOpenDialog(data?: any) {
    this.ref = this.dialogService.open(RoleFormComponent, {
      header: 'Vai trò',
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
      this.roleService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }

  editMenu(role: any) {
    this.ref = this.dialogService.open(MenuFormComponent, {
      header: `Menu - Vai trò: ${role.name}`,
      width: CommonUtils.setWidthDiaglog('35%'),
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      data: {
        roleId: role.id
      }
    });
    this.ref.onClose.subscribe((res) => {
      if (res) {
        this.doSearch();
      }
    });
  }

  editResourceAction(role: any) {
    this.ref = this.dialogService.open(ResourceActionFormComponent, {
      header: `Tài nguyên - Vai trò: ${role.name}`,
      width: CommonUtils.setWidthDiaglog('50%'),
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      data: {
        roleCode: role.code
      }
    });
    this.ref.onClose.subscribe((res) => {
      if (res) {
        this.doSearch();
      }
    });
  }
}