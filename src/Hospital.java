import java.util.Scanner;

public class Hospital {
    private Doctor[] doctors;
    private Nurse[] nurses;
    private Patient[] patients;
    private final String HospitalName;
    private int doctorsCounter = 0;
    private int nursesCounter = 0;
    private int patientsCounter = 0;
    Scanner intScanner = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);

    public Hospital(String hospitalName) {
        HospitalName = hospitalName;
        doctors = new Doctor[100];
        nurses = new Nurse[100];
        patients = new Patient[100];
        addDummyData();
    }

    public void addDoctor() {
        System.out.print("Enter Name of Doctor: ");
        String docName = stringScanner.nextLine();
        System.out.print("Enter Age of Doctor: ");
        int docAge = intScanner.nextInt();
        intScanner.nextLine();
        System.out.print("Enter Address of Doctor: ");
        String docAddress = stringScanner.nextLine();
        System.out.print("Enter Salary of Doctor: ");
        double docSalary = intScanner.nextDouble();
        intScanner.nextLine();
        System.out.print("Enter Specialization of Doctor: ");
        String docSpecs = stringScanner.nextLine();
        doctors[doctorsCounter++] = new Doctor(docName, docAge, docAddress, "Doctor", docSalary, docSpecs);
        System.out.println("-------| Doctor Added Successfully |------\n");
    }

    public void addPatient() {
        System.out.print("Enter Name of Patient: ");
        String patName = stringScanner.nextLine();
        System.out.print("Enter Age of Patient: ");
        int patAge = intScanner.nextInt();
        intScanner.nextLine();
        System.out.print("Enter Address of Patient: ");
        String patAddress = stringScanner.nextLine();
        System.out.print("Enter Illness of Patient: ");
        String patIllness = stringScanner.nextLine();
        patients[patientsCounter++] = new Patient(patName, patAge, patAddress, patIllness);
        System.out.println("-------| Patient Added Successfully |------\n");
    }

    public void addNurse() {
        System.out.print("Enter Name of Nurse: ");
        String nurseName = stringScanner.nextLine();
        System.out.print("Enter Age of Nurse: ");
        int nurseAge = intScanner.nextInt();
        intScanner.nextLine();
        System.out.print("Enter Address of Nurse: ");
        String nurseAddress = stringScanner.nextLine();
        System.out.print("Enter Salary of Nurse: ");
        double nurseSalary = intScanner.nextDouble();
        intScanner.nextLine();
        System.out.print("Assign Ward To Nurse: ");
        String ward = stringScanner.nextLine();
        nurses[nursesCounter++] = new Nurse(nurseName, nurseAge, nurseAddress, "Nurse", nurseSalary, ward);
        System.out.println("-------| Nurse Added Successfully |------\n");
    }

    public void assignDocToPat() {
        System.out.println("Select Patient To Assign Doctor:");
        displayPatients();
        int patientSelection = intScanner.nextInt() - 1;
        intScanner.nextLine();
        if (patientSelection < 0 || patientSelection >= patientsCounter) {
            System.out.println("Invalid Patient Selection");
            return;
        }
        System.out.println("Select Doctor To Assign:");
        displayDoctors();
        int docSelection = intScanner.nextInt() - 1;
        intScanner.nextLine();
        if (docSelection < 0 || docSelection >= doctorsCounter) {
            System.out.println("Invalid Doctor Selection");
            return;
        }
        patients[patientSelection].assignDoctor(doctors[docSelection]);
        doctors[docSelection].addPatient(patients[patientSelection]);
        System.out.println("-------| Doctor Assigned to Patient Successfully |------");
    }

    public void assignNurseToPat() {
        System.out.println("Select Patient To Assign Nurse:");
        displayPatients();
        int patientSelection = intScanner.nextInt() - 1;
        intScanner.nextLine();
        if (patientSelection < 0 || patientSelection >= patientsCounter) {
            System.out.println("Invalid Patient Selection");
            return;
        }
        System.out.println("Select Nurse To Assign:");
        displayNurses();
        int nurseSelection = intScanner.nextInt() - 1;
        intScanner.nextLine();
        if (nurseSelection < 0 || nurseSelection >= nursesCounter) {
            System.out.println("Invalid Nurse Selection");
            return;
        }
        patients[patientSelection].assignNurse(nurses[nurseSelection]);
        nurses[nurseSelection].assignPatient(patients[patientSelection]);
        System.out.println("-------| Nurse Assigned to Patient Successfully |------");
    }

    public void displayDoctors() {
        System.out.println("Displaying All Doctors");
        for (int i = 0; i < doctorsCounter; i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(doctors[i]);
        }
    }

    public void displayNurses() {
        System.out.println("Displaying All Nurses");
        for (int i = 0; i < nursesCounter; i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(nurses[i]);
        }
    }

    public void displayPatients() {
        System.out.println("Displaying All Patients");
        for (int i = 0; i < patientsCounter; i++) {
            System.out.print((i + 1) + ". ");
            patients[i].patientDetails();
        }
    }

    private void addDummyData() {
        doctors[doctorsCounter++] = new Doctor("Dr. John Smith", 45, "123 Main St", "Doctor", 150000, "Cardiology");
        doctors[doctorsCounter++] = new Doctor("Dr. Jane Doe", 38, "456 Elm St", "Doctor", 145000, "Pediatrics");

        nurses[nursesCounter++] = new Nurse("Nurse Mary Johnson", 30, "789 Maple Ave", "Nurse", 70000, "Pediatrics");
        nurses[nursesCounter++] = new Nurse("Nurse Mike Brown", 35, "321 Oak Blvd", "Nurse", 75000, "Cardiology");

        patients[patientsCounter++] = new Patient("Alice Cooper", 28, "111 Pine St", "Flu");
        patients[patientsCounter++] = new Patient("Bob Martin", 52, "222 Cedar Rd", "Heart Attack");
    }

    public void removeDoctor() {
        displayDoctors();
        System.out.print("Select Doctor to Remove: ");
        int docSelection = intScanner.nextInt() - 1;
        intScanner.nextLine();
        if (docSelection < 0 || docSelection >= doctorsCounter) {
            System.out.println("Invalid Selection");
            return;
        }
        for (int i = docSelection; i < doctorsCounter - 1; i++) {
            doctors[i] = doctors[i + 1];
        }
        doctors[--doctorsCounter] = null;
        System.out.println("-------| Doctor Removed Successfully |------");
    }

    public void removeNurse() {
        displayNurses();
        System.out.print("Select Nurse to Remove: ");
        int nurseSelection = intScanner.nextInt() - 1;
        intScanner.nextLine();
        if (nurseSelection < 0 || nurseSelection >= nursesCounter) {
            System.out.println("Invalid Selection");
            return;
        }
        for (int i = nurseSelection; i < nursesCounter - 1; i++) {
            nurses[i] = nurses[i + 1];
        }
        nurses[--nursesCounter] = null;
        System.out.println("-------| Nurse Removed Successfully |------");
    }

    public void removePatient() {
        System.out.print("Select Patient to Remove: ");
        displayPatients();
        int patSelection = intScanner.nextInt() - 1;
        intScanner.nextLine();
        if (patSelection < 0 || patSelection >= patientsCounter) {
            System.out.println("Invalid Selection");
            return;
        }
        for (int i = patSelection; i < patientsCounter - 1; i++) {
            patients[i] = patients[i + 1];
        }
        patients[--patientsCounter] = null;
        System.out.println("-------| Patient Removed Successfully |------");
    }
}
