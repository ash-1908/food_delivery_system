import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodCartClearCartComponent } from './food-cart-clear-cart.component';

describe('FoodCartClearCartComponent', () => {
  let component: FoodCartClearCartComponent;
  let fixture: ComponentFixture<FoodCartClearCartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodCartClearCartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodCartClearCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
