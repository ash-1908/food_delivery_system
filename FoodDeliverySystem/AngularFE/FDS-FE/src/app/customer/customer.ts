import { Address } from "../address/address";
import { FoodCart } from "../foodCart/foodCart";

export class Customer{

	public  customerId:string;
	public  firstName:string;
	public  lastName:string;
	public  age:number;
	public  gender:string;
	public  mobileNumber:string;
	public  email:string;
	public  address:Address;
    public cartList:FoodCart[]=[];
}
