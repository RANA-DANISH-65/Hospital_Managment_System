public class Patient extends Person {
    private String illness;
    private Doctor doctorAssigned;
    private Nurse nurseAssigned;

    public Patient(String name, int age, String address, String illness) {
        super(name, age, address);
        this.illness = illness;
    }


    public void assignDoctor(Doctor doctor) {
        this.doctorAssigned = doctor;
    }


    public void assignNurse(Nurse nurse) {
        this.nurseAssigned = nurse;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public Doctor getDoctorAssigned() {
        return doctorAssigned;
    }

    public Nurse getNurseAssigned() {
        return nurseAssigned;
    }


    public void receiveTreatment() {
        if (doctorAssigned != null) {
            System.out.println(getName() + " is receiving treatment for " + illness +
                    " from Dr. " + doctorAssigned.getName());
        } else {
            System.out.println(getName() + " has not been assigned a doctor yet.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Illness: " + illness +
                ", Doctor Assigned: " + (doctorAssigned != null ? doctorAssigned.getName() : "None") +
                ", Nurse Assigned: " + (nurseAssigned != null ? nurseAssigned.getName() : "None");
    }
    public void patientDetails(){
        System.out.println("Name of Patient: "+getName());
        System.out.println(this);

    }
}
