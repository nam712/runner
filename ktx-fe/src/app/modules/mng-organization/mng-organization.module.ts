import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MngOrganizationRoutingModule } from './mng-organization-routing.module';
import { OrganizationPageComponent } from './components/organization-page/organization-page.component';
import { EmployeePageComponent } from './components/employee-page/employee-page.component';
import { SharedModule } from 'angularx-score';
import { OrganizationTreeComponent } from './components/organization-tree/organization-tree.component';
import { OrganizationFormComponent } from './components/organization-form/organization-form.component';
import { EmployeeFormComponent } from './components/employee-form/employee-form.component';
import { ClassroomPageComponent } from './components/classroom-page/classroom-page.component';
import { ClassroomFormComponent } from './components/classroom-form/classroom-form.component';
import { ClassroomStudentPageComponent } from './components/classroom-student-page/classroom-student-page.component';
import { ClassroomStudentFormComponent } from './components/classroom-student-form/classroom-student-form.component';
import { StudentPageComponent } from './components/student-page/student-page.component';
import { StudentFormComponent } from './components/student-form/student-form.component';


@NgModule({
  declarations: [
    OrganizationPageComponent,
    EmployeePageComponent,
    OrganizationTreeComponent,
    OrganizationFormComponent,
    EmployeeFormComponent,
    ClassroomPageComponent,
    ClassroomFormComponent,
    ClassroomStudentPageComponent,
    ClassroomStudentFormComponent,
    StudentPageComponent,
    StudentFormComponent,
  ],
  imports: [
    CommonModule,
    MngOrganizationRoutingModule,
    SharedModule
  ]
})
export class MngOrganizationModule { }
