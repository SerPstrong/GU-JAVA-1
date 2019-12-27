public class Animals {
    //общие для всех параметры
    String name;
    int run;
    int swim;
    float jump;
    int maxDistRun;
    int maxDistSwim;
    float maxDistJump;

    public Animals() {
    }

    public void running(int a, int maxDist) {
        boolean result = false;
        if (a >= 0 && a <= maxDist) {
            result = true;
            System.out.println(result);
        } else {
            System.out.println(result);
        }
    }
}
