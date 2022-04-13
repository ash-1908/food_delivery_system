import{ Category } from "../category/category";
import { Restaurant } from "../Restaurant/Restaurant";

export class Item{
    public itemId:string;
    public itemName:string;
    public category: Category;
    public quantity: number;
    public cost:DoubleRange;
    public restaurant:Restaurant[]=[];


}
