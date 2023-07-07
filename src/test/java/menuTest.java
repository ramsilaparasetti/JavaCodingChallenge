import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Executable;

import static org.junit.Assert.*;

public class menuTest {

    private Menu menu;

    private Dish dish1 = new Dish("Pizza", "Flour", 15.0);
    private Dish dish2 = new Dish("Burger", "Chicken", 25.0);
    private Dish dish3 = new Dish("Nuggets", "Fish", 5.0);

    @Before
    public void setup(){
        menu = new Menu();
        menu.addDish(dish1);
        menu.addDish(dish2);
    }

    @Test
    public void test_addDish_addsDishGivenNewDish() {
        menu.addDish(dish3);
        assertEquals(3, menu.getDishes().size());
    }

    @Test
    public void test_addDish_throwsException_GivenDishAlreadyExists() {
        Exception exception = assertThrows(RuntimeException.class, () -> menu.addDish(dish1));
        String expectedMessage = "Dish already exists";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void test_removeDish_removesDishGivenExistingDish() {
        menu.removeDish("Burger");
        assertEquals(1, menu.getDishes().size());
    }

    @Test
    public void test_removeDish_throwsException_GivenInvalidDish() {
        Exception exception = assertThrows(RuntimeException.class, () -> menu.removeDish("Nuggets"));
        String expectedMessage = "Dish does not exist";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void test_getDishByIngredient_returnsDishForGivenIngredient() {
        assertEquals("Pizza", menu.getDishByIngredient("Flour").getName());
    }

    @Test
    public void test_getDishByIngredient_throwsException_GivenInvalidDish() {
        Exception exception = assertThrows(RuntimeException.class, () -> menu.getDishByIngredient("Nuggets"));
        String expectedMessage = "Dish does not exist";
        assertEquals(expectedMessage, exception.getMessage());
    }
}