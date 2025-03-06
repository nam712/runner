import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { BaseComponent, CommonUtils, ValidationService } from 'angularx-score';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RoomService } from '../../services/room.service';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import { RoomTypeService } from '../../services/room-type.service';

@Component({
  selector: 'app-room-form',
  templateUrl: './room-form.component.html',
  styleUrls: ['./room-form.component.scss']
})
export class RoomFormComponent extends BaseComponent {
  formConfig = {
    id: [null],
    code: ['', [ValidationService.required, ValidationService.maxLength(20)]],
    name: ['', [ValidationService.required, ValidationService.maxLength(200)]],
    roomTypeCode: ['', [ValidationService.required]],
    amount: ['', [ValidationService.required, ValidationService.positiveInteger]],
    
  };
  formSave: FormGroup;
  roomTypeList = [];
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public roomService: RoomService,
    public roomTypeService: RoomTypeService,
  ) {
    super(_injector, actr, RESOURCE.ROOM, ACTION_FORM.INSERT);
    this.formSave = this.buildForm(config?.data || {}, this.formConfig);
    this.loadRoomTypeList();
  }

  get f() {
    return this.formSave.controls;
  }


  onSave() {
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    this.confirmMessage(this.translate.translate('common.label.confirmSave'), () => {// on accepted
      this.roomService.saveOrUpdate(this.formSave.value)
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

  loadRoomTypeList() {
    this.roomTypeService.findAll().subscribe(res =>{
      this.roomTypeList = res?.data || [];
    })
  }
}

