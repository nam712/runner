import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { KtxRoutingModule } from './ktx-routing.module';
import { ContractPageComponent } from './components/contract-page/contract-page.component';
import { ContractFormComponent } from './components/contract-form/contract-form.component';
import { RoomTypePageComponent } from './components/room-type-page/room-type-page.component';
import { RoomTypeFormComponent } from './components/room-type-form/room-type-form.component';
import { SharedModule } from 'angularx-score';
import { RoomPageComponent } from './components/room-page/room-page.component';
import { RoomFormComponent } from './components/room-form/room-form.component';
import { WaterElectricPageComponent } from './components/water-electric-page/water-electric-page.component';
import { WaterElectricFormComponent } from './components/water-electric-form/water-electric-form.component';
import { WaterElectricBillPageComponent } from './components/water-electric-bill-page/water-electric-bill-page.component';
import { WaterElectricBillFormComponent } from './components/water-electric-bill-form/water-electric-bill-form.component';
import { WaterElectricBillDetailComponent } from './components/water-electric-bill-detail/water-electric-bill-detail.component';
import { RoomStudentComponent } from './components/room-student/room-student.component';


@NgModule({
  declarations: [
    ContractPageComponent,
    ContractFormComponent,
    RoomTypePageComponent,
    RoomTypeFormComponent,
    RoomPageComponent,
    RoomFormComponent,
    WaterElectricPageComponent,
    WaterElectricFormComponent,
    WaterElectricBillPageComponent,
    WaterElectricBillFormComponent,
    WaterElectricBillDetailComponent,
    RoomStudentComponent
  ],
  imports: [
    CommonModule,
    KtxRoutingModule,
    SharedModule
  ]
})
export class KtxModule { }
