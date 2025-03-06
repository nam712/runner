import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PermissionRoutingModule } from './permission-routing.module';
import { RolePageComponent } from './components/role/role-page/role-page.component';
import { RoleFormComponent } from './components/role/role-form/role-form.component';
import { SharedModule } from 'angularx-score';
import { MenuFormComponent } from './components/role/menu-form/menu-form.component';
import { ResourceActionFormComponent } from './components/role/resource-action-form/resource-action-form.component';
import { AddResourceComponent } from './components/role/add-resource/add-resource.component';
import { UserPageComponent } from './components/user/user-page/user-page.component';
import { UserFormComponent } from './components/user/user-form/user-form.component';


@NgModule({
  declarations: [
    RolePageComponent,
    RoleFormComponent,
    MenuFormComponent,
    ResourceActionFormComponent,
    AddResourceComponent,
    UserPageComponent,
    UserFormComponent,
  ],
  imports: [
    CommonModule,
    PermissionRoutingModule,
    SharedModule
  ]
})
export class PermissionModule { }
