import java.util.Scanner;

public class Drive {

    static Vehicle vehicle = new Vehicle();

    public static String intro(Scanner scanner) {

        System.out.println("\n\nHello, and welcome to the Driving Simulator!");
        System.out.println("\nPlease input the name of your vehicle.");

        String vehicleName = scanner.next();

        System.out.println("\nGreat! " + vehicleName + " will be added to the roster.");

        System.out.println("\nWhat type of vehicle is " + vehicleName + "?");

        vehicle.setType(scanner.next());

        System.out.println("\nWhat is the make, model, and year of " + vehicleName + "?");

        vehicle.setMake(scanner.next());
        vehicle.setModel(scanner.next());
        vehicle.setYear(scanner.nextInt());

        System.out.println("\nWhat is " + vehicleName + "'s color?");

        vehicle.setColor(scanner.next());

        System.out.println("\nWhat is " + vehicleName + "'s miles-per-gallon (mpg)?");

        vehicle.setMpg(scanner.nextDouble());

        System.out.println("\nOne more thing - how much gas (in gallons) can " + vehicleName + " hold?");

        vehicle.setGasCapacity(scanner.nextDouble());
        vehicle.setGasInTank(vehicle.getGasCapacity());

        System.out.println("\nFantastic! This is what " + vehicleName + "'s information looks like.\n");

        printVehicleData(vehicleName);

        System.out.print("You'll start with " + vehicle.getGasCapacity() + " gallons, and you can drive until you either");
        System.out.println(" refill or run out of gas.");
        vehicle.refill();

        System.out.println("\nNow, what would you like to do?");

        return vehicleName;
    }

    public static void printVehicleData(String vehicleName) {
        System.out.print(vehicleName);
        System.out.println(": " + vehicle.getType());
        System.out.println("========================");
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year: " + vehicle.getYear());
        System.out.println("Color: " + vehicle.getColor() + "\n");

        System.out.println("Gas Tank Capacity (gal.): " + vehicle.getGasCapacity());
        System.out.println("Miles-per-gallon (MPG): " + vehicle.getMpg());
        System.out.println("========================\n");
    }

    public static void refillTank(String vehicleName) {
        System.out.println("\nRefilling...");
        vehicle.refill();
        System.out.println(vehicleName + " has been refilled!\n");
    }

    public static void commute(double miles, String location, String vehicleName) {

        System.out.println("Driving to " + location + "...");
        vehicle.drive(miles);
        System.out.println(vehicleName + " arrived at " + location + ".");
        System.out.println("Driving back...");
        vehicle.drive(miles);

        System.out.println("You've accumulated " + vehicle.getMiles() + " miles.");
        System.out.println("This means you've used " + (vehicle.getMiles() / vehicle.getMpg()) + " gallons of gas.");
        System.out.println("You have " + vehicle.getGasInTank() + " gallons of gas in " + vehicleName + "'s tank.");
    }

    public static void driveToLocation(double miles, String location, String vehicleName) {
        System.out.println("Driving to " + location + "...");
        vehicle.drive(miles);
        System.out.println("Sarah arrived at " + location + ".");

        System.out.println("You've accumulated " + vehicle.getMiles() + " miles.");
        System.out.println("This means you've used " + (vehicle.getMiles() / vehicle.getMpg()) + " gallons of gas.");
        System.out.println("You have " + vehicle.getGasInTank() + " gallons of gas in " + vehicleName + "'s tank.");
    }

    public static void endSimulation() {
        System.out.println("\n\nThank you for taking part in the Driving Simulator!");
        System.out.println("You drove a total of " + vehicle.getMiles() + " miles, and used " + (vehicle.getMiles() / vehicle.getMpg()) + "gallons of gas.");
        System.out.println("\nCome back soon!");
    }

    public static void main(String[] args) {

        String vehicleName;
        String commuteLocation;
        double distance;

        Scanner scanner = new Scanner(System.in);

        vehicleName = intro(scanner);

        commuteLocation = scanner.next();

        boolean cancelTrip = false;

        while (!(commuteLocation.contains("stop") || commuteLocation.contains("finish") || commuteLocation.contains("end"))) {

            String answer = "";

            if (commuteLocation.contains("refill")) {
                refillTank(vehicleName);
            }

            if (commuteLocation.contains("print")) {
                printVehicleData(vehicleName);
            }

            if (commuteLocation.contains("drive")) {

                System.out.println("Where would you like to go?");
                commuteLocation = scanner.next();

                System.out.println("Alright, how many miles away is " + commuteLocation + "?");
                distance = scanner.nextDouble();

                while (vehicle.getGasInTank() <= 0.0 || vehicle.getGasInTank() < (distance / vehicle.getMpg())) {
                    System.out.println("You don't have enough gas to make this trip.");
                    System.out.println("Would you like to refill your tank?");

                    answer = scanner.next();

                    while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no"))) {
                        System.out.println("Sorry, I didn't understand.");
                        System.out.println("Please answer with \"yes\" or \"no\".");
                        answer = scanner.next();
                        System.out.println(answer);
                    }
                    if (answer.equalsIgnoreCase("yes")) {
                        refillTank(vehicleName);
                    }
                    if (answer.equalsIgnoreCase("no")) {
                        System.out.println("Trip cancelled.");
                        cancelTrip = true;
                        break;
                    }
                }

                if ((vehicle.getGasInTank() >= ((distance * 2) / vehicle.getMpg())) && !cancelTrip) {

                    System.out.println("Would you like to make this a round-trip?");

                    answer = scanner.next();
                    while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no"))) {
                        System.out.println("Sorry, I didn't understand.");
                        System.out.println("Please answer with \"yes\" or \"no\".");
                        answer = scanner.next();
                    }
                    if (answer.equalsIgnoreCase("yes")) {
                        commute(distance, commuteLocation, vehicleName);
                    }
                    if (answer.equalsIgnoreCase("no")) {
                        driveToLocation(distance, commuteLocation, vehicleName);
                    }
                }

                if ((vehicle.getGasInTank() < ((distance * 2) / vehicle.getMpg())) && !cancelTrip) {
                    System.out.println("You cannot make this a round-trip, because you don't have enough gas for it.");
                    System.out.println("Would you still like to go to " + commuteLocation + "?");

                    answer = scanner.next();
                    while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no"))) {
                        System.out.println("Sorry, I didn't understand.");
                        System.out.println("Please answer with \"yes\" or \"no\".");
                        answer = scanner.next();
                    }
                    if (answer.equalsIgnoreCase("yes")) {
                        driveToLocation(distance, commuteLocation, vehicleName);
                    }
                    if (answer.equalsIgnoreCase("no")) {
                        System.out.println("Trip cancelled.");
                    }
                }
            }

            System.out.println("Your options are drive, refill, print, or stop/finish/end.");
            System.out.println("What would you like to do?");
            commuteLocation = scanner.next();
            cancelTrip = false;
        }

        endSimulation();
        scanner.close();
    }
}

