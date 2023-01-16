import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;

    @Before
    public void createNewBurger() {
        burger = new Burger();
    }

    @Test
    public void setBurgerBunsTest() {
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }

    @Test
    public void addBurgerIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeBurgerIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveBurgerIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(sauce, burger.ingredients.get(1));
    }

    @Test
    public void getBurgerPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(300.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(200.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(800.0f, burger.getPrice(), 0);
    }

    @Test
    public void getBurgerReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(300.0f);
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("meat");
        Mockito.when(ingredient.getPrice()).thenReturn(200.0f);
        burger.addIngredient(ingredient);
        Assert.assertEquals("(==== white bun ====)" + "\r\n" + "= filling meat =" + "\r\n" + "(==== white bun ====)" + "\r\n" + "\r\n" + "Price: 800,000000\r\n", burger.getReceipt());
    }
}
