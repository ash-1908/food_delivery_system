import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemViewAllItemsResComponent } from './item-view-all-items-res.component';

describe('ItemViewAllItemsResComponent', () => {
  let component: ItemViewAllItemsResComponent;
  let fixture: ComponentFixture<ItemViewAllItemsResComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemViewAllItemsResComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemViewAllItemsResComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
