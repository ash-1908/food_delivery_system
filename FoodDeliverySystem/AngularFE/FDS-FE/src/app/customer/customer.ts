import { Address } from "../address/address";

export class Customer{

	public  customerId:string;
	public  firstName:string;
	public  lastName:string;
	public  age:number;
	public  gender:string;
	public  mobileNumber:string;
	public  email:string;
	public  address:Address;
    public List<FoodCart> cartList:FoodCart;
}