public class GeneralPractitioner extends HealthProfessional {
    private String room;

    public GeneralPractitioner(String id, String name, String[] workingDays, String room) {
        super(id, name, workingDays);
        this.room = room;
    }

    public GeneralPractitioner(String id, String name) {
        super(id, name);
        this.room = "Room 101";
    }

    @Override
    public String getRole() {
        return "General Practitioner";
    }

    public void prescribe(String drug) {
        System.out.println(getName() + " prescribes " + drug);
    }

    @Override
    public String toString() {
        return super.toString() + " [Room=" + room + "]";
    }
}