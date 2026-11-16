import java.util.ArrayList;

public class AssignmentOne {

    public static void main(String[] args) {
        System.out.println("===== Part 3: Health professionals =====");

        GeneralPractitioner gp1 = new GeneralPractitioner("1001", "Dr Alice Smith");
        GeneralPractitioner gp2 = new GeneralPractitioner("1002", "Dr Bob Jones");
        GeneralPractitioner gp3 = new GeneralPractitioner("1003", "Dr Carol White");
        Surgeon surgeon = new Surgeon("2001", "Dr David Lee");
        Dietitian dietitian = new Dietitian("3001", "Eve Brown");
        Nurse nurse = new Nurse("4001", "Frank Green");

        ArrayList<HealthProfessional> professionals = new ArrayList<HealthProfessional>();
        professionals.add(gp1);
        professionals.add(gp2);
        professionals.add(gp3);
        professionals.add(surgeon);
        professionals.add(dietitian);
        professionals.add(nurse);

        for (int i = 0; i < professionals.size(); i++) {
            System.out.println(professionals.get(i));
        }

        System.out.println();
        gp1.prescribe("Paracetamol");
        nurse.takeBloodSample();
        surgeon.performSurgery();
        dietitian.createMealPlan();

        System.out.println();
        System.out.println("===== Part 6: Appointment system demo =====");

        Patient p1 = new Patient("John Doe", "0412345678");
        Patient p2 = new Patient("Jane Roe", "0498765432");
        Patient p3 = new Patient("Sam Tan", "0400111222");

        AppointmentManager manager = new AppointmentManager();

        Appointment a1 = new Appointment(p1, gp1, "09:00");
        Appointment a2 = new Appointment(p2, gp2, "10:30");
        Appointment a3 = new Appointment(p3, surgeon, "09:00");
        Appointment a4 = new Appointment(p1, nurse, "14:00");
        Appointment a5 = new Appointment(p2, dietitian, "11:00");

        System.out.println(manager.addAppointment(a1));
        System.out.println(manager.addAppointment(a2));
        System.out.println(manager.addAppointment(a3));
        System.out.println(manager.addAppointment(a4));
        System.out.println(manager.addAppointment(a5));

        System.out.println();
        System.out.println("-- Attempt double booking --");
        Appointment clash = new Appointment(p3, gp1, "09:00");
        System.out.println(manager.addAppointment(clash));

        System.out.println();
        System.out.println("-- All appointments sorted by time --");
        manager.display(manager.getAllSorted());

        System.out.println();
        System.out.println("-- Filter by professional ID 1001 --");
        manager.display(manager.filterByProfessionalId("1001"));

        System.out.println();
        System.out.println("-- Filter by patient mobile 0412345678 --");
        manager.display(manager.filterByPatientMobile("0412345678"));

        System.out.println();
        System.out.println("-- Cancel by professional ID + time --");
        System.out.println(manager.cancelByProfessionalAndTime("1001", "09:00"));

        System.out.println();
        System.out.println("-- Cancel by patient mobile --");
        System.out.println(manager.cancelByPatientMobile("0498765432"));

        System.out.println();
        System.out.println("-- Cancel non-existent appointment --");
        System.out.println(manager.cancelByProfessionalAndTime("9999", "09:00"));

        System.out.println();
        System.out.println("-- Appointments after cancellation --");
        manager.display(manager.getAllSorted());

        System.out.println();
        System.out.println("-- Invalid appointment examples --");
        try {
            new Appointment(p1, gp1, "09:15");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        try {
            new Patient("", "0412345678");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}