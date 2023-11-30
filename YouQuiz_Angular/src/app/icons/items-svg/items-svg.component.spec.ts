import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemsSvgComponent } from './items-svg.component';

describe('ItemsSvgComponent', () => {
  let component: ItemsSvgComponent;
  let fixture: ComponentFixture<ItemsSvgComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ItemsSvgComponent]
    });
    fixture = TestBed.createComponent(ItemsSvgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
