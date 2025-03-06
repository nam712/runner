import { Routes } from "@angular/router";
import { HomeModule } from "src/app/modules/home/home.module";
import { MngOrganizationModule } from "src/app/modules/mng-organization/mng-organization.module";
import { PermissionModule } from "src/app/modules/permission/permission.module";
import { SettingsModule } from "src/app/modules/settings/settings.module";
import { KtxModule } from "./modules/ktx/ktx.module";

export const CONTENT_ROUTES: Routes = [
    {
        path: '',
        loadChildren: () => HomeModule
    },
    {
        path: 'setting',
        loadChildren: () => SettingsModule
    },
    {
        path: 'bien-che-to-chuc',
        loadChildren: () => MngOrganizationModule
    },
    {
        path: 'ktx',
        loadChildren: () => KtxModule
    },
    {
        path: 'permission',
        loadChildren: () => PermissionModule
    },
]