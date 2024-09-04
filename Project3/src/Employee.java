public class Employee {

    private String name;
    private int weeksWorked;
    private int positiveReviews;

    public Employee() {
        name = "Alex";
        weeksWorked = 0;
        positiveReviews = 0;
    }

    public Employee(String name, int weeksWorked, int positiveReviews ) {
        this.name = name;
        this.weeksWorked = weeksWorked;
        this.positiveReviews = positiveReviews;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeeksWorked(int weeksWorked) {
        this.weeksWorked = (weeksWorked > 6) ? 6 : weeksWorked;
        this.weeksWorked = (weeksWorked < 0) ? 0 : weeksWorked;
        this.weeksWorked = weeksWorked;
    }

    public int getWeeksWorked() {
        return weeksWorked;
    }

    public void setPositiveReviews(int positiveReviews) {
        this.positiveReviews = (positiveReviews > 4) ? 4 : positiveReviews;
        this.positiveReviews = (positiveReviews < 0) ? 0 : positiveReviews;
        this.positiveReviews = positiveReviews;
    }

    public int getPositiveReviews() {
        return positiveReviews;
    }

}
