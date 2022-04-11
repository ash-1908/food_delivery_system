import{ComponentFixture, TestBud} from '@angular/core/testing';
 import { FoodCartComponent } from './foodcart.component';

 describe('FoodCartComponent', () => {
     let Component: FoodCartComponent;
     let fixture:ComponentFixture<FoodCartComponent>;

     beforeEach(async ()=> {
         await TestBud.configureTestingModule({
             declarations: [ FoodCartComponent]
         })
         .compileComponents();
     });
     beforeEach(() => {
         fixture=TestBud.createComponent(FoodCartComponent);
         component= fixture.componentInstance;
         fixture.detectChanges();
     });

     it('should create',()=> {
         expect(component).toBeTruthy();
     });

    });