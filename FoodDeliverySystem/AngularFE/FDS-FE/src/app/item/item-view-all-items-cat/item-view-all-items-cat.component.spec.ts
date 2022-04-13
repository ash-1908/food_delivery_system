import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemViewAllItemsCatComponent } from './item-view-all-items-cat.component';

describe('ItemViewAllItemsCatComponent', () => {
  let component: ItemViewAllItemsCatComponent;
  let fixture: ComponentFixture<ItemViewAllItemsCatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemViewAllItemsCatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemViewAllItemsCatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
