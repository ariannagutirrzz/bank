package banco;

import java.util.ArrayList;

public class Operator extends BankObjects {

	Operator(String typeOfUser, String typeOfAccount, String name, String user, String password, int phoneNumber, String id) {
		super(typeOfUser, typeOfAccount, name, user, password, phoneNumber, id);
		// TODO Auto-generated constructor stub
	}
	
	public void listUsers(ArrayList<BankObjects> userInfo) {
		System.out.println("LIST OF USERS");
		int cambio=1;
		for(BankObjects user : userInfo) {
			System.out.println( cambio + ". " + user.toString());
			cambio += 1;
		};
		
	};

	public void searchUser(ArrayList<BankObjects> userInfo) {
		
		if(userInfo.size() == 0) {
			System.err.println("Register first");
			return;
		}
		
		int opt;

		do {
			System.out.println("What do you want to use to search an user?");
			System.out.println("1. By username");
			System.out.println("2. By ID");
			System.out.println("3. Go back ");
			opt = sc.nextInt();

			switch(opt) {
			case 1:
				System.out.println("Type the username: ");
				 String username = sc.next();
				 boolean validate = false;
				 for (BankObjects person : userInfo) {

						if(username.equals(person.getUser())) {
							System.out.println(person);
		                    validate = true;
						} 
	                }
						if(validate == false ) {
							System.out.println("username doesn't exist ");
						}
				break;
			case 2:
				 System.out.println("Type the id");
				 String id = sc.next(); 
				 boolean x = false;
				 
				 for (BankObjects person : userInfo) {

						if(id.equals(person.getId())) {
							System.out.println(person);
		                    x = true;
						} 
	                }
				
						if(x == false) {
							System.out.println("id doesn't exist ");
						}
				break;
			case 3:
				break;
				default: System.err.println("Type a valid option");
			}
		}  while(opt != 3);
		
	};
	
	public void seeTransactions(ArrayList<String> transactionRecord) {
		System.err.println("LIST OF TRANSACTIONS" );
		for(String transaction : transactionRecord) {
			System.out.println(transaction.toString());
			System.out.println("--------------------------");
		}
	};
	
	public void statistics(ArrayList<String> transactionRecord ) {
			
			System.out.println("Amount of transactions: ");
			System.out.println(transactionRecord.size());
		    
 };
 
 	public void higherAndLower(ArrayList<BankObjects> userInfo) {
 		double highestBalance = 0.0;
		double lowerBalance = Double.MAX_VALUE;
		String personHigherBalance = "";
		String personLowerBalance = "";
		
		for(BankObjects person : userInfo) {				
			if(person.getBalance() > highestBalance) {
				highestBalance = person.getBalance();
				personHigherBalance = person.getName();
			}
		}
		System.out.println("The person with more money is: " + personHigherBalance+ " with: " + highestBalance );
	    
	    for(BankObjects person : userInfo) {				
			if(person.getBalance() < lowerBalance && person.getTypeOfUser().equalsIgnoreCase("N")) {
				lowerBalance = person.getBalance();
				personLowerBalance = person.getName();
			}
		}
	    
		System.out.println("The person with less money is: " + personLowerBalance +  " with: " + lowerBalance );
 	}
	
 	
};
