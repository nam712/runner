import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { Router } from '@angular/router';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { AuthService } from 'src/app/modules/auth/components/services/auth.service';
import { ChangePasswordFormComponent, CommonUtils, HelperService, HrStorage } from 'angularx-score';

@Component({
  selector: 'app-header',
  templateUrl: './app-header.component.html',
  styleUrls: ['./app-header.component.scss']
})
export class AppHeaderComponent {
  sidebarVisible: boolean = false;
  fullname?: string = '';
  character?: string = '';
  items: MenuItem[];
  ref: DynamicDialogRef | undefined;

  constructor(
    public router: Router,
    public helperService: HelperService,
    public dialogService: DialogService,
    public authService: AuthService,
  ) {
    const { lastName, fullname } = HrStorage.getUserToken() || {};
    this.fullname = fullname;
    this.character = lastName?.substring(0, 1).toUpperCase(); this.items = [
      {
        label: 'Đổi mật khẩu',
        icon: 'pi pi-lock',
        command: () => {
          this.changePassword();
        }
      },
      { separator: true },
      {
        label: 'Đăng xuất',
        icon: 'pi pi-sign-out',
        command: () => {
          this.logoutAction();
        }
      },

    ];
  }

  logoutAction(noclearSession?: any) {
    HrStorage.clear();
    if (!noclearSession) {
      sessionStorage.clear()
    }
    this.router.navigate(['/auth/login']);
  }

  changePassword() {
    this.ref = this.dialogService.open(ChangePasswordFormComponent, {
      header: 'Đổi mật khẩu',
      width: CommonUtils.setWidthDiaglog('300px'),
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      data: {
        authService: this.authService
      }
    });
    this.ref.onClose.subscribe((res) => {
    });
  }
}
