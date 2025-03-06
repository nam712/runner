import { HttpClient } from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { CONFIG } from 'src/app/core/app-config';
import { BaseService } from 'angularx-score';
import { HelperService } from 'angularx-score';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryTypeService extends BaseService {

  constructor(public _injector: Injector) {
    // super('sys', 'sysCatType', _httpClient, _helperService);
    super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['categoryType'], 'category-type');
  }

}
