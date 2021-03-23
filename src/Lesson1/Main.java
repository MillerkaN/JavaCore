package Lesson1;

public class Main {
    public  static void main (String[] args){

        Competitor cat = new Cat("Barsik", 10.0, 3.0);
        Competitor human = new Human("Vasya", 20.0, 1.0);
        Competitor robot = new Robot("Shelezyaka", 200.0, 0.5);

        Treadmill[] treadmills = {new Treadmill(5),  new Treadmill(15),
                new Treadmill(150)};
        Wall[] walls = {new Wall(1), new Wall(2)};

        Competitor[] competitors = {cat, human, robot};



        for (int i = 0; i < competitors.length; i++){
            int x = i+1;
            System.out.println("Сейчас действует конкурсант № " + x);
            for (Treadmill treadmill : treadmills) {
                competitors[i].run(treadmill.getLength());
            }
            for (Wall wall : walls) {
                competitors[i].jump(wall.getWallHeight());
            }

        }
    }
}
