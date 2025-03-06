import { HttpClient } from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { CONFIG } from 'src/app/core/app-config';
import { BaseService } from 'angularx-score';
import { HelperService } from 'angularx-score';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService extends BaseService {

  constructor(public _injector: Injector) {
    super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['category'], 'category');
  }

  public findByTypeCode(typeCode: string): Observable<any> {
    const url = `${this.baseUrl}/filter/${typeCode}`;
    return this.postRequestNoToast(url, {});
  }
}
