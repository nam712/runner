import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassroomStudentPageComponent } from './classroom-student-page.component';

describe('ClassroomStudentPageComponent', () => {
  let component: ClassroomStudentPageComponent;
  let fixture: ComponentFixture<ClassroomStudentPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClassroomStudentPageComponent]
    });
    fixture = TestBed.createComponent(ClassroomStudentPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
