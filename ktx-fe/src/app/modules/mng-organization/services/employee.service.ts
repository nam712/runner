import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { CONFIG } from 'src/app/core/app-config';
import { BaseService } from 'angularx-score';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService extends BaseService {

  constructor(public _injector: Injector) {
    super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['employee'], 'employee');
  }

  public statisticalByType(): Observable<any> {
    const url = `${this.baseUrl}/statistical-type`;
    return this.getRequest(url, { });
  }

  public downloadTemplate(): Observable<any> {
    const url = `${this.baseUrl}/get-template-import`;
    return this.getRequest(url, { responseType: 'blob' });
  }

  public updateTypeDefenseSecurity(item: any): Observable<any> {
    const url = `${this.baseUrl}/update-type-ds`;
    return this.postRequest(url, this.commonUtil.convertData(item));
  }

  public registerDS(id: number): Observable<any> {
    const url = `${this.baseUrl}/register-ds/${id}`;
    return this.postRequest(url, {});
  }

  
  public exportOverall(data?: any): Observable<any> {
    const searchData = this.commonUtil.convertData(data);
    const buildParams = this.commonUtil.buildParams(searchData);
    const url = `${this.baseUrl}/export-overall?`;
    return this.getRequest(url, { params: buildParams, responseType: 'blob'});
  }

}
