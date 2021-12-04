import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompletedsurveyComponent } from './completedsurvey.component';

describe('CompletedsurveyComponent', () => {
  let component: CompletedsurveyComponent;
  let fixture: ComponentFixture<CompletedsurveyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompletedsurveyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompletedsurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
