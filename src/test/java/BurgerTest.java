import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient cucumbers;
    @Mock
    Ingredient carrot;

    @Before
    public void setUp() {
        burger.bun = bun;
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(cucumbers);

        assertFalse("список ингредиентов пуст", burger.ingredients.isEmpty());
        assertTrue("список не содержит данный элемент", burger.ingredients.contains(cucumbers));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(cucumbers);
        burger.removeIngredient(burger.ingredients.indexOf(cucumbers));

        assertTrue("невозможно удалить ингредиент", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(cucumbers);
        burger.addIngredient(carrot);

        int cucumbersIndex = burger.ingredients.indexOf(cucumbers);
        int carrotIndex = burger.ingredients.indexOf(carrot);

        burger.moveIngredient(carrotIndex, cucumbersIndex);

        assertEquals("невозможно поменять ингредиенты", burger.ingredients.indexOf(carrot), cucumbersIndex);
    }

    @Test
    public void getPriceTest() {
        float bunPrice = 147f;
        float carrotPrice = 20f;
        float cucumbersPrice = 54f;
        float expected = bunPrice * 2 + carrotPrice + cucumbersPrice;

        burger.addIngredient(cucumbers);
        burger.addIngredient(carrot);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(cucumbers.getPrice()).thenReturn(cucumbersPrice);
        Mockito.when(carrot.getPrice()).thenReturn(carrotPrice);

        assertEquals(expected, burger.getPrice(), 0);
    }
}
