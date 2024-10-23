public class Doctor extends Staff {
    private String specialization;
    private Patient[] patients;
    private int patientCount = 0;


    public Doctor(String name, int age, String address, String jobRole, double salary, String specialization) {
        super(name, age, address, jobRole, salary);
        this.specialization = specialization;
        this.patients = new Patient[5];
    }


    public void addPatient(Patient patient) {
        if (patientCount < patients.length) {
            patients[patientCount++] = patient;
        } else {
            System.out.println("Cannot add more patients. Maximum limit reached.");
        }
    }

    public String getSpecialization() {
        return specialization;
    }


    public String getPatientDetails() {
        StringBuilder patientDetails = new StringBuilder();
        if (patientCount == 0) {
            patientDetails.append("No patients assigned.");
        } else {
            patientDetails.append("Patients: ");
            for (int i = 0; i < patientCount; i++) {

                patientDetails.append("Patient ").append(i + 1)
                        .append(": ").append(patients[i].getName())
                        .append(" (Condition: ").append(patients[i].getIllness()).append(")\n");
            }
        }
        return patientDetails.toString();
    }

    @Override
    public String toString() {
        return "Doctor [Name=" + getName() + ", Age=" + getAge() +
                ", Address=" + getAddress() + ", Job Role=" + getJobRole() +
                ", Specialization=" + specialization + ", Patient Count=" + patientCount + "]";
    }

}
