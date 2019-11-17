
public class lesson2 {
    public static void main(String[] args) {

        randomArr(10);
        System.out.println();
        createArr();
        System.out.println();
        multiArr();
        System.out.println();
        squareArr(5);
        System.out.println();
        maxMinArr();
        System.out.println();
        System.out.println("Задание 6");
        int[] arr = {2, 1, 1, 2, 1};
        boolean check = checkBallance(arr);//randomArr(5, 5)); можно сформировать рандомный массив
        System.out.println(check);
        int[] arr1 = {1, 1, 1, 2, 1};
        boolean check1 = checkBallance(arr1);//randomArr(5, 5)); можно сформировать рандомный массив
        System.out.println(check1);
        System.out.println();
        System.out.println("Задание 7*");
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printArr(arr2);
        getStepArr(arr2, 6);

    }

    static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }

    static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    //Задание 1 Начало
    static void randomArr(int count){
        System.out.println("Задание 1");
        int arr[] = new int[count];
        for (int i = 0; i < count; i++){
            arr[i] = (int)(Math.random() * 2);
            System.out.print(arr[i] + " ");
        }
        changeArr(arr);
    }

    static void changeArr(int[] arr){
        System.out.println();
        for ( int i : arr) {
            arr[i] = (i == 1) ? 0 : 1;
            System.out.print(arr[i] + " ");
        }
    }
    //Задание 1 Конец

    //Задание 2
    static void createArr(){
        System.out.println("Задание 2");
        int arr[] = new int[8];
        for (int i = 0, j = 0; i < arr.length; i ++, j +=3){
            arr[i] = j;
            System.out.print(arr[i] + " ");
        }
    }

    //Задание 3
    static void multiArr(){
        System.out.println("Задание 3");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++){
            arr[i] = (arr[i]  < 6 ) ? arr[i] * 2 : arr[i];
            System.out.print(arr[i] + " ");
        }
    }

    //Задание 4
    static void squareArr(int i){
        System.out.println("Задание 4");
        int[][] arr = new int[i][i];
        for (int count1 = 0; count1 < i; count1++) {
            for (int count2 = 0; count2 < i; count2++) {
                arr[count1][count2] = (count1 == count2) ? 1 : 0;
            }
        }
        printArr(arr);
    }

    //Задание 5 начало
    static int[] randomArr(int count, int max){
        int arr[] = new int[count];
        for (int i = 0; i < count; i++){
            arr[i] = (int)(Math.random() * max);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }

    static void maxMinArr(){
        System.out.println("Задание 5");
        int[] arr = randomArr(10, 100);
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            min = (arr[i] < min) ? arr[i] : min;
            max = (arr[i] > max) ? arr[i] : max;
        }
        System.out.println("Максимальное число: " + max);
        System.out.println("Минимальное число: " + min);
    }
    //Задание 5 конец

    //Задание 6
    static boolean checkBallance(int arr[]){

        boolean trueFalse = false;
        int checkSum = 0;
        for (int i = 0; i < arr.length; i++){
            checkSum += arr[i];
        }

        int rest = 0;
        for (int j = 0; j < arr.length; j++){
            if((checkSum -= arr[j]) == (rest += arr[j])) {
                trueFalse = true;
                break;
            };
        }

        return trueFalse;
    }

    //Задание 7 *
    public static void getStepArr(int[] arr, int step) {


        if (step > arr.length){
            step = Math.abs(step % arr.length);
        }

        if (step > 0) {
            for (int i = 0; i < step; i++) {
                int first = arr[0];
                arr[0] = arr[arr.length - 1];

                for (int j = 1; j < arr.length - 1; j++) {
                    arr[arr.length - j] = arr[arr.length - j - 1];
                }
                arr[1] = first;
            }
        }
        else if (step < 0) {
            for (int i = 0; i > step; i--) {
                int last = arr[arr.length - 1];
                arr[arr.length - 1] = arr[0];

                for (int j = 1; j < arr.length - 1; j++) {
                    arr[j - 1] = arr[j];
                }

                arr[arr.length - 2] = last;
            }
        }
        printArr(arr);
    }
}
