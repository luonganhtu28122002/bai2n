package lap14;

import javax.print.Doc;
import java.util.PriorityQueue;

public class AppointDoctor {
    //Create a new instence of AppointDoctor
    public AppointDoctor(){

    }

    public static void main(String[] args) {
        //TODO code application login here

        //Create a PriorityQueue
        PriorityQueue pq = new PriorityQueue();

        //Creating Doctor objects
        Doctor Cardiologist = new Doctor("Casuality", 1);
        Doctor Gynecologist = new Doctor("Surgery", 2);
        Doctor Paediatric = new Doctor("Routime Check-up", 3);

        //Adding Doctor objects to the Queue
        pq.offer(Cardiologist);
        pq.offer(Gynecologist);
        pq.offer(Paediatric);

        //Remove the elements from the Queue as per their priorities
        while (!pq.isEmpty()){
            //Displaying the header information
            System.out.println("\nAppointing doctors based on their priorities:");
            System.out.println("************************************************");

            //reamoing the Doctor as per their priorities
            Doctor doctor = ((Doctor) pq.remove());

            //Invoking the toString() method
            System.out.println(doctor.toString());
        }
    }
}
