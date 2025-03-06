import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { ACTION_FORM, GENDER_OPTIONS, RESOURCE } from 'src/app/core/app-config';
import { BaseComponent } from 'angularx-score';
import { ValidationService } from 'angularx-score';
import { StudentService } from '../../services/student.service';
import { CommonUtils } from 'angularx-score';
import { ClassroomService } from '../../services/classroom.service';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.scss']
})
export class StudentFormComponent extends BaseComponent {
  formConfig = {
    id: [null],
    code: ['', [ValidationService.required, ValidationService.maxLength(20)]],
    fullname: ['', [ValidationService.required, ValidationService.maxLength(200)]],
    classroomCode: ['', [ValidationService.required]],
    dateOfBirth: [null],
    address: [null],
    gender: [1],
    phoneNumber: [null],
  };
  formSave: FormGroup;
  courceList = [];
  genderOptions = GENDER_OPTIONS;
  classroomList = [];
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public studentService: StudentService,
    public classroomService: ClassroomService,
  ) {
    super(_injector, actr, RESOURCE.STUDENT, ACTION_FORM.INSERT);
    this.formSave = this.buildForm(config?.data || {}, this.formConfig);
    this.loadClassroom();
  }

  get f() {
    return this.formSave.controls;
  }


  onSave() {
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    this.confirmMessage(this.translate.translate('common.label.confirmSave'), () => {// on accepted
      this.studentService.saveOrUpdate(this.formSave.value)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.dynamicDialogRef.close(res);
          }
        });
    }, () => {// on rejected
    });
  }

  onCancel() {
    this.dynamicDialogRef.close();
  }

  loadClassroom() {
    this.classroomService.findAll().subscribe(res => {
      this.classroomList = res.data || [];
    })
  }
}