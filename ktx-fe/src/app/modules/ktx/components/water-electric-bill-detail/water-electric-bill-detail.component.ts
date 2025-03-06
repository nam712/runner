import { Component, Injector } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { BaseComponent } from 'angularx-score';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { WaterElectricBillService } from '../../services/water-electric-bill.service';

@Component({
  selector: 'app-water-electric-bill-detail',
  templateUrl: './water-electric-bill-detail.component.html',
  styleUrls: ['./water-electric-bill-detail.component.scss']
})
export class WaterElectricBillDetailComponent extends BaseComponent {
  detail: any = {};
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public waterElectricService: WaterElectricBillService,
  ) {
    super(_injector);
    this.detail = config?.data;
  }
}
