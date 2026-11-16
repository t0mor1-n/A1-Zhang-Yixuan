public class Patient {
    private String name;
    private String mobile;

    public Patient(String name, String mobile) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        if (!isValidMobile(mobile)) {
            throw new IllegalArgumentException("Mobile must be exactly 10 digits.");
        }
        this.name = name;
        this.mobile = mobile;
    }

    private static boolean isValidMobile(String mobile) {
        if (mobile == null || mobile.length() != 10) {
            return false;
        }
        for (int i = 0; i < mobile.length(); i++) {
            char c = mobile.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return name + " (mobile: " + mobile + ")";
    }
}