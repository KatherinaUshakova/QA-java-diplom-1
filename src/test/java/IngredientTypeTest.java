import org.junit.Test;
import praktikum.IngredientType;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void sauceValueTypeTest() {
        assertEquals("SAUCE", valueOf(IngredientType.SAUCE));
    }

    @Test
    public void fillingValueTypeTest() {
        assertEquals("FILLING", valueOf(IngredientType.FILLING));
    }
}
