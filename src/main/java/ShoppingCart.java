//        Implement a class called ShoppingCart that represents a customer's shopping cart.
//        The class should have methods to add items, remove items, calculate the total price of the items in the cart,
//        and apply discounts if applicable.

import java.util.ArrayList;
import java.util.List;

import static java.rmi.server.LogStream.log;

public class ShoppingCart {

    String item;
    Double price;
    int quantity;
    Double totalPrice;

    public ShoppingCart(String item, Double price, int quantity){
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }
    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static List<ShoppingCart> removeItemFromCart(List<ShoppingCart> cart, String item, int qtyToRemove){
        Boolean multipleItemFlag = false;
        for(ShoppingCart ct:cart) {
            if (ct.item.equals(item) && ct.getQuantity() > 1) {
                if(ct.getQuantity() < qtyToRemove){
                    System.out.println("You are trying to remove more items than existing quantity");
                    break;
                }
                else {
                    multipleItemFlag = true;
                    ct.setQuantity(ct.getQuantity() - qtyToRemove);
                }
            }
            if (!multipleItemFlag) {
                cart = cart.stream()
                        .filter(s -> !s.getItem().equals(item))
                        .toList();
            }
        }
        return cart;
    }
    public static Double calculateTotalPrice(List<ShoppingCart> shoppingCarts){
        Double totalPrice = 0.0;
        for(ShoppingCart cart: shoppingCarts){
            totalPrice += cart.getPrice() * cart.getQuantity();
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        shoppingCarts.add(new ShoppingCart("iPhone12", 800.00, 1));
        shoppingCarts.add(new ShoppingCart("iPhone13", 900.00, 1));
        shoppingCarts.add(new ShoppingCart("iPhone14", 1000.00, 2));
        shoppingCarts.add(new ShoppingCart("iPhone15", 1100.00, 1));
        System.out.println(calculateTotalPrice(removeItemFromCart(shoppingCarts, "iPhone12", 1)));
    }




}
