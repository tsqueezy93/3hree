public class Lecturer {
    private String id;
    private String firstName;
    private String lastName;
    private String campus;

    public Lecturer(String id, String firstName, String lastName, String campus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.campus = campus;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
