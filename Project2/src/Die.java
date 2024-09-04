public class Die {

    int roll;

    public Die() {
        roll = (int)(Math.random() * 6) + 1;
    }

    public void roll() {
        this.roll = (int)(Math.random() * 6) + 1;
    }

    public int getRoll() {
        return roll;
    }
}
