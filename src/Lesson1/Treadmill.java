package Lesson1;

public class Treadmill {

    private double treadmillLength;

    public Treadmill() {
    }

    public Treadmill(double length) {
        this.treadmillLength = length;
    }

    public double getLength() {
        return treadmillLength;
    }
    public void setLength(double length) {
        this.treadmillLength = length;
    }

    public void treadmillOvercome (Run runner) {
        runner.run(treadmillLength);
    }
}
