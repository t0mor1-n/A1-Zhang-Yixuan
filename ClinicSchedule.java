public class ClinicSchedule {
    public static final String[] SLOTS = {
            "08:00", "08:30",
            "09:00", "09:30",
            "10:00", "10:30",
            "11:00", "11:30",
            "12:00", "12:30",
            "13:00", "13:30",
            "14:00", "14:30",
            "15:00", "15:30",
            "16:00"
    };

    public static boolean isValidSlot(String time) {
        for (int i = 0; i < SLOTS.length; i++) {
            if (SLOTS[i].equals(time)) {
                return true;
            }
        }
        return false;
    }
}