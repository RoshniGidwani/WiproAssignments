package wipro;
import java.util.*;

public class Hospital {

    public static void main(String[] args) {

        HashMap<Integer, String> patient = new HashMap<>();

        patient.put(101, "prsn 1");
        patient.put(102, "prsn 2");
        patient.put(103, "prsn 3");

        if (patient.containsKey(102)) {
            System.out.println("Patient ID 102 already exists");
        } else {
            patient.put(102, "prsn4 ");
        }

        System.out.println("Patient 102: " + patient.get(102));

        if (patient.containsKey(104)) {
            System.out.println("Patient 104 exists");
        } else {
            System.out.println("Patient 104 not found");
        }

        System.out.println("Total patients: " + patient.size());

        System.out.println("List of patients:");
        for (Map.Entry<Integer, String> entry : patient.entrySet()) {
            System.out.println("Patient ID: " + entry.getKey() + " Name: " + entry.getValue());
        }

        patient.remove(101);

        patient.clear();
    }
}
