import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HelloStateComponent } from './hello-state.component';

describe('HelloStateComponent', () => {
  let component: HelloStateComponent;
  let fixture: ComponentFixture<HelloStateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HelloStateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HelloStateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
