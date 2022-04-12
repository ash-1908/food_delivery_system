import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodCartIncreaseQuantityComponent } from './food-cart-increase-quantity.component';

describe('FoodCartIncreaseQuantityComponent', () => {
  let component: FoodCartIncreaseQuantityComponent;
  let fixture: ComponentFixture<FoodCartIncreaseQuantityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodCartIncreaseQuantityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodCartIncreaseQuantityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
