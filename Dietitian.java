public class Dietitian extends HealthProfessional {
    private String focusArea;

    public Dietitian(String id, String name, String[] workingDays, String focusArea) {
        super(id, name, workingDays);
        this.focusArea = focusArea;
    }

    public Dietitian(String id, String name) {
        super(id, name, new String[]{"Monday", "Thursday"});
        this.focusArea = "General Nutrition";
    }

    @Override
    public String getRole() {
        return "Dietitian";
    }

    public void createMealPlan() {
        System.out.println(getName() + " creates a meal plan.");
    }

    @Override
    public String toString() {
        return super.toString() + " [Focus=" + focusArea + "]";
    }
}