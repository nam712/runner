import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppHeaderComponent } from './app-header/app-header.component';
import { AppSidebarComponent } from './app-sidebar/app-sidebar.component';
import { AppFooterComponent } from './app-footer/app-footer.component';
import { PanelMenuModule } from 'primeng/panelmenu';
import { SidebarModule } from 'primeng/sidebar';
import { ButtonModule } from 'primeng/button';
import { AvatarModule } from 'primeng/avatar';
import { ScrollPanelModule } from 'primeng/scrollpanel';
import { SplitButtonModule } from 'primeng/splitbutton';

@NgModule({
  declarations: [
    AppHeaderComponent,
    AppSidebarComponent,
    AppFooterComponent
  ],
  exports: [
    AppHeaderComponent,
    AppSidebarComponent,
    AppFooterComponent
  ],
  imports: [
    CommonModule,
    PanelMenuModule,
    SidebarModule,
    ButtonModule,
    AvatarModule,
    ScrollPanelModule,
    SplitButtonModule
  ]
})
export class LayoutModule { }
