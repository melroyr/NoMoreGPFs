import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HelloCityComponent } from './hello-city.component';

describe('HelloCityComponent', () => {
  let component: HelloCityComponent;
  let fixture: ComponentFixture<HelloCityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HelloCityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HelloCityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
