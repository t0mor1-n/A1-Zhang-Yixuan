public class Nurse extends HealthProfessional {
    private String ward;

    public Nurse(String id, String name, String[] workingDays, String ward) {
        super(id, name, workingDays);
        this.ward = ward;
    }

    public Nurse(String id, String name) {
        super(id, name, new String[]{
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
        });
        this.ward = "General Ward";
    }

    @Override
    public String getRole() {
        return "Nurse";
    }

    public void takeBloodSample() {
        System.out.println(getName() + " takes a blood sample.");
    }

    @Override
    public String toString() {
        return super.toString() + " [Ward=" + ward + "]";
    }
}