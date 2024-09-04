public class Chicken {

    private String name;
    private String breed;
    private int age; //this is age in years
    private boolean isFemale;
    private final boolean isChicken = true;

    public Chicken() {
        name = "Alex";
        breed = "Rhode Island Red";
        age = 0;
        isFemale = true;
    }

    public Chicken(String name) {
        this.name = name;
        breed = "Rhode Island Red";
        age = 0;
        isFemale = true;
    }

    public Chicken(String name, String breed) {
        this.name = name;
        this.breed = breed;
        age = 0;
        isFemale = true;
    }

    public Chicken(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        isFemale = true;
    }

    public Chicken(String name, String breed, int age, boolean isFemale) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.isFemale = isFemale;
    }

    public void layEgg() {
        if(isFemale == true) {
            System.out.println(name + " laid an egg!");
        } else {
            System.out.println(name + " cannot lay an egg");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //sets isFemale based on char input (f)
    public void setSex(char sex) {
        if(sex == 'f') {
            isFemale = true;
        } else {
            isFemale = false;
        }
    }

    //returns true if female
    public boolean checkSex() {
        return isFemale;
    }

    public void cluck() {
        System.out.println(name + ": cluck");
    }

    public void squawk() {
        System.out.println(name + ": SQUAWK");
    }

    public void eat() {
        System.out.println(name + " ate some feed.");
    }

    public void roam() {
        System.out.println(name + "moved " + ((Math.random() * 6) + 1) + " feet.");
    }
}
