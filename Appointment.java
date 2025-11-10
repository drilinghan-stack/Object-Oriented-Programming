package src;

public class Appointment {
    private String patientName;
    private String patientPhone;
    private String preferredTime;
    private HealthProfessional selectedDoctor;
    
    public Appointment() {
        this.patientName = "Unknown";
        this.patientPhone = "Not provided";
        this.preferredTime = "Not specified";
        this.selectedDoctor = new HealthProfessional();
    }
    
    public Appointment(String patientName, String patientPhone, String preferredTime, HealthProfessional selectedDoctor) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.preferredTime = preferredTime;
        this.selectedDoctor = selectedDoctor;
    }
    
    public void printAppointmentDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Phone: " + patientPhone);
        System.out.println("Appointment Time: " + preferredTime);
        System.out.println("Appointed Doctor: " + selectedDoctor.getName());
        System.out.println("Doctor ID: " + selectedDoctor.getId());
        
        if (selectedDoctor instanceof GeneralPractitioner) {
            System.out.println("Doctor Type: General Practitioner");
        } else if (selectedDoctor instanceof Specialist) {
            System.out.println("Doctor Type: Specialist");
        } else {
            System.out.println("Doctor Type: Medical Professional");
        }
    }
    
    // Getter methods
    public String getPatientName() { return patientName; }
    public String getPatientPhone() { return patientPhone; }
    public String getPreferredTime() { return preferredTime; }
    public HealthProfessional getSelectedDoctor() { return selectedDoctor; }
    
    // Setter methods
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public void setPatientPhone(String patientPhone) { this.patientPhone = patientPhone; }
    public void setPreferredTime(String preferredTime) { this.preferredTime = preferredTime; }
    public void setSelectedDoctor(HealthProfessional selectedDoctor) { this.selectedDoctor = selectedDoctor; }
}
