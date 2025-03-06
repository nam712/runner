import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomStudentComponent } from './room-student.component';

describe('RoomStudentComponent', () => {
  let component: RoomStudentComponent;
  let fixture: ComponentFixture<RoomStudentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RoomStudentComponent]
    });
    fixture = TestBed.createComponent(RoomStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
