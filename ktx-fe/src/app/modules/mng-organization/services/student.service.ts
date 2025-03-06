import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { CONFIG } from 'src/app/core/app-config';
import { BaseService } from 'angularx-score';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StudentService extends BaseService {

  constructor(public _injector: Injector) {
    super(_injector, environment.serverUrl['sys'] + CONFIG.API_PATH['student'], 'student');
  }

  public getTableScoreStudent(studentCode: string): Observable<any> {
    const url = `${this.baseUrl}/table-score`;
    return this.getRequest(url, { params: { studentCode } });
  }

  
  public getStudentSummary(studentCode: string): Observable<any> {
    const url = `${this.baseUrl}/summary`;
    return this.getRequest(url, { params: { studentCode } });
  }
}
