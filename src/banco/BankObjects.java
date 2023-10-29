package banco;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class BankObjects {
	
	Scanner sc = new Scanner(System.in);
	
	private String typeOfUser;
	private String typeOfAccount;
	private String name;
	private String user;
	private String id;
	private String password;
	private int phoneNumber;
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	BankObjects(String typeOfUser,String typeOfAccount,String name,String user, String password,int phoneNumber,String id) {
		this.name = name;
		this.user = user;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.typeOfUser = typeOfUser;
		this.typeOfAccount = typeOfAccount;
}

	// abstract functions 
	
	@Override
	public String toString() {
	    return " Name: " + name + ", Username: " + user + ", ID: " + id + ", Type of User: " + typeOfUser ;
	}

	
	 public void seeData() {
		 System.out.println("------------------");
		 System.err.println("USER INFORMATION");
		 System.out.println("Name: " + name);
		 System.out.println("User: " + user); 
		 System.out.println("Password: " + password);
		 System.out.println("Phone number: " + phoneNumber);
		 System.out.println("ID: " + id);
		 System.out.println("Role: " + typeOfUser);
		 System.out.println("Type of account: " + typeOfAccount);

		 if(typeOfUser.equalsIgnoreCase("N")) {
			 System.out.println("Balance: " + balance);
		 } 
		 System.out.println("------------------");
	 }; 	
	 
	 public void modifyData() {
		 	System.out.println("Modifying User Information");
		 
	        System.out.println("Enter a new phone number: ");
	        phoneNumber = sc.nextInt();
	        System.out.println("Enter a new password: ");
	        password = sc.next();
	        
	        System.err.println("User information updated.");
	 };
	
	//getters and setters

	public String getTypeOfAccount() {
		return typeOfAccount;
	}


	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}


	public String getTypeOfUser() {
		return typeOfUser;
	}


	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
}
