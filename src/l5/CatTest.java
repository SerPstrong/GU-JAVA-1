package l5;

public class CatTest {
    public static void main(String[] args) {
        Bowl bowlOne = new Bowl(20,10);
        bowlOne.infoOfFoodInBowl();
        Cat[] cat = new Cat[3];
        cat[0] = new Cat(300,200,10.0,3);
        cat[1] = new Cat(200,100, 5.0,5);
        cat[2] = new Cat(100,200,7.0,4);
        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(bowlOne); // кот ест
            bowlOne.infoOfFoodInBowl();
            if (!cat[i].satiety){
                System.out.println("Пополнение едой миски.");
                bowlOne.fillFoodInBowl(10);
                bowlOne.infoOfFoodInBowl();
            } else {
                System.out.println((i+1) + "-й кот поел.");
            }
        }
    }
}
