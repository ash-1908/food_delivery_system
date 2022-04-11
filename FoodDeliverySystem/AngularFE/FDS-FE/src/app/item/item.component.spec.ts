import{ComponentFixture, TestBud} from '@angular/core/testing';
import { ItemComponent } from './item.component';

describe('ItemComponent', () => {
    let Component:  ItemComponent;
    let fixture:ComponentFixture<ItemComponent>;

    beforeEach(async ()=> {
        await TestBud.configureTestingModule({
            declarations: [ ItemComponent]
        })
        .compileComponents();
    });
    beforeEach(() => {
        fixture=TestBud.createComponent(ItemComponent);
        component= fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create',()=> {
        expect(component).toBeTruthy();
    });

   });