import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodCartRemoveItemComponent } from './food-cart-remove-item.component';

describe('FoodCartRemoveItemComponent', () => {
  let component: FoodCartRemoveItemComponent;
  let fixture: ComponentFixture<FoodCartRemoveItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodCartRemoveItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodCartRemoveItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
