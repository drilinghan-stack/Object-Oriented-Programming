package src;

public class Specialist extends HealthProfessional {
    private String specialty;
    
    public Specialist() {
        super();
        this.specialty = "Not specified";
    }
    
    public Specialist(String id, String name, String contactNumber, String specialty) {
        super(id, name, contactNumber);
        this.specialty = specialty;
    }
    
    public void printProfessionalDetails() {
        System.out.println("Medical Professional Details:");
        System.out.println("Type: Specialist");
        printDetails();
        System.out.println("Specialty Field: " + specialty);
        System.out.println("Responsibilities: Provide in-depth diagnosis and treatment in specialized fields");
    }
    
    public void conductSpecializedTest() {
        System.out.println(getName() + " is conducting " + specialty + " specialized test");
    }
    
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
}
