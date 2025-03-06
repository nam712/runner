import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { StudentService } from '../../services/student.service';
import { CommonUtils } from 'angularx-score';
import { StudentFormComponent } from '../student-form/student-form.component';

@Component({
  selector: 'app-student-page',
  templateUrl: './student-page.component.html',
  styleUrls: ['./student-page.component.scss']
})
export class StudentPageComponent extends BaseComponent {
  formSearch: FormGroup;
  formConfig = {
    code: [''],
    fullname: [''],
    classroomCode: [''],
  };
  dataTable: any = {};
  ref: DynamicDialogRef | undefined;
  courceList = [];
  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public studentService: StudentService,
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
    this.studentService.search(this.formSearch.value, event)
    .subscribe(res => {
      const source = res?.data || {};
      this.dataTable = source;
      this.dataTable.first = parseInt(this.dataTable.first);
    });
  }

  prepareCreateOrUpdate(id: number) {
    let data = null;
    if (!!id) {
      this.studentService.findOne(id).subscribe(res => {
        data = res?.data;
        this.handleOpenDialog(data);
      })
    } else {
      this.handleOpenDialog(data);
    }
  }


  handleOpenDialog(data?: any) {
    this.ref = this.dialogService.open(StudentFormComponent, {
      header: !!data?.id ? 'Cập nhật sinh viên' : 'Thêm mới sinh viên',
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
      this.studentService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearch();
          }
        });
    }, () => {// on rejected
    });
  }


}
