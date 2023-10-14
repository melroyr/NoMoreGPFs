import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HelloNationComponent } from './hello-nation.component';

describe('HelloNationComponent', () => {
  let component: HelloNationComponent;
  let fixture: ComponentFixture<HelloNationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HelloNationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HelloNationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
