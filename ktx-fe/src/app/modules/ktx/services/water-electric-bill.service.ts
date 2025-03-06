import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { CONFIG } from 'src/app/core/app-config';
import { BaseService } from 'angularx-score';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class WaterElectricBillService extends BaseService {

  constructor(public _injector: Injector) {
    super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['waterElectricBill'], 'waterElectricBill');
  }

  public createBill(formData: any): Observable<any> {
    const url = `${this.baseUrl}/create-bill`;
    return this.postRequest(url, this.commonUtil.convertData(formData));
  }

  public pay(code: string): Observable<any> {
    const url = `${this.baseUrl}/pay/${code}`;
    return this.postRequest(url, {});
  }
}
