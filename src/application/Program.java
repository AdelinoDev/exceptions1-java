package application;
/*Faça um programa para ler os dados de uma reserva de hotel (número do quarto, data de entrada e saida) e 
 * mostrar os dados da reserva, inclusive sua duração e dias. 
 * Em seguida, ler novas datas de entrada e saida, atualizar a reserva, e mostrar
 * novamente a reserva com os dados atualizados. O programa não deve aceitar dados inválidos para a reserva, 
 * conforme as regras seguintes:
 * -Alterações de reserva só podem ocorrer para datas futuras
 * -A data de saída deve ser maior que a data de entrada*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		//se a data de saida for menor que a data de entrada
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			}else {
				System.out.println("Reservation: " + reservation);
			}
			
		}
		
		sc.close();
	}

}
