import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { BaseComponent, CommonUtils, ValidationService } from 'angularx-score';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RoomTypeService } from '../../services/room-type.service';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';

@Component({
  selector: 'app-room-type-form',
  templateUrl: './room-type-form.component.html',
  styleUrls: ['./room-type-form.component.scss']
})
export class RoomTypeFormComponent extends BaseComponent {
  formConfig = {
    id: [null],
    code: ['', [ValidationService.required, ValidationService.maxLength(20)]],
    name: ['', [ValidationService.required, ValidationService.maxLength(200)]],
    building: ['', [ValidationService.maxLength(50)]],
  };
  formSave: FormGroup;
  courceList = [];
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public roomTypeService: RoomTypeService,
  ) {
    super(_injector, actr, RESOURCE.ROOM_TYPE, ACTION_FORM.INSERT);
    this.formSave = this.buildForm(config?.data || {}, this.formConfig);
  }

  get f() {
    return this.formSave.controls;
  }


  onSave() {
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    this.confirmMessage(this.translate.translate('common.label.confirmSave'), () => {// on accepted
      this.roomTypeService.saveOrUpdate(this.formSave.value)
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
}

