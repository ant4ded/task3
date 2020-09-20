package by.epam.javatr.dedik.day3.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Basket {
    public static final int MAX_CAPACITY = 1000;

    private int capacity;
    private int value;
    private List<Ball> balls;

    public Basket(int capacity) {
        this.capacity = Math.min(MAX_CAPACITY, capacity);
        this.balls = new ArrayList<>();
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = Math.min(MAX_CAPACITY, capacity);
    }

    public int getValue() {
        return value;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public boolean hasPlace(Ball ball) {
        return value + ball.getWeight() < capacity;
    }

    public boolean addBall(Ball ball) {
        boolean result = false;
        if (hasPlace(ball)) {
            balls.add(ball);
            value += ball.getWeight();
            result = true;
        }
        return result;
    }

    public boolean removeBall(Ball ball) {
        return balls.remove(ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket = (Basket) o;

        return balls.equals(basket.balls) &&
                capacity == basket.capacity &&
                value == basket.value;
    }

    @Override
    public int hashCode() {
        int result = capacity;
        result = 31 * result + value;
        result = 31 * result + balls.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Basket.class.getSimpleName() + "[", "]")
                .add("capacity=" + capacity)
                .add("value=" + value)
                .add("balls=" + balls)
                .toString();
    }
}
