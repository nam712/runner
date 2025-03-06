import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { UserService } from '../../../services/user.service';
import { UserFormComponent } from '../user-form/user-form.component';
import { CommonUtils } from 'angularx-score';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.scss']
})
export class UserPageComponent extends BaseComponent {
  formSearch: FormGroup;
  formConfig = {
    username: [''],
  };
  dataTable: any = {};
  ref: DynamicDialogRef | undefined;


  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public userService: UserService,
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
    this.userService.search(this.formSearch.value, event)
    .subscribe(res => {
      const source = res?.data || {};
      this.dataTable = source;
      this.dataTable.first = parseInt(this.dataTable.first);
    });
  }

  prepareCreateOrUpdate(id: number) {
    let data = null;
    if (!!id) {
      this.userService.findOne(id).subscribe(res => {
        data = res?.data || {};
        const { userRoles } = data;
        data.roleIds = userRoles ? userRoles.map((e: any) => e.roleId) : [];
        this.handleOpenDialog(data);
      })
    } else {
      this.handleOpenDialog(data);
    }
  }

  handleOpenDialog(data?: any) {
    this.ref = this.dialogService.open(UserFormComponent, {
      header: 'Người dùng',
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
      this.userService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }

  
  resetPassword(user: any) {
    this.confirmMessage(`Bạn có muốn khôi phục mật khẩu mặc định cho tài khoản ${user.username} không?`, () => {// on accepted
      this.userService.resetPassword(user.id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }
}
