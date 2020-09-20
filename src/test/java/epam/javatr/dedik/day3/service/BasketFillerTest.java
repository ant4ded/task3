package epam.javatr.dedik.day3.service;

import by.epam.javatr.dedik.day3.entity.Basket;
import by.epam.javatr.dedik.day3.service.BasketFiller;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class BasketFillerTest {
    private BasketFiller filler;

    @BeforeClass
    public void setUp() {
        filler = new BasketFiller();
    }

    @Test
    public void randomBall_ball() {
        Assert.assertNotNull(filler.randomBall());
    }

    @Test
    public void randomFill_basket_fullBasket() {
        int capacity = 1000;
        Basket basket = new Basket(capacity);
        filler.randomFill(basket);
        Assert.assertTrue(basket.getValue() <= basket.getCapacity());
    }

    @Test
    public void randomFill_basketAndCountBalls_basketWithBalls() {
        int capacity = 1000;
        int countBalls = 10;
        Basket basket = new Basket(capacity);
        filler.randomFill(basket, 10);
        Assert.assertTrue(basket.getValue() < Basket.MAX_CAPACITY * countBalls);
    }
}
