public class Appointment {
    private Patient patient;
    private HealthProfessional professional;
    private String time;

    public Appointment(Patient patient, HealthProfessional professional, String time) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient is required.");
        }
        if (professional == null) {
            throw new IllegalArgumentException("Health professional is required.");
        }
        if (!ClinicSchedule.isValidSlot(time)) {
            throw new IllegalArgumentException("Invalid time slot: " + time);
        }

        this.patient = patient;
        this.professional = professional;
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public HealthProfessional getProfessional() {
        return professional;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
       return "Appointment " + time
                + " | Patient: " + patient
                + " | Professional: " + professional;
    }
}
