public class Persons {
    public String name;
    public String post;
    public String email;
    public long phone;
    public int salary;
    public int age;

    //конструктор для создания объекта с параметрами
    public Persons (String _name, String _post, String _email, long _phone, int _salary, int _age) {
        name = _name;
        post = _post;
        email = _email;
        phone = _phone;
        salary = _salary;
        age = _age;
    }

    //конструктор для создания объекта без параметров
    public Persons () {
        name = "Unknown";
        post = "Unknown";
        email = "Unknown";
        phone = 0;
        salary = 0;
        age = 0;
    }

    //метод для вызова информации (имени)
    public void showInfo () {
        System.out.println("Person: " + name);
    }
}
