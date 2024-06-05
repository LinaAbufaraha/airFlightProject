
import java.util.Iterator;
import java.util.Scanner;

public class AirplaneReservationSystem {
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		boolean[][] seats=new boolean[7][];
		seats[0] = new boolean [3];
		for(int i=1;i<seats.length;i++) {
			seats[i]=new boolean[4];
		}
		//To create a counter for the total reserved seats.
		int[] totalReservedSeats= new int[2]; //totalReservedSeats[0] -> for economy seats;
		                                      //totalReservedSeats[1] -> for first-class seats;
		int choice;
		do {
			displayMenu() ;
			choice=input.nextInt();	
			switch (choice) {
			case 1: {
					reserve1EconomySeat(seats,totalReservedSeats);					
				break;
			}
			case 2: {
				reserve1FirstClassSeat(seats,totalReservedSeats);
				break;
			}
			case 3: {
				remove1ReservedEconomySeat(seats,totalReservedSeats);
				break;
			}
			case 4: {
				remove1ReservedFirstClassSeat(seats,totalReservedSeats);
				break;
			}
			case 5: {
				printReservationLayoutDetails(seats,totalReservedSeats);
				break;
			}
			case 6: {
				System.out.println("Thank you for using the BZU Sky reservation system.");
				break;
			}
			default:
				System.out.println(" ERROR! \n Please Enter your choice again between (1 - 6).");
			}//end of switch
		} while (choice != 6);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void displayMenu() {
		System.out.println("\n--------------< Welcome to BZU Sky Reservation System. >-------------- \n");
		System.out.println("\tchoose: ");
		System.out.println(" 1_ To reserve one economy seat (1-24). ");
		System.out.println(" 2_ To reserve one first class seat (1-3). ");
		System.out.println(" 3_ To remove one reserved economy seat.  ");
		System.out.println(" 4_ To remove one reserved first-class seat.  ");
		System.out.println(" 5_ To print reservation layout details.  ");
		System.out.println(" 6_ To exit.  ");
		System.out.println("\tEnter your choice (1 - 6)?   ");
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void reserve1EconomySeat(boolean[][] seats,int[] totalReservedSeats) {
		Scanner input=new Scanner(System.in);
		
		if(totalReservedSeats[0]==24) {
			System.out.println("All economy seats are sold out!");
		}else {

			System.out.println("Please enter the number of seat:");
			int seat=input.nextInt();
			while(seat<1 || seat >24) {
				System.out.println("This seat does not exist. \nPlease enter another seat.");
				seat=input.nextInt();
			}
			
			int r=1;//Start at r=1 ,Because  r=0 of First Class Seat
			int c=0;
			while(seat>4) { //To get the seat location
				seat-=4;
				r++;
			} //
			c=seat-1;//
			
			if(seats[r][c]==false) {
				seats[r][c]=true;
				totalReservedSeats[0]++;
				System.out.println("The seat has been reserved successfully.");
				System.out.println("The number of the total reserved seats so far: "+totalReservedSeats[0]);
			}else
				System.out.println("Sorry, this seat are already reserved. \nPlease enter another seat.");
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void reserve1FirstClassSeat(boolean[][] seats,int[] totalReservedSeats) {
		Scanner input=new Scanner(System.in);
		
		if(totalReservedSeats[1]==3) {
			System.out.println("All economy firstc-lass seats are sold out!");
		}else {
		
			System.out.println("Please enter the number of seat:");
			int seat=input.nextInt();
			while(seat<1 || seat >3) {
				System.out.println("This seat does not exist. \nPlease enter another seat.");
				seat=input.nextInt();
			}
	    	
	    	if(seats[0][seat-1]==false) {
				seats[0][seat-1]=true;
				totalReservedSeats[1]++;
				System.out.println("The seat has been reserved successfully.");
				System.out.println("The number of the total reserved firstc-lass seats so far: "+totalReservedSeats[1]);
			}else
				System.out.println("Sorry, this seat are already reserved. \nPlease enter another seat.");
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void remove1ReservedEconomySeat(boolean[][] seats,int[] totalReservedSeats) {
		Scanner input=new Scanner(System.in);
		
		if(totalReservedSeats[0]>0){
			System.out.println("Please enter the number of seat:");
			int seat=input.nextInt();
			while(seat<1 || seat >24) {
				System.out.println("This seat does not exist. \nPlease enter another seat.");
				seat=input.nextInt();
			}
	    	
	    	int r=1;//Start at r=1 ,Because  r=0 of First Class Seat
			int c=0;
			while(seat>4) { //To get the seat location
				seat-=4;
				r++;
			}//
			c=seat-1;//
			
			if(seats[r][c]==true) {
				seats[r][c]=false;
				totalReservedSeats[0]--;
				System.out.println("The seat has been removed successfully.");
				System.out.println("The number of the total reserved seats so far: "+totalReservedSeats[0]);
			}else
				System.out.println("This seat has already been removed. ");
		}else {
			System.out.println("All economy seats are not reserved!");
		} 
    }
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void remove1ReservedFirstClassSeat(boolean[][] seats,int[] totalReservedSeats) {
		Scanner input=new Scanner(System.in);
		
		if(totalReservedSeats[1]>0) {
			System.out.println("4");
			System.out.println("Please enter the number of seat:");
			int seat=input.nextInt();
			while(seat<1 || seat >3) {
				System.out.println("This seat does not exist. \nPlease enter another seat.");
				seat=input.nextInt();
			}
	    	
	    	if(seats[0][seat-1]==true) {
				seats[0][seat-1]=false;
				totalReservedSeats[1]--;
				System.out.println("The seat has been removed successfully.");
				System.out.println("The number of the total reserved firstc-lass seats so far: "+totalReservedSeats[1]);
			}else
				System.out.println("This seat has already been removed. ");
		}else {
			System.out.println("All economy firstc-lass seats are not reserved!");
		}	
    }
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void printReservationLayoutDetails(boolean[][] seats,int[] totalReservedSeats) {
 
			for (int c = 0; c < seats[0].length; c++) {
				System.out.print(""+(c+1)+"-"+seats[0][c]+"  \t");
			}
			System.out.println("");
		int numbe=1;
    	for (int r = 1; r < seats.length; r++) {
			for (int c = 0; c < seats[r].length; c++) {
				System.out.print(""+numbe+"-"+seats[r][c]+"   \t");
				numbe++;
			}
			System.out.println("");
		}
    	System.out.println("\nThe number of the total reserved economy seats so far: "+totalReservedSeats[0]);
		System.out.println("The number of the total reserved firstc-lass seats so far: "+totalReservedSeats[1]);
    }
}
