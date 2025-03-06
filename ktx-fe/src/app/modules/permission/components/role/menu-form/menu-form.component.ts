import { Component, Injector } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { RoleService } from '../../../services/role.service';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import * as _ from 'lodash';
import { TreeNode } from 'primeng/api';
import { CommonUtils } from 'angularx-score';

@Component({
  selector: 'app-menu-form',
  templateUrl: './menu-form.component.html',
  styleUrls: ['./menu-form.component.scss']
})
export class MenuFormComponent extends BaseComponent {
  menus!: TreeNode[];

  selectedMenus!: TreeNode[];
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public roleService: RoleService,
  ) {
    super(_injector, actr, RESOURCE.ROLE, ACTION_FORM.UPDATE);
    this.loadData();
  }

  loadData() {
    const { roleId } = this.config?.data;
    this.roleService.findRoleMenu(roleId)
    .subscribe(res => {
      let { menuList, menuCodeList } = res.data;
      menuCodeList = menuCodeList || [];
      menuList = menuList.map((e: any) => ({ 
        ...e
        , parentCode: e.parentCode || 'root'
        , key: e.code
        , label: e.name
      }))
      this.menus = this.makeCatTree(menuList);
      this.selectedMenus = menuList.filter((e: any) => menuCodeList.includes(e.code));
      this.menus = this.menus.map((e: any) => ({
        ...e,
        partialSelected: this.updatePartialSelected(e, menuCodeList)
      }))
    });
  }


  updatePartialSelected(item: any, menuCodeList: any) : boolean {
    if (!item.children || item.children.length == 0) {
      return false;
    }
    const temp = item.children.filter((e: any) => menuCodeList.includes(e.code)) || [];
    return temp.length > 0 && temp.length != item.children.length;
  }

  makeCatTree(data: any) {
    const rootList = _.orderBy(data.filter((e: any) => e.parentCode == 'root'), ['sortOrder'], ['asc']);;
    const groupedByParents = _.groupBy(data, 'parentCode');
    rootList.forEach((item: any) => {
      item.children = this.findChildren(item, groupedByParents);
    });
    return rootList;
  }

  findChildren(parent: any, groupedByParents: any) {
    const children = groupedByParents[parent.code];
    if (!children || children.length == 0) {
      return children;
    }
    children.forEach((item: any) => {
      const children = this.findChildren(item, groupedByParents);
      item.children = _.orderBy(children, ['sortOrder'], ['asc']);
    });
    return children;
  }

  
  onSave() {
    console.log(' >>> selectedMenus:', this.selectedMenus)
    const menuCodeList = this.selectedMenus.map((e: any) => e.code);
    const { roleId } = this.config?.data;
    const formData = {
      roleId,
      menuCodeList
    }
    this.confirmMessage(this.translate.translate('common.label.confirmSave'), () => {// on accepted
      this.roleService.saveRoleMenu(formData)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.dynamicDialogRef.close(res);
          }
        });
    }, () => {// on rejected
    });
  }

  onClose() {
    this.dynamicDialogRef.close();
  }
}
