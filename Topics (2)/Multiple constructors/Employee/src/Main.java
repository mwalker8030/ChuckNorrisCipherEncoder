
class Employee {

    String name;
    int salary;
    String address;

    public Employee() {
        name = "unknown";
        address = "unknown";
        salary = 0;
    }

    public Employee(String n, int s) {
        this();
        name = n;
        salary = s;
    }

    public Employee(String n, int s, String a) {
        name = n;
        salary = s;
        address = a;
    }


}