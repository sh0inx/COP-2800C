// Do not change or delete any provided code.
// Create a new class in the same project to hold your main() method.
// Interact with this class from your main() method.

public class Vehicle {

// private fields / internal data  
	private int year;  				// year the vehicle was manufactured
	private double miles;				// miles on the total odometer
	private double mpg; 			// miles per gallon the vehicle gets

	private String model;
	private String make;
	private String color;
	private String type;

	private double gasInTank;
	private double gasCapacity;

	// public methods / operations
	// constructor - used to create an object from the class
	public Vehicle() { 
		// this one is empty; we'll see constructors with code soon!
		year = 2000;
		model = "DEFAULT";
		make = "DEFAULT";
		color = "NULL_GRAY";
		miles = 0.0;
		mpg = 35.0;
		gasCapacity = 20;
		gasInTank = 10;
	}
	
	// setters (mutators) and getters (accessors)
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getMiles() {
		return miles;
	}

	public double getMpg() {
		return mpg;
	}

	public void setMpg(double mpg) {
		this.mpg = mpg;
	}

	public double getGasInTank() {
		return gasInTank;
	}

	public void setGasInTank(double gasInTank) {
		this.gasInTank = gasInTank;
	}

	public double getGasCapacity() {
		return gasCapacity;
	}

	public void setGasCapacity(double gasCapacity) {
		this.gasCapacity = gasCapacity;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// instance methods
	public void drive(double miles) {
		this.miles += miles;
	}

	public void refill() {
		gasInTank = gasCapacity;
	}

}
