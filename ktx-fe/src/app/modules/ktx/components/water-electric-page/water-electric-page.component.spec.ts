import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WaterElectricPageComponent } from './water-electric-page.component';

describe('WaterElectricPageComponent', () => {
  let component: WaterElectricPageComponent;
  let fixture: ComponentFixture<WaterElectricPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WaterElectricPageComponent]
    });
    fixture = TestBed.createComponent(WaterElectricPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
