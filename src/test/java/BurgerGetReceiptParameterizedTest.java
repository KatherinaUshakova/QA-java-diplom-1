import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParameterizedTest {

    Bun bun;
    List<Ingredient> ingredients;

    Burger burger = new Burger();

    @Before
    public void setUp() {
        burger.bun = bun;
    }

    public BurgerGetReceiptParameterizedTest(Bun bun, List<Ingredient> ingredients) {
        this.bun = bun;
        this.ingredients = ingredients;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
            {
                new Bun("булочка с кунжутом", 147f),
                List.of(
                    new Ingredient(IngredientType.FILLING, "мы.огурчики", 35f),
                    new Ingredient(IngredientType.FILLING, "я.колбаска", 54f),
                    new Ingredient(IngredientType.SAUCE, "крафтовый кепчунез", 85f)
                )
            },
            {
                new Bun("булочка с отрубями", 170f),
                List.of(new Ingredient(IngredientType.SAUCE, "сырный",30f))
            },
            {
                new Bun("я.булочка", 247f),
                List.of()
            }
        };
    }

    @Test
    public void getReceiptWithParams(){
        StringBuilder res = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
            res.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        String result = res.append(String.format("(==== %s ====)%n", bun.getName()))
                   .append(String.format("%nPrice: %f%n", burger.getPrice())).toString();

        System.out.println(result);

        assertEquals(result, burger.getReceipt());
    }
}
