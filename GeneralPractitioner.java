package src;

public class GeneralPractitioner extends HealthProfessional {
    private int patientListSize;
    
    public GeneralPractitioner() {
        super();
        this.patientListSize = 0;
    }
    
    public GeneralPractitioner(String id, String name, String contactNumber, int patientListSize) {
        super(id, name, contactNumber);
        this.patientListSize = patientListSize;
    }
    
    public void printProfessionalDetails() {
        System.out.println("Medical Professional Details:");
        System.out.println("Type: General Practitioner");
        printDetails();
        System.out.println("Patient List Size: " + patientListSize);
        System.out.println("Responsibilities: Provide primary healthcare, routine checkups, diagnose common illnesses");
    }
    
    public void conductPhysicalExam() {
        System.out.println(getName() + " is conducting a physical examination");
    }
    
    public int getPatientListSize() { return patientListSize; }
    public void setPatientListSize(int patientListSize) { this.patientListSize = patientListSize; }
}
