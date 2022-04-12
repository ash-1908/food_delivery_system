import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodCartReduceQuantityComponent } from './food-cart-reduce-quantity.component';

describe('FoodCartReduceQuantityComponent', () => {
  let component: FoodCartReduceQuantityComponent;
  let fixture: ComponentFixture<FoodCartReduceQuantityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodCartReduceQuantityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodCartReduceQuantityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
