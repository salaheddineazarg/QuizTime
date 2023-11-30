import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonSvgComponent } from './person-svg.component';

describe('PersonSvgComponent', () => {
  let component: PersonSvgComponent;
  let fixture: ComponentFixture<PersonSvgComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersonSvgComponent]
    });
    fixture = TestBed.createComponent(PersonSvgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
