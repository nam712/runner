import { ChangeDetectionStrategy, ChangeDetectorRef, Component, Injector, OnInit } from '@angular/core';
import { HelperService } from 'angularx-score';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  title = 'erp-web-app';
  helperService!: HelperService;
  processLoad = true;

  constructor(
    public injector: Injector,
    private cdr: ChangeDetectorRef
  ) {
    this.helperService = this.injector.get(HelperService);
    
  }

  ngOnInit(): void {
    this.helperService.PROCESS_LOADER.subscribe(res => {
      if (res) {
        this.processLoad = true;
      } else {
        this.processLoad = false;
      }
      this.cdr.detectChanges();
    });
  }
}
