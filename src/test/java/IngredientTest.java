import datafortests.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, TestConstants.INGREDIENT_NAME, TestConstants.INGREDIENT_PRICE);

    @Test
    public void getPriceTest(){
        Assert.assertTrue(ingredient.price == ingredient.getPrice());
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals(ingredient.name, ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        Assert.assertEquals(ingredient.type, ingredient.getType());
    }
}
