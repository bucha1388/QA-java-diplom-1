import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void createNewIngredient() {
        ingredient = new Ingredient(IngredientType.FILLING, "meat Protostomia", 500);
    }

    @Test
    public void getIngredientNameTest() {
        Assert.assertEquals("meat Protostomia", ingredient.getName());
    }

    @Test
    public void getIngredientPriceTest() {
        Assert.assertEquals(500, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientTypeTest() {
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
