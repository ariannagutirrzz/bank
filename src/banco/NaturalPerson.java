package banco;

import java.util.ArrayList;

public class NaturalPerson extends BankObjects{

	NaturalPerson(String typeOfUser, String typeOfAccount, String name, String user, String password, int phoneNumber, String id) {
		super(typeOfUser, typeOfAccount, name, user, password, phoneNumber, id);
		// TODO Auto-generated constructor stub
	}
	
	 public void transfer(ArrayList<BankObjects> userInfo, ArrayList<String> transactionRecord) {
		 
		 System.out.println("How much would you like to transfer?: ");
		 double amount = sc.nextDouble();
		 System.out.println("Type the phone of the person who's gonna receveid the money");
		 int phoneNumber = sc.nextInt(); 
		 System.out.println("Type the id of the person who's gonna receveid the money");
		 String id = sc.next(); 
		 
		 BankObjects recipient = null;
		 boolean match = false;
		 
		 for(BankObjects person : userInfo) {
			
			 if(phoneNumber == person.getPhoneNumber() && id.equalsIgnoreCase(person.getId()) ) {
				 
				 recipient = person;
				 match = true;
			 }
		}
		 
		 if(match == false) {
			 System.out.println("The info doesn't match our data base");
			 return;
		 }
		 
		 if(recipient.getTypeOfUser().equalsIgnoreCase("O")) {
			 System.err.println("You cannot transfer money to an Operator");
			 return;
		 }
		 
		 if(getBalance() >= amount && amount > 0) {
			 
			 setBalance(getBalance() - amount);
			 recipient.setBalance(recipient.getBalance() + amount);
			 System.out.println("You transfered of " + amount + "$ to " + recipient.getName() );
			 
			 transactionRecord.add(getName() + " Transfered of " + amount + "$ to " + recipient.getName() + ", ID: " + recipient.getId());
			 
			 transactionRecord.add(recipient.getName() + " ID:" + recipient.getId() + " receveid: " + amount + " from " + getName() );
		 } else {
				System.err.println("You don't have money to transfer. Deposit first");
			}
	 };
	 
	  public void deposit( ArrayList<String> transactionRecord) {
		  
		  System.out.println("How much do you want to deposit?: ");
		  double amount = sc.nextDouble();

		  if(amount <= 0) {
			  System.out.println("You have to deposit an amount greater than 0");
			  return;
		  } 
		  
		  double previousBalance = getBalance();
		  
		  setBalance(previousBalance += amount);
		  transactionRecord.add(getName() + " You deposit: " + amount );

	  };
	  
	  
	  public void withdraw(ArrayList<String> transactionRecord) {
		  
		  System.out.println("How much do you want to withdraw?: ");
		  double amount = sc.nextDouble();
		  
		  double previousBalance = getBalance();

		  if(amount <= 0) {
			  System.out.println("You have to withdraw an amount greater than 0");
			  return;
		  } 
		  
		  if(amount > previousBalance) {
			  System.err.println("You cannot withdraw more money than what you have");
			  return;
		  }
		  
		  setBalance(previousBalance -= amount);
		  transactionRecord.add(getName() + " You withdraw: " + amount );

	  };

}
