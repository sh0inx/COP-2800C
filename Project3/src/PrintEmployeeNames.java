public class PrintEmployeeNames {

    String[] names;

    public PrintEmployeeNames() {
        names = new String[]{"Alice", "Bob", "Carl", "Donald", "Ella", "Felicia"};
    }

    public void setName(String name, int employeeNumber) {
        names[employeeNumber] = name;
    }

    public String getName(int employeeNumber) {
        return names[employeeNumber];
    }

    public void printNames(String[] names) {
        for(String employee: names) {
            System.out.println(employee);
        }
    }
}
