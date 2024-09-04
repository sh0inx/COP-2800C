public class EmployeeAverages {

    public EmployeeAverages() {
    }

    public int average(int[] intArray) {

        int sum = 0;

        for(int input: intArray) {
            sum += input;
        }

        return (sum / intArray.length);
    }

    public double average(double[] doubleArray) {

        double sum = 0.0;

        for(double input: doubleArray) {
            sum += input;
        }

        return (sum / doubleArray.length + 1);
    }
}
