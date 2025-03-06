import { Component, Injector } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { BaseComponent, CommonUtils, ValidationService } from 'angularx-score';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RoomService } from '../../services/room.service';
import { WaterElectricBillService } from '../../services/water-electric-bill.service';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import { KTXCommonUtils } from 'src/app/shared/ktx-common-utils.service';

@Component({
  selector: 'app-water-electric-bill-form',
  templateUrl: './water-electric-bill-form.component.html',
  styleUrls: ['./water-electric-bill-form.component.scss']
})
export class WaterElectricBillFormComponent extends BaseComponent {
  formConfig = {
    month: [new Date().getMonth() + 1, [ValidationService.required]],
    year: [new Date().getFullYear(), [ValidationService.required]],
    roomCodeList: ['', [ValidationService.required]],
    unitPriceWater: ['', [ValidationService.required, ValidationService.positiveInteger]],
    unitPriceElectric: ['', [ValidationService.required, ValidationService.positiveInteger]],
  };
  formSave: FormGroup;
  roomList = [];
  yearList = [];
  monthList = [];
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public roomService: RoomService,
    public waterElectricBillService: WaterElectricBillService,
  ) {
    super(_injector, actr, RESOURCE.WATER_ELECTRIC_BILL, ACTION_FORM.INSERT);
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
      this.waterElectricBillService.createBill(this.formSave.value)
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

}

