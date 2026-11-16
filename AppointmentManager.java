import java.util.ArrayList;

public class AppointmentManager {
    private ArrayList<Appointment> appointments = new ArrayList<Appointment>();

    public String addAppointment(Appointment appointment) {
        if (appointment == null) {
            return "Error: appointment cannot be null.";
        }

        for (int i = 0; i < appointments.size(); i++) {
            Appointment existing = appointments.get(i);
            boolean sameProfessional =
                    existing.getProfessional().equals(appointment.getProfessional());
            boolean sameTime =
                    existing.getTime().equals(appointment.getTime());

            if (sameProfessional && sameTime) {
                return "Error: " + appointment.getProfessional().getName()
                        + " is already booked at " + appointment.getTime() + ".";
            }
        }

        appointments.add(appointment);
        return "Success: appointment added.";
    }

    public ArrayList<Appointment> getAllSorted() {
        ArrayList<Appointment> copy = new ArrayList<Appointment>();
        for (int i = 0; i < appointments.size(); i++) {
            copy.add(appointments.get(i));
        }
        sortByTime(copy);
        return copy;
    }

    public ArrayList<Appointment> filterByProfessionalId(String professionalId) {
        ArrayList<Appointment> result = new ArrayList<Appointment>();
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getProfessional().getId().equals(professionalId)) {
                result.add(a);
            }
        }
        sortByTime(result);
        return result;
    }

    public ArrayList<Appointment> filterByPatientMobile(String mobile) {
        ArrayList<Appointment> result = new ArrayList<Appointment>();
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getPatient().getMobile().equals(mobile)) {
                result.add(a);
            }
        }
        sortByTime(result);
        return result;
    }

    public String cancelByProfessionalAndTime(String professionalId, String time) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getProfessional().getId().equals(professionalId)
                    && a.getTime().equals(time)) {
                appointments.remove(i);
                return "Success: appointment cancelled.";
            }
        }
        return "Error: no matching appointment found for ID "
                + professionalId + " at " + time + ".";
    }

    public String cancelByPatientMobile(String mobile) {
        int removed = 0;
        for (int i = appointments.size() - 1; i >= 0; i--) {
            Appointment a = appointments.get(i);
            if (a.getPatient().getMobile().equals(mobile)) {
                appointments.remove(i);
                removed++;
            }
        }

        if (removed == 0) {
            return "Error: no appointment found for mobile " + mobile + ".";
        }
        return "Success: cancelled " + removed + " appointment(s) for " + mobile + ".";
    }

    // Write your own selection sort to sort by time strings from earliest to latest
    private void sortByTime(ArrayList<Appointment> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getTime().compareTo(list.get(minIndex).getTime()) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Appointment temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    public void display(ArrayList<Appointment> list) {
        if (list.isEmpty()) {
            System.out.println("  (no appointments)");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  " + list.get(i));
        }
    }
}
