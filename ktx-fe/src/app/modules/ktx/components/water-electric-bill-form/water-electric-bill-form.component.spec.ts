import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WaterElectricBillFormComponent } from './water-electric-bill-form.component';

describe('WaterElectricBillFormComponent', () => {
  let component: WaterElectricBillFormComponent;
  let fixture: ComponentFixture<WaterElectricBillFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WaterElectricBillFormComponent]
    });
    fixture = TestBed.createComponent(WaterElectricBillFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
