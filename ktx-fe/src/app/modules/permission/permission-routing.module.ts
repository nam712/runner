import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RolePageComponent } from './components/role/role-page/role-page.component';
import { UserPageComponent } from './components/user/user-page/user-page.component';

const routes: Routes = [
  {
    path: 'role',
    component: RolePageComponent,
  },
  {
    path: 'user',
    component: UserPageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PermissionRoutingModule { }
