package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            DateTimeFormatter dtfm = Reservation.dtfm;
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), dtfm);
            System.out.print("check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), dtfm);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), dtfm);
            System.out.print("check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), dtfm);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (DomainException e) {
            System.out.println("Error in reservation: "+e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
    }
}
