/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rupanshiguliani
 */
public class Products {
        String productname ;
        String desc ;
        int price ;
        int offerprice ;
        String category ;
        int quantity;
        
        public Products(String productname,String desc,String category,int price,int offerprice,int quantity ){
        this.productname = productname;
        this.desc = desc;
        this.category = category ;
        this.price= price ;
        this.offerprice = offerprice ;
        this.quantity = quantity;
    } 
    
}
