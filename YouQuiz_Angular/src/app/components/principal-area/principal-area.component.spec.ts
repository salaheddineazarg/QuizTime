import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrincipalAreaComponent } from './principal-area.component';

describe('PrincipalAreaComponent', () => {
  let component: PrincipalAreaComponent;
  let fixture: ComponentFixture<PrincipalAreaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrincipalAreaComponent]
    });
    fixture = TestBed.createComponent(PrincipalAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
