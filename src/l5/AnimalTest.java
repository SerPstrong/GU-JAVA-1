package l5;

public class AnimalTest {
    public static void main(String[] args) {
        Animal cat1 = new Cat(200, 0, 2.0,3);
        Animal dog1 = new Dog(400, 10, 0.5);
        Animal dog2 = new Dog(600, 5, 2);
        cat1.run(150);
        cat1.swim(1);
        cat1.jumpOverAnObstacle(3.0);
        dog1.run(300);
        dog1.swim(5);
        dog1.jumpOverAnObstacle(1);
        dog2.run(300);
        dog2.swim(5);
        dog2.jumpOverAnObstacle(1);

    }
}
