import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Meo Hospital Lahore");
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hospital.addDoctor();
                    break;
                case 2:
                    hospital.addPatient();
                    break;
                case 3:
                    hospital.addNurse();
                    break;
                case 4:
                    hospital.assignDocToPat();
                    break;
                case 5:
                    hospital.assignNurseToPat();
                    break;
                case 6:
                    hospital.removeDoctor();
                    break;
                case 7:
                    hospital.removeNurse();
                    break;
                case 8:
                    hospital.removePatient();
                    break;
                case 9:
                    hospital.displayDoctors();
                    break;
                case 10:
                    hospital.displayNurses();
                    break;
                case 11:
                    hospital.displayPatients();
                    break;
                case 12:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        } while (choice != 12);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("-------| Hospital Management Menu |-------");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. Add Nurse");
        System.out.println("4. Assign Doctor to Patient");
        System.out.println("5. Assign Nurse to Patient");
        System.out.println("6. Remove Doctor");
        System.out.println("7. Remove Nurse");
        System.out.println("8. Remove Patient");
        System.out.println("9. Display Doctors");
        System.out.println("10. Display Nurses");
        System.out.println("11. Display Patients");
        System.out.println("12. Exit");
        System.out.println("------------------------------------------");
    }
}
