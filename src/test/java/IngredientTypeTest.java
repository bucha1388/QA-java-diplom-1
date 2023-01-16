import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final String typeName;

    public IngredientTypeTest(IngredientType type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    @Parameterized.Parameters(name = "Check type: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void getIngredientTypeNameTest() {
        Assert.assertEquals(typeName, type.name());
    }
}
