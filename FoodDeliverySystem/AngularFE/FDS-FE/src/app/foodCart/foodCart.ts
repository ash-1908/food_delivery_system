import { Customer } from "../customer/customer";

export class FoodCart{
 public cartId:string;
 public customer: Customer;
 public  itemList: FoodCart[]=[];
}