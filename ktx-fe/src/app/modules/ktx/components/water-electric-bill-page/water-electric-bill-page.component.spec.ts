import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WaterElectricBillPageComponent } from './water-electric-bill-page.component';

describe('WaterElectricBillPageComponent', () => {
  let component: WaterElectricBillPageComponent;
  let fixture: ComponentFixture<WaterElectricBillPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WaterElectricBillPageComponent]
    });
    fixture = TestBed.createComponent(WaterElectricBillPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
