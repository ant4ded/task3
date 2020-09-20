package by.epam.javatr.dedik.day3.service;

import by.epam.javatr.dedik.day3.entity.Basket;
import by.epam.javatr.dedik.day3.entity.BallColor;

public class BallCounter {
    public long countBalls(Basket basket, BallColor color) {
        return basket.getBalls().stream().filter(ball -> ball.getColor().get() == color).count();
    }
}
