import java.util.Scanner;

public class IceCreamShop {

    public static String promptForEmployeeInformation(EmployeeBonus[] employeeBonus, Scanner scanner, String[] employeeNames, int i) {

        System.out.println("Enter Employee Name: ");
        String employeeName = scanner.next();
        employeeNames[i] = employeeName;
        employeeBonus[i].setName(employeeNames[i]);

        System.out.println("Enter weeks worked: ");
        int weeksWorked = scanner.nextInt();
        employeeBonus[i].setWeeksWorked(weeksWorked);

        System.out.println("Enter positive reviews: ");
        int positiveReviews = scanner.nextInt();
        employeeBonus[i].setPositiveReviews(positiveReviews);

        System.out.println("If you would like to quit, enter \"p\".");
        return scanner.next();
    }

    public static void printEmployeeInformation(EmployeeBonus[] employeeBonus, int i) {
        System.out.println("Employee: " + employeeBonus[i].getName());
        System.out.println("Weeks worked: " + employeeBonus[i].getWeeksWorked());
        System.out.println("Positive Reviews: " + employeeBonus[i].getPositiveReviews());
        System.out.println("Bonus Paid: " + employeeBonus[i].getBonus() + "\n");
    }

    public static void main(String[] args) {

        //Initialize Object Array - EmployeeBonuses
        EmployeeBonus[] employeeBonuses = new EmployeeBonus[6];

        //Initialize String Array - EmployeeNames
        String[] employeeNames = new String[6];

        //Initialize Scanner - Scanner
        Scanner scanner = new Scanner(System.in);

        //Start user prompt (Max = 6)
        int employees = 0;
        for(int i = 0; i < 6; i++) {
            //Initialize Object - EmployeeBonus
            employees++;
            employeeBonuses[i] = new EmployeeBonus();
            if(promptForEmployeeInformation(employeeBonuses, scanner, employeeNames, i).equalsIgnoreCase("p")) {
                System.out.println("ITERATION: " + i);
                break;
            }
        }

        System.out.println("\nEmployee Bonuses\n");

        for(int j = 0; j < employees; j++) {
            printEmployeeInformation(employeeBonuses, j);
        }

        int[] bonusesPaid = new int[employees];
        for(int j = 0; j < employees; j++) {
            bonusesPaid[j] = employeeBonuses[j].getBonus();
        }

        int totalBonusPaid = 0;
        for(int j : bonusesPaid) {
            totalBonusPaid += j;
        }

        System.out.println("Total Bonuses Paid: " + totalBonusPaid);

        EmployeeAverages averages = new EmployeeAverages();
        System.out.println("Average Bonus Paid: " + averages.average(bonusesPaid));

    }
}
