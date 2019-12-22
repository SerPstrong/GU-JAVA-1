public class createAnimalsMain {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Leo", 150, 8, 5, 6);
        cat1.catInfo();
        Dog dog1 = new Dog("Rex", 150, 8, 5);
        dog1.dogInfo();
        dog1.running(499, dog1.maxDistRun);
    }
}
