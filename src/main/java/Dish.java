//Restaurant Management System: Design a system for managing a restaurant. 
// Implement a Dish class with fields like name, ingredients, and price. 
// Implement a Menu class which manages a list of Dish objects. 
// The Menu class should have methods like addDish(Dish dish), removeDish(String dishName), and getDishByIngredient(String ingredient). 
// Implement appropriate exceptions and error handling. Write tests to verify your solution.

import java.util.ArrayList;
import java.util.List;

public class Dish {


    private String name;
    private String ingredient;
    private double price;
    
    public String getName() {
        return name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public double getPrice() {
        return price;
    }
    
    public Dish(String name, String ingredient, double price) {
        this.name = name;
        this.ingredient = ingredient;
        this.price = price;
    }
}

class Menu {
    private List<Dish> dishes;

    public Menu() {
        this.dishes = new ArrayList<>();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    // The Menu class should have methods like addDish(Dish dish), removeDish(String dishName), and getDishByIngredient(String ingredient). 
    
    public void addDish(Dish dish){
        if(dishes.contains(dish)){
            throw new RuntimeException("Dish already exists");
        }
        else{
            dishes.add(dish);
        }
    }

    public void removeDish(String dishName){
        boolean dishExistsFlag = false;
        for(Dish dish:dishes){
            if(dish.getName().equals(dishName)){
                dishes.remove(dish);
                dishExistsFlag = true;
                break;
            }
        }
        if (!dishExistsFlag){
            throw new RuntimeException("Dish does not exist");
        }
    }

    public Dish getDishByIngredient(String ingredient){
        boolean dishExistsFlag = false;
        Dish dish1 = null;
        for(Dish dish:dishes){
            if(dish.getIngredient().equals(ingredient)){
                dishExistsFlag = true;
                dish1 = dish;
                break;
            }
        }
        if (!dishExistsFlag){
            throw new RuntimeException("Dish does not exist");
        }
        return dish1;
    }
}