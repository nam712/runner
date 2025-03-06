import { Component, Injector } from '@angular/core';
import { CategoryType } from '../../models/category-type.model';
import { BaseComponent } from 'angularx-score';
import { CategoryTypeFormComponent } from '../category-type-form/category-type-form.component';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { CategoryTypeService } from '../../services/category-type.service';
import { SEARCH_OPERATION } from 'src/app/core/app-config';
import { CategoryService } from '../../services/category.service';
import { Category } from '../../models/category.model';
import { CategoryFormComponent } from '../category-form/category-form.component';
import { CommonUtils } from 'angularx-score';

@Component({
  selector: 'app-category-page',
  templateUrl: './category-page.component.html',
  styleUrls: ['./category-page.component.scss']
})
export class CategoryPageComponent extends BaseComponent {
  categoryTypeList: CategoryType[] = [];
  categoryList: Category[] = [];
  ref: DynamicDialogRef | undefined;
  keySearchCategoryTypeCode: string = '';
  keySearchCategoryTypeName: string = '';
  keySearchCategoryCode: string = '';
  keySearchCategoryName: string = '';
  selectedCategoryType: CategoryType = {};
  constructor(
    public _injector: Injector,
    public dialogService: DialogService,
    public categoryTypeService: CategoryTypeService,
    public categoryService: CategoryService,
  ) {
    super(_injector);

    this.loadCategoryTypeList();
  }

  prepareCreateOrUpdate(id?: number) {
    let data = null;
    if (!!id) {
      this.categoryTypeService.findOne(id).subscribe(res => {
        data = res?.data;
        this.handleOpenDialog(data);
      })
    } else {
      this.handleOpenDialog(data);
    }
  }

  handleOpenDialog(data?: any) {
    this.ref = this.dialogService.open(CategoryTypeFormComponent, {
      header: 'Loại danh mục',
      width: '70%',
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      data: data
    });
    this.ref.onClose.subscribe((res) => {
      if (res) {
        this.onSearchCategoryType();
      }
    });
  }

  prepareCreateOrUpdateCategory(id?: number) {
    let data = { categoryTypeId: this.selectedCategoryType?.id };
    if (!!id) {
      this.categoryService.findOne(id).subscribe(res => {
        data = res?.data;
        this.handleOpenDialogCategory(data);
      })
    } else {
      this.handleOpenDialogCategory(data);
    }
  }

  handleOpenDialogCategory(data?: any) {
    this.ref = this.dialogService.open(CategoryFormComponent, {
      header: 'Danh mục',
      width: CommonUtils.setWidthDiaglog('70%'),
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      data: data
    });
    this.ref.onClose.subscribe((res) => {
      if (res) {
        this.onSearchCategory();
      }
    });
  }

  loadCategoryTypeList() {
    this.categoryTypeService.findAll()
      .subscribe(res => {
        this.categoryTypeList = res?.data || [];
        if (this.categoryTypeList?.length > 0) {
          this.selectedCategoryType = this.categoryTypeList[0];
          this.loadCategoryList();
        }
      });
  }

  onDelete(id: number) {
    this.confirmMessage('Bạn có muốn xóa thông tin?', () => {// on accepted
      this.categoryTypeService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.loadCategoryTypeList();
          }
        });
    }, () => {// on rejected
    });
  }

  onDeleteCategory(id: number) {
    this.confirmMessage('Bạn có muốn xóa thông tin?', () => {// on accepted
      this.categoryService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.loadCategoryTypeList();
          }
        });
    }, () => {// on rejected
    });
  }

  onSearchCategoryType() {
    const filters = [];
    if (!!this.keySearchCategoryTypeCode && this.keySearchCategoryTypeCode.length > 0) {
      filters.push({
        key: 'code',
        value: this.keySearchCategoryTypeCode,
        operator: SEARCH_OPERATION.MATCH,
      })
    }
    if (!!this.keySearchCategoryTypeName && this.keySearchCategoryTypeName.length > 0) {
      filters.push({
        key: 'name',
        value: this.keySearchCategoryTypeName,
        operator: SEARCH_OPERATION.MATCH,
      })
    }
    this.categoryTypeService.findAllByFillter({ filters })
      .subscribe(res => {
        this.categoryTypeList = res?.data || [];
      });
  }

  loadCategoryList() {
    const filters = [
      {
        key: 'categoryTypeId',
        value: this.selectedCategoryType.id,
        operator: SEARCH_OPERATION.EQUAL,
      }
    ]
    this.categoryService.findAllByFillter({ filters })
      .subscribe(res => {
        this.categoryList = res?.data || [];
      });
  }

  onSearchCategory() {
    const filters: any = [
      {
        key: 'categoryTypeId',
        value: this.selectedCategoryType?.id,
        operator: SEARCH_OPERATION.EQUAL,
      }
    ]
    if (!!this.keySearchCategoryCode && this.keySearchCategoryCode.length > 0) {
      filters.push({
        key: 'code',
        value: this.keySearchCategoryCode,
        operator: SEARCH_OPERATION.MATCH,
      })
    }
    if (!!this.keySearchCategoryName && this.keySearchCategoryName.length > 0) {
      filters.push({
        key: 'name',
        value: this.keySearchCategoryName,
        operator: SEARCH_OPERATION.MATCH,
      })
    }
    this.categoryService.findAllByFillter({ filters })
      .subscribe(res => {
        this.categoryList = res?.data || [];
      });
  }

  onCategoryTypeSelect(event: any) {
    this.loadCategoryList();
  }
}
