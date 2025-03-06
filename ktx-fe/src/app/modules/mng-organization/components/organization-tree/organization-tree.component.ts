import { Component, Injector } from '@angular/core';
import { TreeNode } from 'primeng/api';
import { DialogService } from 'primeng/dynamicdialog';
import { BaseComponent } from 'angularx-score';
import { OrganizationService } from '../../services/organization.service';

@Component({
  selector: 'app-organization-tree',
  templateUrl: './organization-tree.component.html',
  styleUrls: ['./organization-tree.component.scss']
})
export class OrganizationTreeComponent extends BaseComponent {
  orgTree!: TreeNode[];
  loading: boolean = false;
  constructor(
    private _injector: Injector,
    public dialogService: DialogService,
    public orgService: OrganizationService
  ) {
    super(_injector);
    this.orgService.initOrgTree().subscribe(res => {
      this.orgTree = res?.data;
    })
  }

  prepareCreateOrUpdate() {

  }


  nodeExpand(event: any) {
    if (!!event.node.children) {
      return;
    }
    if (event.node) {
        this.loading = true;
        setTimeout(() => {
            this.orgService.getChildOrg(event.node.key).subscribe((res) => {
                event.node.children = res.data;
            });
            this.loading = false;
            // this.cd.markForCheck();
        }, 200);
    }
  }
}
