package src;

import java.util.ArrayList;
import java.util.Iterator;

public class AssignmentOne {
    // Appointment collection
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("=== Medical Service Appointment System ===");
        
        // Part 3 - Using Classes and Objects
        // Demonstration code for Part 3
        
        // Create three General Practitioner objects
        GeneralPractitioner gp1 = new GeneralPractitioner("1001", "Dr. Zhang", "13800138001", 150);
        GeneralPractitioner gp2 = new GeneralPractitioner("1002", "Dr. Li", "13800138002", 200);
        GeneralPractitioner gp3 = new GeneralPractitioner("1003", "Dr. Wang", "13800138003", 180);
        
        // Create two other types of medical professional objects
        Specialist specialist1 = new Specialist("2001", "Dr. Zhao - Cardiologist", "13800138004", "Cardiology");
        Specialist specialist2 = new Specialist("2002", "Dr. Liu - Pediatrician", "13800138005", "Pediatrics");
        
        // Print detailed information of all medical professionals
        System.out.println("\n=== General Practitioner Information ===");
        gp1.printProfessionalDetails();
        System.out.println("------------------------------");
        gp2.printProfessionalDetails();
        System.out.println("------------------------------");
        gp3.printProfessionalDetails();
        
        System.out.println("\n=== Specialist Information ===");
        specialist1.printProfessionalDetails();
        System.out.println("------------------------------");
        specialist2.printProfessionalDetails();
        System.out.println("------------------------------");
        
        System.out.println(" ");
        
        // Part 5: Appointment Collection
        // Demonstration code for Part 5
        
        System.out.println("\n=== Part 5: Appointment Collection Demonstration ===");
        
        // Make two appointments with General Practitioners
        System.out.println("\n--- Creating General Practitioner Appointments ---");
        createAppointment("John Smith", "13900139001", "08:00", gp1);
        createAppointment("Mary Johnson", "13900139002", "09:30", gp2);
        
        // Make two more appointments with other types of medical professionals
        System.out.println("\n--- Creating Specialist Appointments ---");
        createAppointment("David Brown", "13900139003", "10:15", specialist1);
        createAppointment("Sarah Wilson", "13900139004", "14:30", specialist2);
        
        // Print existing appointments
        System.out.println("\n--- Printing Existing Appointments ---");
        printExistingAppointments();
        
        // Cancel one existing appointment
        System.out.println("\n--- Canceling Appointment ---");
        cancelBooking("13900139002"); // Cancel Mary Johnson's appointment
        
        // Reprint existing appointment records to show updated list
        System.out.println("\n--- Updated Appointment List ---");
        printExistingAppointments();
        
        System.out.println(" ");
    }
    
    /**
     * Create new appointment and add it to ArrayList
     * Due to inheritance mechanism, this method can handle different types of medical professionals
     */
    public static void createAppointment(String patientName, String patientPhone, 
                                       String preferredTime, HealthProfessional doctor) {
        // Validate required information
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("Error: Patient name cannot be empty");
            return;
        }
        if (patientPhone == null || patientPhone.trim().isEmpty()) {
            System.out.println("Error: Patient phone number cannot be empty");
            return;
        }
        if (preferredTime == null || preferredTime.trim().isEmpty()) {
            System.out.println("Error: Appointment time cannot be empty");
            return;
        }
        if (doctor == null) {
            System.out.println("Error: Doctor information cannot be empty");
            return;
        }
        
        // Check if phone number already exists
        for (Appointment appointment : appointments) {
            if (appointment.getPatientPhone().equals(patientPhone)) {
                System.out.println("Error: Phone number " + patientPhone + " already has an appointment");
                return;
            }
        }
        
        // Create new appointment
        Appointment newAppointment = new Appointment(patientName, patientPhone, preferredTime, doctor);
        appointments.add(newAppointment);
        
        // Display doctor type information
        String doctorType = "Medical Professional";
        if (doctor instanceof GeneralPractitioner) {
            doctorType = "General Practitioner";
        } else if (doctor instanceof Specialist) {
            doctorType = "Specialist";
        }
        
        System.out.println("Appointment created successfully!");
        System.out.println("Patient: " + patientName + " | Time: " + preferredTime + " | Doctor: " + doctor.getName() + " (" + doctorType + ")");
    }
    
    /**
     * Display existing appointments in ArrayList
     * If no existing appointments, print notification message
     */
    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("Currently no appointment records.");
            return;
        }
        
        System.out.println("Total Existing Appointments: " + appointments.size());
        System.out.println("==============================");
        
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            System.out.println("Appointment #" + (i + 1));
            appointment.printAppointmentDetails();
            System.out.println("------------------------------");
        }
    }
    
    /**
     * Cancel appointment by patient phone number
     * If phone number not found in existing appointments, print error message
     */
    public static void cancelBooking(String patientPhone) {
        if (patientPhone == null || patientPhone.trim().isEmpty()) {
            System.out.println("Error: Please enter a valid phone number");
            return;
        }
        
        Iterator<Appointment> iterator = appointments.iterator();
        boolean found = false;
        
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getPatientPhone().equals(patientPhone)) {
                System.out.println("Appointment found: " + appointment.getPatientName() + 
                                 " (" + patientPhone + ") appointment has been canceled");
                iterator.remove();
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Error: No appointment record found for phone number " + patientPhone);
        }
    }
}
