import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SettingsRoutingModule } from './settings-routing.module';
import { SharedModule } from 'angularx-score';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    SharedModule,
    SettingsRoutingModule,
  ]
})
export class SettingsModule { }
