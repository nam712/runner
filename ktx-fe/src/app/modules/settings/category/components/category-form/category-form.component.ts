import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { ValidationService } from 'angularx-score';
import { CategoryTypeService } from '../../services/category-type.service';
import { CategoryService } from '../../services/category.service';
import { ActivatedRoute } from '@angular/router';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import { CommonUtils } from 'angularx-score';
import { CategoryType } from '../../models/category-type.model';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.scss']
})
export class CategoryFormComponent extends BaseComponent {
  formConfig = {
    id: [null],
    categoryTypeId: [null, [ValidationService.required]],
    code: ['', [ValidationService.required, ValidationService.maxLength(50)]],
    name: ['', [ValidationService.required, ValidationService.maxLength(200)]],
    description: ['', [ValidationService.maxLength(200)]],
  };
  formSave: FormGroup;
  categoryTypeList: CategoryType[] = [];

  constructor(
    public _injector: Injector,
    public config: DynamicDialogConfig,
    private categoryTypeService: CategoryTypeService,
    private categoryService: CategoryService,
    actr: ActivatedRoute,
    public dynamicDialogRef: DynamicDialogRef
  ) {
    super(_injector, actr, RESOURCE.CATEGORY, ACTION_FORM.INSERT);
    this.formSave = this.buildForm(config?.data || {}, this.formConfig);
    this.loadCategoryTypeList();
  }

  get f() {
    return this.formSave.controls;
  }

  onSave() {
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    this.confirmMessage('Bạn có muốn lưu thông tin?', () => {// on accepted
      this.categoryService.saveOrUpdate(this.formSave.value)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.dynamicDialogRef.close(res);
          }
        });
    }, () => {// on rejected
    });
  }

  loadCategoryTypeList() {
    this.categoryTypeService.findAll()
      .subscribe(res => {
        this.categoryTypeList = res?.data || [];
      });
  }

  onClose() {
    this.dynamicDialogRef.close();
  }
}
