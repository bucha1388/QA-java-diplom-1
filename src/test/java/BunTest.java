import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

        private Bun bun;

        @Before
        public void createNewBun() {
            bun = new Bun("bulka", 1010);
        }

        @Test
        public void getBunNameTest() {
            Assert.assertEquals("bulka", bun.getName());
        }

        @Test
        public void getBunPriceTest() {
            Assert.assertEquals(1010, bun.getPrice(), 0);
        }
}
