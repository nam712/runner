import { Component, Injector } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import { BaseComponent } from 'angularx-score';
import { CommonUtils } from 'angularx-score';
import { ValidationService } from 'angularx-score';
import { OrganizationService } from '../../services/organization.service';
import { L10nTranslationService } from 'angular-l10n';

@Component({
  selector: 'app-organization-form',
  templateUrl: './organization-form.component.html',
  styleUrls: ['./organization-form.component.scss']
})
export class OrganizationFormComponent extends BaseComponent {
  formConfig = {
    id: [null],
    parentId: [null],
    code: ['', [ValidationService.required, ValidationService.maxLength(50)]],
    name: ['', [ValidationService.required, ValidationService.maxLength(200)]],
    orgType: [null],
    establishDate: [null],
    expriedDate: [null],
    description: ['', [ValidationService.maxLength(500)]],
  };
  formSave: FormGroup;
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public orgService: OrganizationService,
  ) {
    super(_injector, actr, RESOURCE.ORGANIZATION, ACTION_FORM.INSERT);
    this.formSave = this.buildForm(config?.data || {}, this.formConfig);
  }

  get f() {
    return this.formSave.controls;
  }

  onSave() {
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    const data = this.formSave.value;
    data.isStudy = data.isStudy ? 1 : 0;
    this.confirmMessage(this.translate.translate('common.label.confirmSave'), () => {// on accepted
      this.orgService.saveOrUpdate(data)
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
