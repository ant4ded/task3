package epam.javatr.dedik.day3.service;

import by.epam.javatr.dedik.day3.entity.Ball;
import by.epam.javatr.dedik.day3.entity.Basket;
import by.epam.javatr.dedik.day3.entity.BallColor;
import by.epam.javatr.dedik.day3.service.BallCounter;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BallCounterTest {
    private BallCounter counter;

    @BeforeClass
    public void setUp() {
        counter = new BallCounter();
    }

    public Basket getData() {
        int capacity = 1000;
        Basket basket = new Basket(capacity);
        basket.addBall(new Ball(1, BallColor.BLUE));
        basket.addBall(new Ball(2, BallColor.BLACK));
        basket.addBall(new Ball(3, BallColor.BLUE));
        basket.addBall(new Ball(4, BallColor.BLACK));
        basket.addBall(new Ball(5, BallColor.BLUE));
        return basket;
    }

    @Test
    public void countBalls_basketColour_count() {
        long countBlue = counter.countBalls(getData(), BallColor.BLUE);
        long countDark = counter.countBalls(getData(), BallColor.BLACK);
        Assert.assertTrue(countBlue == 3 && countDark == 2);
    }
}
