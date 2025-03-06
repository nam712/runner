import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { ValidationService } from 'angularx-score';
import { UserService } from '../../../services/user.service';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import { CommonUtils } from 'angularx-score';
import { RoleService } from '../../../services/role.service';
import { EmployeeService } from 'src/app/modules/mng-organization/services/employee.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent extends BaseComponent {
  formConfig = {
    id: [null],
    employeeId: ['', [ValidationService.required]],
    username: ['', []],
    // password: ['', [ValidationService.required, ValidationService.maxLength(20)]],
    // confirmPassword: ['', [ValidationService.required, ValidationService.maxLength(20)]],
    roleIds: ['', [ValidationService.required]],
  };
  formSave: FormGroup;
  roleList = [];
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public userService: UserService,
    public roleService: RoleService,
    public employeeService: EmployeeService,
  ) {
    super(_injector, actr, RESOURCE.USER, ACTION_FORM.INSERT);
    this.formSave = this.buildForm(config?.data || {}, this.formConfig);
    this.loadRoleList();
  }

  get f() {
    return this.formSave.controls;
  }

  loadRoleList() {
    this.roleService.findAll().subscribe(res => {
      this.roleList = res?.data || [];
    })
  }

  onSave() {
    console.log(' >>> save', this.formSave.value);
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    this.confirmMessage(this.translate.translate('common.label.confirmSave'), () => {// on accepted
      this.userService.saveOrUpdate(this.formSave.value)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.dynamicDialogRef.close(res);
          }
        });
    }, () => {// on rejected
    });
  }

  onClose() {
    this.dynamicDialogRef.close();
  }

  onSelectedEmp(event: any) {
    this.f['username'].setValue(event?.code || '');
  }
}
