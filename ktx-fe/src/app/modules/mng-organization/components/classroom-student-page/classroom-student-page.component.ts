import { Component, Injector, OnInit } from '@angular/core';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { ClassroomService } from '../../services/classroom.service';
import { ActivatedRoute } from '@angular/router';
import { StudentService } from '../../services/student.service';
import { ClassroomStudentFormComponent } from '../classroom-student-form/classroom-student-form.component';
import { CommonUtils } from 'angularx-score';

@Component({
  selector: 'app-classroom-student-page',
  templateUrl: './classroom-student-page.component.html',
  styleUrls: ['./classroom-student-page.component.scss']
})
export class ClassroomStudentPageComponent extends BaseComponent implements OnInit {
  classInfo: any = {};
  classroomId?: any;
  dataTable: any = {};
  ref: DynamicDialogRef | undefined;
  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public classroomService: ClassroomService,
    public studentService: StudentService,
    private route: ActivatedRoute
  ) {
    super(_injector);

  }

  ngOnInit() {
    this.classroomId = this.route.snapshot.paramMap.get('id');
    if (!!this.classroomId) {
      this.classroomService.findOne(this.classroomId).subscribe(res => {
        this.classInfo = res?.data;
        this.doSearchStudent();
      })
    }
  }

  doSearchStudent(event?: any) {
    if (!event) {
      event = {rows : 10, resetTable: true};
    }
    this.studentService.search({
      classroomCode: this.classInfo?.code
    }, event)
    .subscribe(res => {
      const source = res?.data || {};
      this.dataTable = source;
      this.dataTable.first = parseInt(this.dataTable.first);
    });
  }

  prepareCreateOrUpdateStudent(id?: number) {
    let data = {
      classroomCode: this.classInfo.code
    };
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
    this.ref = this.dialogService.open(ClassroomStudentFormComponent, {
      header: !!data?.id ? 'Cập nhật sinh viên' : 'Thêm mới sinh viên',
      width: CommonUtils.setWidthDiaglog('50%'),
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      data: data
    });
    this.ref.onClose.subscribe((res) => {
      if (res) {
        this.doSearchStudent();
      }
    });
  }

  
  onDeleteStudent(id: number) {
    this.confirmMessage('Bạn có muốn xóa thông tin?', () => {// on accepted
      this.studentService.deleteById(id)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.doSearchStudent();
          }
        });
    }, () => {// on rejected
    });
  }
}
