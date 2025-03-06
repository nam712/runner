import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { CONFIG } from 'src/app/core/app-config';
import { BaseService } from 'angularx-score';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrganizationService extends BaseService {

  constructor(public _injector: Injector) {
    super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['organization'], 'organization');
  }

  public initOrgTree(): Observable<any> {
    const url = `${this.baseUrl}/init-org-tree`;
    return this.getRequest(url);
  }

  public getChildOrg(parentId: number): Observable<any> {
    const url = `${this.baseUrl}/child-org/${parentId}`;
    return this.getRequest(url);
  }

  public getByCode(orgCode: string): Observable<any> {
    const url = `${this.baseUrl}/get-by-code/${orgCode}`;
    return this.getRequest(url);
  }
}
