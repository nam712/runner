import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoryRoutingModule } from './category-routing.module';
import { CategoryPageComponent } from './components/category-page/category-page.component';
import { SharedModule } from 'angularx-score';
import { CategoryTypeFormComponent } from './components/category-type-form/category-type-form.component';
import { CategoryFormComponent } from './components/category-form/category-form.component';


@NgModule({
  declarations: [
    CategoryPageComponent,
    CategoryTypeFormComponent,
    CategoryFormComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    CategoryRoutingModule,
  ]
})
export class CategoryModule { }
