import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassroomPageComponent } from './classroom-page.component';

describe('ClassroomPageComponent', () => {
  let component: ClassroomPageComponent;
  let fixture: ComponentFixture<ClassroomPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClassroomPageComponent]
    });
    fixture = TestBed.createComponent(ClassroomPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
