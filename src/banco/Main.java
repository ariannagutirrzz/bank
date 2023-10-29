package banco;
import java.util.ArrayList;
import java.util.Scanner;

import banco.BankObjects;

public class Main {

	public static void main(String [] args ) {
		Scanner sc = new Scanner(System.in);

		double tasaDolar = 37.0;
		int opc;
		
		ArrayList<BankObjects> userInfo = new ArrayList<>();
		ArrayList<String> transactionRecord = new ArrayList<>();

		do {
			
			System.out.println("-----BANK OF ARIANNA-----");
			System.out.println("1.Sign up");
			System.out.println("2.Log in");
			System.out.println("3.Exit");

			opc = sc.nextInt();
			
			switch (opc) {
			case 1: 
			
					boolean verification1;
					boolean verification;

					String username;
					
					System.out.println("Are you a natural person (N) or an Operator (O)?: ");
					String typeOfUser = sc.next();
					System.out.println("What kind of account are you interested in open, (N) or (J)?: ");
					String typeOfAccount = sc.next();
					
			    	do {
			    		
			    		System.out.println("Type your username: "); 
						username = sc.next();
						verification1 = false;
						
						for(BankObjects person : userInfo) {
							
							if(username.equals(person.getUser())) {
								System.err.println("The username you entered is already in use.");
								verification1 = true;
								break;
							};
						}
						
			    	} while(verification1 == true);
			    	
					System.out.println("Type your name: ");
					String name = sc.next();
									
					System.out.println("Type your password: ");
					String password = sc.next();
					
					System.out.println("Type your phone number: ");
					int phoneNumber = sc.nextInt();
					
					String id;

					do {
			    		
			    		System.out.println("Type your id: "); 
						id = sc.next();
						verification = false;
						
						for(BankObjects person : userInfo) {
							if(id.equals(person.getId()) ) {
								System.err.println("The id you entered is already in use.");
								verification = true;
								break;
							};
						}
						
			    	} while(verification == true);
					
					if(typeOfUser.equalsIgnoreCase("N")) {
		               
						BankObjects person = new NaturalPerson(typeOfUser, typeOfAccount,name, username, password, phoneNumber, id);
						userInfo.add(person);
					} else if(typeOfUser.equalsIgnoreCase("O")){
						BankObjects person = new Operator(typeOfUser, typeOfAccount,name, username, password, phoneNumber, id);
						userInfo.add(person);  
					}
					
				System.out.println("User registration succesfully");
					break;
				case 2:
					
					if(userInfo.size() <= 0) {
						System.err.println("First you need to create an user");
					} else {
						
						boolean loggedIn = false;

						do {
				    		
							System.out.println("Enter your username: ");
							String usernameLogin = sc.next();
							System.out.println("Enter your password: ");
							String passwordLogin = sc.next();
														
							for(int i =0; i < userInfo.size(); i++) {
								BankObjects person = userInfo.get(i);
								if(usernameLogin.equals(person.getUser()) && passwordLogin.equals(person.getPassword()) ) {		
									
									if(person.getTypeOfUser().equalsIgnoreCase("O")) {
										
										Operator userSendOp = (Operator) userInfo.get(i);
										loginMenuOperator(userSendOp, transactionRecord, userInfo);
										
									} else if (person.getTypeOfUser().equalsIgnoreCase("N")) {
										
										NaturalPerson userSend = (NaturalPerson) userInfo.get(i);
										loginMenuUser(userSend, userInfo, transactionRecord);
										
									} else {
										System.out.println("Try to log in again");
									}
									
									loggedIn = true;
									break;
								}
							}
							
							if (loggedIn == false) {
						        System.err.println("The data you entered doesn't exist.");
						        System.out.println("Do you want to try again? (Y/N): ");
						        String tryAgain = sc.next();

						        if (!tryAgain.equalsIgnoreCase("Y")) {
						            break; // Salir si el usuario no desea intentarlo de nuevo
						        }
						    }
							
				    	} while(!loggedIn);
					}
					
					break;
				case 3: break;
					default: System.err.println("Select a valid option");
			}
				
			} while (opc != 3);
			
				}
	
	public static void loginMenuUser(NaturalPerson person, ArrayList<BankObjects> userInfo, ArrayList<String> transactionRecord) {
		
		Scanner sc = new Scanner(System.in);
		int choice;
				
		do {
			
			System.out.println("What do you want to do?");
			System.out.println("1. See my data");
			System.out.println("2. Modify my data");
			System.out.println("3. Transfer money");
			System.out.println("4. Deposit to my account");
			System.out.println("5. Cash out");
			System.out.println("6. Log out");

			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				person.seeData();
				break;
			case 2:
				person.modifyData();
				break;
			case 3:
				person.transfer(userInfo, transactionRecord);
				break;
			case 4:
				person.deposit(transactionRecord);
				break;
			case 5: 
				person.withdraw(transactionRecord);
				break;
			case 6:
				break;
			}
			
		} while(choice != 6);
	}
	
	public static void loginMenuOperator(Operator person, ArrayList<String> transactionRecord,ArrayList<BankObjects> userInfo) {
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			
			System.out.println("What do you want to do?");
			System.out.println("1. See my data");
			System.out.println("2. Modify my data");
			System.out.println("3. Show clients (BY LIST)");
			System.out.println("4. Search an user ");
			System.out.println("5. Historial of transactions");
			System.out.println("6. Statistics");
			System.out.println("7. Log out");

			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				
				person.seeData();

				break;
			case 2:
				
				person.modifyData();

				break;
			case 3:
				
				person.listUsers(userInfo);
				
				break;
			case 4:
				
				person.searchUser(userInfo);
				
				break;
			case 5: 
				
				person.seeTransactions(transactionRecord);
				
				break;
			case 6:
				
				person.statistics(transactionRecord);
				person.higherAndLower(userInfo);
				
				break;
			
			case 7:
				break;
				default: System.out.println("Type a valid option");
			}
		} while(choice != 7);
	
	}
	
}
