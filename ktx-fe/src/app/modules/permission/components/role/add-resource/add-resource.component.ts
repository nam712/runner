import { Component, Injector } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { RoleService } from '../../../services/role.service';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import { ResourceService } from '../../../services/resource.service';
import { ValidationService } from 'angularx-score';
import { FormGroup } from '@angular/forms';
import { CommonUtils } from 'angularx-score';

@Component({
  selector: 'app-add-resource',
  templateUrl: './add-resource.component.html',
  styleUrls: ['./add-resource.component.scss']
})
export class AddResourceComponent extends BaseComponent {
  formConfig = {
    roleCode: [null],
    resourceCode: ['', [ValidationService.required]]
  };
  formSave: FormGroup;
  resourceList = [];

  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public roleService: RoleService,
    public resourceService: ResourceService,
  ) {
    super(_injector, actr, RESOURCE.ROLE, ACTION_FORM.UPDATE);
    this.formSave = this.buildForm(config?.data || {}, this.formConfig);
    const { roleCode } = this.config?.data;
    this.f['roleCode'].setValue(roleCode)
    this.loadResourceList();
  }

  get f() {
    return this.formSave.controls;
  }

  loadResourceList() {
    this.resourceService.findAll().subscribe(res => {
      this.resourceList = (res?.data || []).map((e: any) => ({
        ...e,
        label: `${e.code} - ${e.name}`
      }));
    })
  }
  
  onSave() {
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    this.confirmMessage(this.translate.translate('common.label.confirmSave'), () => {// on accepted
      this.roleService.saveRoleResource(this.formSave.value)
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

}
