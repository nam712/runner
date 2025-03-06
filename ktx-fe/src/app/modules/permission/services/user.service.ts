import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { CONFIG } from 'src/app/core/app-config';
import { BaseService } from 'angularx-score';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService extends BaseService {

  constructor(public _injector: Injector) {
      super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['user'], 'user');
  }

  public resetPassword(id: number): Observable<any> {
    const url = `${this.baseUrl}/reset-password/${id}`;
    return this.postRequest(url, {});
  }
}
