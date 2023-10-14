import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HelloLocalComponent } from './hello-local.component';

describe('HelloLocalComponent', () => {
  let component: HelloLocalComponent;
  let fixture: ComponentFixture<HelloLocalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HelloLocalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HelloLocalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
