import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomTypePageComponent } from './room-type-page.component';

describe('RoomTypePageComponent', () => {
  let component: RoomTypePageComponent;
  let fixture: ComponentFixture<RoomTypePageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RoomTypePageComponent]
    });
    fixture = TestBed.createComponent(RoomTypePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
