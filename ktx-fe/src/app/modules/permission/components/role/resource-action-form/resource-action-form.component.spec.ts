import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourceActionFormComponent } from './resource-action-form.component';

describe('ResourceActionFormComponent', () => {
  let component: ResourceActionFormComponent;
  let fixture: ComponentFixture<ResourceActionFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResourceActionFormComponent]
    });
    fixture = TestBed.createComponent(ResourceActionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
