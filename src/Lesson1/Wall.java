package Lesson1;

public class Wall {

    private double wallHeight;

    public Wall() {
    }

    public Wall(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    public double getWallHeight() {
        return wallHeight;
    }

    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }


    public void overcomeObstacle (Jump jumper) {
        jumper.jump(wallHeight);
    }
}
