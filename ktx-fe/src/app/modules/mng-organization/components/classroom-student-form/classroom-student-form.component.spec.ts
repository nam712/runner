import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassroomStudentFormComponent } from './classroom-student-form.component';

describe('ClassroomStudentFormComponent', () => {
  let component: ClassroomStudentFormComponent;
  let fixture: ComponentFixture<ClassroomStudentFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClassroomStudentFormComponent]
    });
    fixture = TestBed.createComponent(ClassroomStudentFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
