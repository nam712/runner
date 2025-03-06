import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { BaseComponent, CommonUtils, ValidationService } from 'angularx-score';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RoomService } from '../../services/room.service';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import { ContractService } from '../../services/contract.service';
import { StudentService } from 'src/app/modules/mng-organization/services/student.service';

@Component({
  selector: 'app-contract-form',
  templateUrl: './contract-form.component.html',
  styleUrls: ['./contract-form.component.scss']
})
export class ContractFormComponent extends BaseComponent {
  formConfig = {
    id: [null],
    code: ['', []],
    studentCode: ['', [ValidationService.required]],
    roomCode: ['', [ValidationService.required]],
    fromDate: ['', [ValidationService.required]],
    toDate: ['', []],
    status: ['', []],
  };
  formSave: FormGroup;
  roomList = [];
  studentList = [];
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public roomService: RoomService,
    public studentService: StudentService,
    public contractService: ContractService,
  ) {
    super(_injector, actr, RESOURCE.ROOM_TYPE, ACTION_FORM.INSERT);
    this.formSave = this.buildForm(config?.data || {}, this.formConfig);
    this.loadRoomList();
    this.loadStudentList();
  }

  get f() {
    return this.formSave.controls;
  }


  onSave() {
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    this.confirmMessage(this.translate.translate('common.label.confirmSave'), () => {// on accepted
      this.contractService.saveOrUpdate(this.formSave.value)
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

  loadRoomList() {
    this.roomService.findAll().subscribe(res =>{
      this.roomList = res?.data || [];
    })
  }

  loadStudentList() {
    this.studentService.findAll().subscribe(res => {
      this.studentList = (res?.data || []).map((e: any) => ({ ...e, displayName: `${e.code} - ${e.fullname}`}));
    })
  }
}

