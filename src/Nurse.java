public class Nurse extends Staff {
    private String wardAssigned;
    private Patient[] patientsAssigned;
    private int patientsAssignedCounter = 0;

    public Nurse(String name, int age, String address, String jobRole, double salary, String wardAssigned) {
        super(name, age, address, jobRole, salary);
        this.wardAssigned = wardAssigned;
        this.patientsAssigned = new Patient[10];
    }

    public void assignPatient(Patient patient) {
        if (patient != null) {
            if (patientsAssignedCounter < patientsAssigned.length) {
                patientsAssigned[patientsAssignedCounter++] = patient;
            } else {
                System.out.println("Cannot assign more patients. Maximum limit reached.");
            }
        } else {
            System.out.println("Cannot assign null patient.");
        }
    }

    public String getWardAssigned() {
        return wardAssigned;
    }

    public void setWardAssigned(String wardAssigned) {
        this.wardAssigned = wardAssigned;
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(super.toString());
        details.append(", Ward Assigned: ").append(wardAssigned)
                .append(", Number of Patients Assigned: ").append(patientsAssignedCounter);
        return details.toString();
    }
}
