import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { BaseComponent, CommonUtils, ValidationService } from 'angularx-score';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { WaterElectricService } from '../../services/water-electric.service';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import { RoomService } from '../../services/room.service';
import { KTXCommonUtils } from 'src/app/shared/ktx-common-utils.service';

@Component({
  selector: 'app-water-electric-form',
  templateUrl: './water-electric-form.component.html',
  styleUrls: ['./water-electric-form.component.scss']
})
export class WaterElectricFormComponent extends BaseComponent {
  formConfig = {
    id: [null],
    month: [new Date().getMonth() + 1, [ValidationService.required]],
    year: [new Date().getFullYear(), [ValidationService.required]],
    roomCode: ['', [ValidationService.required]],
    type: ['ELECTRIC', [ValidationService.required]],
    oldNumeral: ['', [ValidationService.required, ValidationService.positiveInteger]],
    newNumeral: ['', [ValidationService.required, ValidationService.positiveInteger]],
  };
  formSave: FormGroup;
  roomList = [];
  yearList = [];
  monthList = [];
  typeOptions = [
    { value: 'ELECTRIC', label: 'Điện' },
    { value: 'WATER', label: 'Nước' },
  ]
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public roomService: RoomService,
    public waterElectricService: WaterElectricService,
  ) {
    super(_injector, actr, RESOURCE.WATER_ELECTRIC, ACTION_FORM.INSERT);
    this.formSave = this.buildForm(config?.data || {}, this.formConfig);
    this.loadRoomList();
    this.yearList = KTXCommonUtils.createYearOptions();
    this.monthList = KTXCommonUtils.createMonthOptions();
  }

  get f() {
    return this.formSave.controls;
  }


  onSave() {
    if (!CommonUtils.isValidForm(this.formSave)) {
      return;
    }
    this.confirmMessage(this.translate.translate('common.label.confirmSave'), () => {// on accepted
      this.waterElectricService.saveOrUpdate(this.formSave.value)
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


  loadNearestWaterElectric() {
    const { month, year, roomCode, type } = this.formSave.value || {};
    if (!month || !year || !roomCode || !type) {
      return;
    }
    this.waterElectricService.getNearestWaterElectric({ month, year, roomCode, type }).subscribe(res =>{
      this.f['oldNumeral'].setValue(res?.data?.newNumeral || '');
    })
  }
}

