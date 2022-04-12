import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemViewAllItemsNameComponent } from './item-view-all-items-name.component';

describe('ItemViewAllItemsNameComponent', () => {
  let component: ItemViewAllItemsNameComponent;
  let fixture: ComponentFixture<ItemViewAllItemsNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemViewAllItemsNameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemViewAllItemsNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
