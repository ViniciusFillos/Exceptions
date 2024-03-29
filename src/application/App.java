package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtfm = Reservation.dtfm;

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), dtfm);
        System.out.print("check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), dtfm);

        if (!checkOut.isAfter(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: "+reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), dtfm);
            System.out.print("check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), dtfm);

            LocalDate now = LocalDate.now();
            if(checkIn.isBefore(now) || checkOut.isBefore(now)) {
                System.out.println("Error in reservation: Reservations dates for update must be future dates");
            } else if(checkOut.isBefore(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: "+reservation);
            }
        }
        sc.close();
    }
}
