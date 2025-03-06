import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { CONFIG } from 'src/app/core/app-config';
import { BaseService } from 'angularx-score';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ContractService extends BaseService {

  constructor(public _injector: Injector) {
    super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['contract'], 'contract');
  }

  public cancelContract(code: string): Observable<any> {
    const url = `${this.baseUrl}/cancel/${code}`;
    return this.postRequest(url, {});
  }
}
