import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrganizationPageComponent } from './components/organization-page/organization-page.component';
import { EmployeePageComponent } from './components/employee-page/employee-page.component';
import { EmployeeFormComponent } from './components/employee-form/employee-form.component';
import { ClassroomPageComponent } from './components/classroom-page/classroom-page.component';
import { ClassroomStudentPageComponent } from './components/classroom-student-page/classroom-student-page.component';
import { StudentPageComponent } from './components/student-page/student-page.component';

const routes: Routes = [
  {
    path: 'khoa',
    component: OrganizationPageComponent,
  },
  {
    path: 'lop',
    component: ClassroomPageComponent,
  },
  {
    path: 'ho-so',
    component: EmployeePageComponent,
  },
  {
    path: 'ho-so/create',
    component: EmployeeFormComponent,
  },
  {
    path: 'ho-so/:id/update',
    component: EmployeeFormComponent,
  },
  {
    path: 'lop/:id/sinh-vien',
    component: ClassroomStudentPageComponent,
  },
  {
    path: 'sinh-vien',
    component: StudentPageComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MngOrganizationRoutingModule { }
