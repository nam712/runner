import { Component, Injector } from '@angular/core';
import { Router } from '@angular/router';
import { L10nTranslationService } from 'angular-l10n';
import { EmployeeService } from 'src/app/modules/mng-organization/services/employee.service';
import { BaseComponent } from 'angularx-score';
import { HomeService } from '../../services/home.service';
import { Filter, FilterModel, Order } from 'angularx-score';
import { FormControl } from '@angular/forms';
import { CLASSROOM_STATUS } from 'src/app/core/app-config';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent extends BaseComponent {
  
  constructor(
    private _injector: Injector,
    public homeService: HomeService,
    private router: Router,
    public translate: L10nTranslationService,
    
  ) {
    super(_injector);
    
  }
}
