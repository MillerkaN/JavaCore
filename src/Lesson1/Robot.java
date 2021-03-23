package Lesson1;

public class Robot implements Run, Jump, Competitor {

    private String name;
    private double maxRunLength;
    private double maxJumpHeight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxRunLength() {
        return maxRunLength;
    }

    public void setMaxRunLength(double maxRunLength) {
        this.maxRunLength = maxRunLength;
    }

    public double getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public void setMaxJumpHeight(double maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    public Robot(String name, double maxRunLength, double maxJumpHeight) {
        this.name = name;
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void jump(double height) {
        if (maxJumpHeight >= height) {
            System.out.println("Successful jump");
        } else System.out.println("I can't jump so highly");
    }

    @Override
    public void run(double length) {
        if (maxRunLength >= length) {
            System.out.println("Ran successfully");
        } else System.out.println("I can't run so much");
    }
}
