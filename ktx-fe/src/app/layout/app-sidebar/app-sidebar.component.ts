import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { MENU_CONFIG } from './menu';
import * as _ from 'lodash';
import { HrStorage } from 'angularx-score';


@Component({
  selector: 'app-sidebar',
  templateUrl: './app-sidebar.component.html',
  styleUrls: ['./app-sidebar.component.scss']
})
export class AppSidebarComponent {
  items: MenuItem[] = [];

  ngOnInit() {
    const { userMenuList } = HrStorage.getUserToken() || {};

    this.items = this.makeCatTree(userMenuList);
  }

  makeCatTree(data: any) {
    const rootList = _.orderBy(data.filter((e: any) => !e.parentValue), ['sortOrder'], ['asc']);;
    const groupedByParents = _.groupBy(data, 'parentValue');
    rootList.forEach((item: any) => {
      item.items = this.findChildren(item, groupedByParents);
    });
    return rootList;
  }

  findChildren(parent: any, groupedByParents: any) {
    const children = groupedByParents[parent.value];
    if (!children || children.length == 0) {
      return children;
    }
    children.forEach((item: any) => {
      const children = this.findChildren(item, groupedByParents);
      item.items = _.orderBy(children, ['sortOrder'], ['asc']);
    });
    return children;
  }
}
