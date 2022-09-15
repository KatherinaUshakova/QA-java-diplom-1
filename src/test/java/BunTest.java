import DataForTests.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun(TestConstants.BUN_NAME, TestConstants.BUN_PRICE);

    @Test
    public void getNameTest(){
        Assert.assertEquals(bun.name, bun.getName());
    }

    @Test
    public void getPriceTest(){
        Assert.assertTrue(bun.price == bun.getPrice());
    }
}
