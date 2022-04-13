import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodCartAddComponent } from './food-cart-add.component';

describe('FoodCartAddComponent', () => {
  let component: FoodCartAddComponent;
  let fixture: ComponentFixture<FoodCartAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodCartAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodCartAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
