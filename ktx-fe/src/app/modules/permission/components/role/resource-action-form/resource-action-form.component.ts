import { Component, Injector } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { DialogService, DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { ACTION_FORM, RESOURCE } from 'src/app/core/app-config';
import { BaseComponent } from 'angularx-score';
import { RoleService } from '../../../services/role.service';
import { AddResourceComponent } from '../add-resource/add-resource.component';
import * as _ from 'lodash';
import { CommonUtils } from 'angularx-score';

@Component({
  selector: 'app-resource-action-form',
  templateUrl: './resource-action-form.component.html',
  styleUrls: ['./resource-action-form.component.scss']
})
export class ResourceActionFormComponent extends BaseComponent {
  keySearch: string = '';
  resourceList = [];
  filteredResourceList = [];
  ref: DynamicDialogRef | undefined;
  roleCode = '';
  expandedRows: any = {};
  constructor(
    public _injector: Injector,
    actr: ActivatedRoute,
    public translate: L10nTranslationService,
    public dynamicDialogRef: DynamicDialogRef,
    public config: DynamicDialogConfig,
    public dialogService: DialogService,
    public roleService: RoleService,
  ) {
    super(_injector, actr, RESOURCE.ROLE, ACTION_FORM.UPDATE);
    const { roleCode } = this.config?.data;
    this.roleCode = roleCode;
    this.loadRoleResource();
  }


  onSearch() {
    const _key = this.keySearch?.trim().toUpperCase() || '';
    if (_key.length == 0) {
      this.filteredResourceList = this.resourceList;
      return;
    }
    this.filteredResourceList = this.resourceList.filter((e: any) => e['code'].toUpperCase().includes(_key) || e['name'].toUpperCase().includes(_key));
  }

  loadRoleResource() {
    this.roleService.findRoleResource(this.roleCode).subscribe(res => {
      let { resourceList, actionList, resourceActionList, roleResourceActionList } = res?.data;
      const resourceActionGroup = _.groupBy(resourceActionList, 'resourceCode');
      const roleResourceActionGroup = _.groupBy(roleResourceActionList, 'resourceCode');
      // const actionKeyBy = _.keyBy(actionList, 'code');
      resourceList.forEach((item: any) => {
        const actionCodeList = resourceActionGroup[item.code]?.map(e => e.actionCode) || [];
        const actions = actionList.filter((e: any) => actionCodeList.includes(e.code)) || [];
        item.actions = actions || [];

        // selected
        const selectedActionCodeList = roleResourceActionGroup[item.code]?.map(e => e.actionCode) || [];
        const selectedActions = actionList.filter((e: any) => selectedActionCodeList.includes(e.code)) || [];
        item.selectedActions = selectedActions || [];
      });
      this.resourceList = resourceList;
      this.onSearch();
    })
  }

  onClose() {
    this.dynamicDialogRef.close();
  }

  addResource() {
    this.ref = this.dialogService.open(AddResourceComponent, {
      header: `Thêm tài nguyên`,
      width: CommonUtils.setWidthDiaglog('30%'),
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      data: {
        roleCode: this.roleCode
      }
    });
    this.ref.onClose.subscribe((res) => {
      if (res) {
        this.loadRoleResource();
      }
    });
  }

  onRemove(item: any, index: number) {
    this.confirmMessage('Bạn có muốn xóa thông tin?', () => {// on accepted
      this.roleService.deleteRoleResource(this.roleCode, item.code)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            this.filteredResourceList.splice(index, 1);
            const idx = this.resourceList.findIndex((e: any) => e.code == item.code);
            if (idx >= 0) {
              this.resourceList.splice(idx, 1);
            }
          }
        });
    }, () => {// on rejected
    });
  }

  onEdit(item: any, index: number, expanded: boolean) {
    item.editing = true;
    item.oldValue = item.selectedActions;
    this.expandedRows[item.code] = true;
  }

  onRowEditCancel(item: any, index: number) {
    item.editing = false;
    // rollback data
    item.selectedActions = item.oldValue;
  }

  onRowEditSave(item: any) {
    const formData = {
      roleCode: this.roleCode,
      resourceCode: item.code,
      actionCodeList: item.selectedActions?.map((e: any) => e.code) || []
    }
    this.confirmMessage(this.translate.translate('common.label.confirmSave'), () => {// on accepted
      this.roleService.saveRoleResourceAction(formData)
        .subscribe(res => {
          if (this.requestIsSuccess(res)) {
            item.editing = false;
          }
        });
    }, () => {// on rejected
    });
  }
}
