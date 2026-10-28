
import java.util.Scanner;

class Patient {
    int id;
    String name;
    String problem;
    Patient next;

    Patient(int id, String name, String problem) {
        this.id = id;
        this.name = name;
        this.problem = problem;
        this.next = null;
    }
}

class HospitalQueue {
    private Patient front;
    private Patient rear;

    public void addPatient(int id, String name, String problem) {
        Patient newPatient = new Patient(id, name, problem);

        if (rear == null) {
            front = rear = newPatient;
        } else {
            rear.next = newPatient;
            rear = newPatient;
        }

        System.out.println("Patient added successfully!");
    }

    public void servePatient() {
        if (front == null) {
            System.out.println("No patients waiting.");
            return;
        }

        Patient temp = front;
        System.out.println("Patient served: " + temp.name
                + " (ID: " + temp.id + ")");

        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    public void displayPatients() {
        if (front == null) {
            System.out.println("No patients in the queue.");
            return;
        }

        Patient temp = front;
        System.out.println("\n--- Hospital Patient Queue ---");

        while (temp != null) {
            System.out.println("ID: " + temp.id
                    + " | Name: " + temp.name
                    + " | Problem: " + temp.problem);
            temp = temp.next;
        }
    }
}

public class HospitalQueueMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalQueue hospital = new HospitalQueue();
        int choice;

        do {
            System.out.println("\n=== Hospital Patient Management ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Serve Patient");
            System.out.println("3. Display Patients");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter patient problem: ");
                    String problem = sc.nextLine();

                    hospital.addPatient(id, name, problem);
                    break;

                case 2:
                    hospital.servePatient();
                    break;

                case 3:
                    hospital.displayPatients();
                    break;

                case 4:
                    System.out.println("Exiting hospital system.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
