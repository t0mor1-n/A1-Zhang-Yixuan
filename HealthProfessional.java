public abstract class HealthProfessional {
    private String id;
    private String name;
    private String[] workingDays;

    protected HealthProfessional(String id, String name, String[] workingDays) {
        if (!isDigits(id)) {
            throw new IllegalArgumentException("ID must contain digits only.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (workingDays == null || workingDays.length == 0) {
            throw new IllegalArgumentException("At least one working day is required.");
        }

        this.id = id;
        this.name = name;
        this.workingDays = new String[workingDays.length];
        for (int i = 0; i < workingDays.length; i++) {
            this.workingDays[i] = workingDays[i];
        }
    }

    // Overloaded constructor: uses the default value if no workdays are passed
    protected HealthProfessional(String id, String name) {
        this(id, name, new String[]{"Monday", "Wednesday", "Friday"});
    }

    private static boolean isDigits(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWorkingDaysText() {
        String result = "";
        for (int i = 0; i < workingDays.length; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + workingDays[i];
        }
        return result;
    }

    // Abstract method: Each specific professional has to state what type they are
    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + " [ID=" + id
                + ", Name=" + name
                + ", WorkingDays=" + getWorkingDaysText() + "]";
    }

    // Two professionals check if they're the same by ID
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HealthProfessional)) {
            return false;
        }
        HealthProfessional hp = (HealthProfessional) other;
        return this.id.equals(hp.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}