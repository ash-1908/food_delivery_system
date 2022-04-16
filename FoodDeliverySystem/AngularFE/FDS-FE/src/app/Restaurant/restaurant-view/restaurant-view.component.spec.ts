import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RestaurantViewAllComponent } from './restaurant-view.component';


describe('RestaurantViewComponent', () => {
  let component: RestaurantViewAllComponent;
  let fixture: ComponentFixture<RestaurantViewAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantViewAllComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantViewAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
