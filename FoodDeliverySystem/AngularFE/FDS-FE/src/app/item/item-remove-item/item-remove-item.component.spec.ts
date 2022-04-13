import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemRemoveItemComponent } from './item-remove-item.component';

describe('ItemRemoveItemComponent', () => {
  let component: ItemRemoveItemComponent;
  let fixture: ComponentFixture<ItemRemoveItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemRemoveItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemRemoveItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
