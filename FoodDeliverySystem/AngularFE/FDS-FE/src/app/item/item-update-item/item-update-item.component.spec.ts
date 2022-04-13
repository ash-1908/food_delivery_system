import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemUpdateItemComponent } from './item-update-item.component';

describe('ItemUpdateItemComponent', () => {
  let component: ItemUpdateItemComponent;
  let fixture: ComponentFixture<ItemUpdateItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemUpdateItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemUpdateItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
