import { Component, Inject, Injector } from '@angular/core';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import { BaseComponent } from 'angularx-score';
import { ValidationService } from 'angularx-score';
import { ActivatedRoute } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { CommonUtils } from 'angularx-score';
import { CategoryTypeService } from '../../services/category-type.service';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';



@Component({
  selector: 'app-category-type-form',
  templateUrl: './category-type-form.component.html',
  styleUrls: ['./category-type-form.component.scss']
})
export class CategoryTypeFormComponent extends BaseComponent {
  formConfig = {
    id: [null],
    code: ['', [ValidationService.required, ValidationService.maxLength(50)]],
    name: ['', [ValidationService.required, ValidationService.maxLength(200)]]
  };
  formSave: FormGroup;

  constructor(
    public _injector: Injector,
    public config: DynamicDialogConfig,
    private categoryTypeService: CategoryTypeService,
    actr: ActivatedRoute,
    public dynamicDialogRef: DynamicDialogRef
  ) {
    super(_injector, actr, RESOURCE.CATEGORY_TYPE, ACTION_FORM.INSERT);
    this.formSave = this.buildForm(config?.data || {}, this.formConfig);
  }

  get f() {
    return this.formSave.controls;
  }

  onSave() {
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    this.confirmMessage('Bạn có muốn lưu thông tin?', () => {// on accepted
      console.log('>>> save', this.formSave.value)
      this.categoryTypeService.saveOrUpdate(this.formSave.value)
      .subscribe(res => {
        if (res && res.type == 'SUCCESS') {
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
