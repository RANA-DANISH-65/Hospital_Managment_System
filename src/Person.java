public class Person {
    private final String name;
    private int age;
    private final int id;
    private String address;
    private static int counter = 0;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.id = ++counter + 100;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name=" + name + ", Age=" + age + ", Address=" + address + ", ID=" + id;
    }

    public void displayPersonInfo(){
        System.out.println(this);
    }
}
