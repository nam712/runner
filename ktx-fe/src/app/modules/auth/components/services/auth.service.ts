import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { CONFIG } from 'src/app/core/app-config';
import { BaseService } from 'angularx-score';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService extends BaseService {

  constructor(public _injector: Injector) {
      super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['auth'], 'auth');
  }

  public login(formData: any): Observable<any> {
    const url = `${this.baseUrl}/login`;
    return this.postRequest(url, this.commonUtil.convertData(formData));
  }

  public getUserInfo(): Observable<any> {
    const url = `${this.baseUrl}/user-info?`;
    return this.getRequest(url, { });
  }
  
  public changePassword(formData: any): Observable<any> {
    const url = `${this.baseUrl}/change-password`;
    return this.postRequest(url, this.commonUtil.convertData(formData));
  }
}
