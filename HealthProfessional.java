package src;

public class HealthProfessional {
    private String id;
    private String name;
    private String contactNumber;
    
    public HealthProfessional() {
        this.id = "000000";
        this.name = "Unknown";
        this.contactNumber = "Not provided";
    }
    
    public HealthProfessional(String id, String name, String contactNumber) {
        if (id.matches("\\d+")) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID must be numeric");
        }
        this.name = name;
        this.contactNumber = contactNumber;
    }
    
    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Contact Number: " + contactNumber);
    }
    
    // Getter and Setter methods
    public String getId() { return id; }
    public void setId(String id) { 
        if (id.matches("\\d+")) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID must be numeric");
        }
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}
