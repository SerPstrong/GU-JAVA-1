package l5;

public class Cat extends Animal {
    protected int appetite; //аппетит , сколько еды он может съесть на раз
    protected boolean satiety = false; //сытость

    public Cat(int maxLengthsRun, int maxLengthsSwim, double maxHeightObstracle, int appetite) {
        super(maxLengthsRun, maxLengthsSwim, maxHeightObstracle);
        this.appetite = appetite;
    }


    public void swim(int lengthsSwim) {
        System.out.println("Коты не умеют плавать!");
    }

    // метод кормления кота
    public void eat(Bowl bowl) {
        int catEat = bowl.getFoodInBowl() - appetite;
        if (catEat >= 0) {
            satiety = true;
            bowl.setFoodInBowl(catEat);
        } else {
            System.out.println("Недостаточно еды в миске. Кот есть не стал.");
        }
    }
}
