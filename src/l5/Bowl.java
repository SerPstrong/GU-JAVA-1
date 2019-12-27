package l5;

public class Bowl {
   protected int volume; //размер миски
   protected int foodInBowl; //количество еды в миске
   public Bowl(int volume, int foodInBowl){
       this.volume = volume;
       this.foodInBowl = foodInBowl;
   }

   public void setFoodInBowl(int foodInBowl){
       if(foodInBowl >= 0) {
           this.foodInBowl = foodInBowl;
       } else {
           this.foodInBowl = 0;
       }
   }

   public int getFoodInBowl(){
       return foodInBowl;
   }
   public void fillFoodInBowl(int food){  //пополнение миски едой
       if ((foodInBowl + food) <= volume) {
           foodInBowl += food;
       } else {
           System.out.println("Пополнить миску невозможно. Она будет переполнена.");
       }
   }

   public void infoOfFoodInBowl(){ //вывод информации о количестве еды в  миске
       System.out.println("В миске осталось " + foodInBowl + " еды.");

   }
}
