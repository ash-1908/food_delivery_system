import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemViewItemComponent } from './item-view-item.component';

describe('ItemViewItemComponent', () => {
  let component: ItemViewItemComponent;
  let fixture: ComponentFixture<ItemViewItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemViewItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemViewItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
