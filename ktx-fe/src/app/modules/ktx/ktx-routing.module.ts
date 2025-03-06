import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RoomTypePageComponent } from './components/room-type-page/room-type-page.component';
import { RoomPageComponent } from './components/room-page/room-page.component';
import { ContractPageComponent } from './components/contract-page/contract-page.component';
import { WaterElectricPageComponent } from './components/water-electric-page/water-electric-page.component';
import { WaterElectricBillPageComponent } from './components/water-electric-bill-page/water-electric-bill-page.component';

const routes: Routes = [
  {
    path: 'loai-phong',
    component: RoomTypePageComponent,
  },
  {
    path: 'phong',
    component: RoomPageComponent,
  },
  {
    path: 'hop-dong',
    component: ContractPageComponent,
  },
  {
    path: 'dien-nuoc',
    component: WaterElectricPageComponent,
  },
  {
    path: 'hoa-don',
    component: WaterElectricBillPageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class KtxRoutingModule { }
