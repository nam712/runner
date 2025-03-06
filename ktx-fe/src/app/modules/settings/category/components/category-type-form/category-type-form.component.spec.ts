import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryTypeFormComponent } from './category-type-form.component';

describe('CategoryTypeFormComponent', () => {
  let component: CategoryTypeFormComponent;
  let fixture: ComponentFixture<CategoryTypeFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CategoryTypeFormComponent]
    });
    fixture = TestBed.createComponent(CategoryTypeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
