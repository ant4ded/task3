package by.epam.javatr.dedik.day3.entity;

import java.util.Optional;
import java.util.StringJoiner;

public class Ball {
    public static final int MAX_WEIGHT = 50;

    private int weight;
    private BallColor color;

    public Ball() {
    }

    public Ball(int weight, BallColor color) {
        this.weight = Math.min(MAX_WEIGHT, weight);
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = Math.min(MAX_WEIGHT, weight);
    }

    public Optional<BallColor> getColor() {
        return Optional.of(color);
    }

    public void setColor(BallColor color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        return color == ball.color && weight == ball.weight;
    }

    @Override
    public int hashCode() {
        int result = weight;
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ball.class.getSimpleName() + "[", "]")
                .add("weight=" + weight)
                .add("color=" + color)
                .toString();
    }
}
