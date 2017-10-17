package exercice7.domain;

public abstract class Employee implements java.io.Serializable {

    private static String NAME_PATTERN = "%s %s %s";
    private String firstname;
    private String lastname;
    private int age;
    private String entryYear;


    public Employee(String firstname, String lastname, int age, String entryYear) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.entryYear = entryYear;
    }

    public abstract double calculerSalaire();
    public abstract String getPosition();

    public String getName() {
        return String.format(NAME_PATTERN, getPosition(), firstname, lastname);
    }
}
