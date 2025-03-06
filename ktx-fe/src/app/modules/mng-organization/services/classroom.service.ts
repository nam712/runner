import { Injectable, Injector } from '@angular/core';
import { BaseService } from 'angularx-score';
import { Observable } from 'rxjs';
import { CONFIG } from 'src/app/core/app-config';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClassroomService extends BaseService {

  constructor(public _injector: Injector) {
    super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['classroom'], 'classroom');
  }

}
