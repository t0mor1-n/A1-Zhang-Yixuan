public class Surgeon extends HealthProfessional {
    private String specialty;

    public Surgeon(String id, String name, String[] workingDays, String specialty) {
        super(id, name, workingDays);
        this.specialty = specialty;
    }

    public Surgeon(String id, String name) {
        super(id, name, new String[]{"Tuesday", "Thursday"});
        this.specialty = "General Surgery";
    }

    @Override
    public String getRole() {
        return "Surgeon";
    }

    public void performSurgery() {
        System.out.println(getName() + " performs surgery.");
    }

    @Override
    public String toString() {
        return super.toString() + " [Specialty=" + specialty + "]";
    }
}