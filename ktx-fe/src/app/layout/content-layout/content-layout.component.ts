import { AfterViewInit, ChangeDetectorRef, Component } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { NavigationEnd, Router } from '@angular/router';
import { filter } from 'rxjs';
import * as _ from 'lodash';
import { HrStorage } from 'angularx-score';

@Component({
  selector: 'app-content-layout',
  templateUrl: './content-layout.component.html',
  styleUrls: ['./content-layout.component.scss']
})
export class ContentLayoutComponent {
  items: MenuItem[] | undefined;

  home: MenuItem | undefined;

  constructor(
    private _router: Router,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit() {
    const { userMenuList } = HrStorage.getUserToken() || {};
    const menu = this.makeCatTree(userMenuList);
    let routerUrl: string, routerList: Array<any>;
    this._router.events.pipe(filter(event => event instanceof NavigationEnd)).subscribe((router: any) => {
      const readCrumbList: any[] = [];
      if (router.url) {
        routerUrl = router.url;
        // routerList = routerUrl.slice(1).split('/');
        // this.getBreadCrumbList(readCrumbList, routerList, menu);
        // this.items = readCrumbList;
        const readCrumbList2: any[] = [];
        this.getBreadCrumbList2(readCrumbList2, routerUrl, menu);
        this.items = readCrumbList2;
      }
    });

    this.listenRouting();
    this.cdr.detectChanges();
    this.home = { icon: 'pi pi-home', routerLink: '/' };
  }

  listenRouting(): void {
    const { userMenuList } = HrStorage.getUserToken() || {};
    const menu = this.makeCatTree(userMenuList);
    // tslint:disable-next-line: one-variable-per-declaration
    let routerUrl: string, routerList: Array<any>;
    const readCrumbList: any[] = [];
    if (this._router.url) {
      routerUrl = this._router.url;
      // routerList = routerUrl.slice(1).split('/');
      // this.getBreadCrumbList(readCrumbList, routerList, menu);
      // this.items = readCrumbList;

      const readCrumbList2: any[] = [];
      this.getBreadCrumbList2(readCrumbList2, routerUrl, menu);
      this.items = readCrumbList2;

    }
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

  getBreadCrumbList(items: any[], routerList: any[], menu: any[]): void {
    if (!menu) {
      return;
    }
    routerList.forEach((element, index) => {
      menu.forEach(m => {
        const link = m.routerLink?.slice(1).split('/')[1];
        if (element.toUpperCase().replaceAll('-', '_') === m?.value?.toUpperCase().replaceAll('-', '_') && m.items && m.items.length > 0) {
          items.push({ label: m.label });
          this.getBreadCrumbList(items, routerList.slice(index + 1), m.items);
        } else if (element.toUpperCase().replaceAll('-', '_') === link?.toUpperCase().replaceAll('-', '_')) {
          items.push({ label: m.label, routerLink: m?.routerLink });
          this.getBreadCrumbList(items, routerList.slice(index + 1), m.items);
        }
      });
    });
  }

  getBreadCrumbList2(items: any[], routerUrl: string, menu: any[]): any {
    if (!menu) {
      return false;
    }
    for (let i = 0; i < menu.length; i++) {
      const m = menu[i];
      if (routerUrl?.includes(m.routerLink)) {
        items.unshift({ label: m.label, routerLink: m?.routerLink });
        return true;
      }
      const check = this.getBreadCrumbList2(items, routerUrl, m.items)
      if (check) {
        items.unshift({ label: m.label });
        return check;
      }
    }
  }
}
