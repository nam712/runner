import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import { RoleService } from 'src/app/modules/permission/services/role.service';
import { BaseComponent } from 'angularx-score';
import { CommonUtils } from 'angularx-score';
import { ValidationService } from 'angularx-score';
import { AuthService } from '../services/auth.service';
import { HrStorage } from 'angularx-score';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent extends BaseComponent {
  username: string = '';
  password: string = '';
  formSave: FormGroup;
  showPassword: boolean = false;
  loginError: boolean = false;
  formConfig = {
    username: ['', [ValidationService.required]],
    password: ['', [ValidationService.required]],
  }

  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public authService: AuthService,
    public router: Router
  ) {
    super(_injector, actr, RESOURCE.ROLE, ACTION_FORM.SEARCH);
    this.formSave = this.buildForm({}, this.formConfig);
  }

  get f() {
    return this.formSave.controls;
  }

  onLogin() {
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    this.authService.login(this.formSave.value)
      .subscribe({
        next: res => {
          const { token } = res.data;
          const userToken: any = {};
          userToken.access_token = token;
          HrStorage.setUserToken(userToken);
          this.authService.getUserInfo().subscribe( (res: any) => {
            if (res && res.data) {
              const { user, menuList, userPermissionList } = res.data;
              const { firstName, lastName, fullname } = user;
              userToken.firstName = firstName;
              userToken.lastName = lastName;
              userToken.fullname = fullname;
              userToken.userMenuList = menuList;
              userToken.userPermissionList = userPermissionList;
              HrStorage.setUserToken(userToken);
              // this.router.navigate(['/sms/mon-hoc']);
              window.location.href = '/ktx/hop-dong';
            }
          });
        },
        error: () => {
          this.loginError = true;
        }
      });
  }
}
