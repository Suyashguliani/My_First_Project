/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rupanshiguliani
 */
public class Cart {
    String productname;
    String catname;
    
    int quantity;
    int offerprice;
    int perprice;

    public Cart(String productname, String catname, int quantity, int offerprice,int perprice) {
        this.productname = productname;
        this.catname = catname;
        this.quantity = quantity;
        this.offerprice = offerprice;
        this.perprice = perprice;
    }
    
    
    
}
