import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HelloInternationComponent } from './hello-internation.component';

describe('HelloInternationComponent', () => {
  let component: HelloInternationComponent;
  let fixture: ComponentFixture<HelloInternationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HelloInternationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HelloInternationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
