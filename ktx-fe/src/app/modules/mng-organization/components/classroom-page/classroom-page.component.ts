import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { ClassroomService } from '../../services/classroom.service';
import { ClassroomFormComponent } from '../classroom-form/classroom-form.component';
import { CommonUtils } from 'angularx-score';
import { Router } from '@angular/router';

@Component({
  selector: 'app-classroom-page',
  templateUrl: './classroom-page.component.html',
  styleUrls: ['./classroom-page.component.scss']
})
export class ClassroomPageComponent extends BaseComponent {
  formSearch: FormGroup;
  formConfig = {
    code: [''],
    name: [''],
  };
  dataTable: any = {};
  ref: DynamicDialogRef | undefined;
  trainingCourseList = [];
  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public classroomService: ClassroomService,
    private router: Router
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
    this.classroomService.search(this.formSearch.value, event)
    .subscribe(res => {
      const source = res?.data || {};
      this.dataTable = source;
      this.dataTable.first = parseInt(this.dataTable.first);
    });
  }

  prepareCreateOrUpdate(id: number) {
    let data = null;
    if (!!id) {
      this.classroomService.findOne(id).subscribe(res => {
        data = res?.data;
        this.handleOpenDialog(data);
      })
    } else {
      this.handleOpenDialog(data);
    }
  }


  handleOpenDialog(data?: any) {
    this.ref = this.dialogService.open(ClassroomFormComponent, {
      header: 'Lớp',
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
      this.classroomService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }

  onMngStudent(id: number) {
    this.router.navigate([`/bien-che-to-chuc/lop/${id}/sinh-vien`]);
  }
}