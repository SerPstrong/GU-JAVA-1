public class ArrayOfPersons {
    public static void main(String[] args) {
        Persons[] persArray = new Persons[5]; // Вначале объявляем массив объектов
        persArray[0] = new Persons("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", 8923123123L, 30000,
                30);
        persArray[1] = new Persons(); //специально заведен пустой пользователь для проверки конструктора
        persArray[2] = new Persons("Petrov Petr", "Manager", " petrov@mailbox.com ", 8987654321L, 40000,
                50);
        persArray[3] = new Persons("Sidorova Olga", "Cleaning", " - ", 89565765769L, 20000,
                40);
        persArray[4] = new Persons("Abraham Lincoln", "Director", " lincoln@mailbox.com ", 8977655769L, 20000,
                40);

        for (int i = 0; i < persArray.length; i++) { //циклом выводим информацию только сотрудников старше 40
            if (persArray[i].age >= 40 ) {
                persArray[i].showInfo();
            }
        }

    }
}
