import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { EmployeeService } from '../../services/employee.service';
import { Router } from '@angular/router';
import { OBJ_TYPE_OPTIONS, RESOURCE } from 'src/app/core/app-config';
import { ChooseFileImportDialogComponent } from 'angularx-score';
import { CommonUtils } from 'angularx-score';
import { OrganizationService } from '../../services/organization.service';

@Component({
  selector: 'app-employee-page',
  templateUrl: './employee-page.component.html',
  styleUrls: ['./employee-page.component.scss']
})
export class EmployeePageComponent extends BaseComponent {
  formSearch: FormGroup;
  formConfig = {
    organizationWork: [''],
    code: [''],
    fullname: [''],
  };
  dataTable: any = {};
  OBJ_TYPE_OPTIONS = OBJ_TYPE_OPTIONS;
  tableValue = [];
  ref: DynamicDialogRef | undefined;
  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public empService: EmployeeService,
    public orgService: OrganizationService,
    private router: Router
  ) {
    super(_injector);
    this.formSearch = this.buildForm({}, this.formConfig);
    this.doSearch();
  }

  doSearch(event?: any) {
    if (!event) {
      event = {rows : 10, resetTable: true};
    }
    this.empService.search(this.formSearch.value, event)
    .subscribe(res => {
      const source = res?.data || {};
      this.dataTable = source;
      this.dataTable.first = parseInt(this.dataTable.first);
      this.tableValue = source.data || [];
      this.tableValue.forEach((e: any) => {
        e.typeName = OBJ_TYPE_OPTIONS.find(x => x.value === e.type)?.label;
      })
    });
  }

  get f() {
    return this.formSearch.controls;
  }

  prepareCreateOrUpdate(id: number) {
    if (!id) {
      this.router.navigate(['/bien-che-to-chuc/ho-so/create']);
    } else {
      this.router.navigate([`/bien-che-to-chuc/ho-so/${id}/update`]);
    }
  }

  onDeleteEmp(id: number) {
    this.confirmMessage('Bạn có muốn xóa thông tin?', () => {// on accepted
      this.empService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }
}
