import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WaterElectricFormComponent } from './water-electric-form.component';

describe('WaterElectricFormComponent', () => {
  let component: WaterElectricFormComponent;
  let fixture: ComponentFixture<WaterElectricFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WaterElectricFormComponent]
    });
    fixture = TestBed.createComponent(WaterElectricFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
