import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { CONFIG } from 'src/app/core/app-config';
import { BaseService } from 'angularx-score';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class WaterElectricService extends BaseService {

  constructor(public _injector: Injector) {
    super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['waterElectric'], 'waterElectric');
  }

  public getNearestWaterElectric(params: any): Observable<any> {
    const url = `${this.baseUrl}/nearest`;
    return this.getRequest(url, { params: params });
  }
}
