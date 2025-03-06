import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { CONFIG } from 'src/app/core/app-config';
import { BaseService } from 'angularx-score';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RoleService extends BaseService {

  constructor(public _injector: Injector) {
    super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['role'], 'role');
  }
  public findRoleMenu(roleId: number): Observable<any> {
    const buildParams = this.commonUtil.buildParams({ roleId });
    const url = `${this.baseUrl}/role-menu?`;
    return this.getRequest(url, { params: buildParams });
  }

  public saveRoleMenu(item: any): Observable<any> {
    const url = `${this.baseUrl}/role-menu`;
    return this.postRequest(url, this.commonUtil.convertData(item));
  }

  public saveRoleResourceAction(item: any): Observable<any> {
    const url = `${this.baseUrl}/role-resource-action`;
    return this.postRequest(url, this.commonUtil.convertData(item));
  }

  public saveRoleResource(item: any): Observable<any> {
    const url = `${this.baseUrl}/role-resource`;
    return this.postRequest(url, this.commonUtil.convertData(item));
  }

  public findRoleResource(roleCode: string): Observable<any> {
    const buildParams = this.commonUtil.buildParams({ roleCode });
    const url = `${this.baseUrl}/role-resource?`;
    return this.getRequest(url, { params: buildParams });
  }

  public deleteRoleResource(roleCode: string, resourceCode: string): Observable<any> {
    const url = `${this.baseUrl}/role-resource/${roleCode}/${resourceCode}`;
    return this.deleteRequest(url);
  }
}
