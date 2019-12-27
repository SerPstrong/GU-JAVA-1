package l5;

public abstract class Animal {
    protected int maxLengthsRun = 1;
    protected int maxLengthsSwim = 2;
    protected double maxHeightObstracle = 3;

    public Animal(int maxLengthsRun, int maxLengthsSwim, double maxHeightObstracle){
        this.maxLengthsRun = maxLengthsRun;
        this.maxLengthsSwim = maxLengthsSwim;
        this.maxHeightObstracle = maxHeightObstracle;
    }

    public void run(int lengthsRun){
        if(lengthsRun > 0 && lengthsRun <= maxLengthsRun){
            System.out.println("Совершен забег на " + lengthsRun + " метров.");
        } else if (lengthsRun > maxLengthsRun){
            System.out.println("Слишком далеко бежать.");
        } else {
            System.out.println("Не двигаемся. Некорректный ввод.");
        }
    }

    public void swim(int lengthsSwim){
        if(lengthsSwim > 0 && lengthsSwim <= maxLengthsSwim){
            System.out.println("Совершен заплыв на " + lengthsSwim + " метров.");
        } else if (lengthsSwim > maxLengthsSwim){
            System.out.println("Слишком далеко плыть.");
        } else {
            System.out.println("Не двигаемся. Некорректный ввод.");
        }

    }
    public void jumpOverAnObstacle(double heightObstacle){
        if(heightObstacle > 0 && heightObstacle <= maxHeightObstracle){
            System.out.println("Совершен прыжок на " + heightObstacle + " метров.");
        } else if (heightObstacle > maxHeightObstracle){
            System.out.println("Слишком высоко прыгать.");
        } else {
            System.out.println("Не двигаемся. Некорректный ввод.");
        }

    }

}
