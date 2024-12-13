class User {
    private String firstName;
    private String lastName;
    private int id;
    private int age;
    private String country;

    public User() {
    }

    public User(String fName, String lName, int id, int age, String country) {
        this.firstName = fName;
        this.lastName = lName;
        this.id = id;
        this.age = age;
        this.country = country;
    }

    public User(User us2) {
        this.firstName = us2.firstName;
        this.lastName = us2.lastName;
        this.id = us2.id;
        this.age = us2.age;
        this.country = us2.country;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    public String getCountry() {
        return this.country;
    }

    public void print() {
        System.out.print("\t" + this.lastName + " "
                + this.firstName + ", id is: " + this.id + ", "
                + this.age + " years old, from " + this.country + "\n");
    }
}
