import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WaterElectricBillDetailComponent } from './water-electric-bill-detail.component';

describe('WaterElectricBillDetailComponent', () => {
  let component: WaterElectricBillDetailComponent;
  let fixture: ComponentFixture<WaterElectricBillDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WaterElectricBillDetailComponent]
    });
    fixture = TestBed.createComponent(WaterElectricBillDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
