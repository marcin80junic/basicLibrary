package books;

import java.util.*;

public class Library {
	
	static void showMenu() {
		
		String str;
		int choice;
		try {
		Scanner in = new Scanner(System.in);
		
		
			do {
				System.out.println("1. List all my books");
				System.out.println("2. Edit a book");
				System.out.println("3. Add a book");
				System.out.println("4. Press 'q' to quit");
				System.out.print("\nChoose one of avalaible options: ");
				
				str = in.nextLine();
				
				if(isNumeric(str)) {
					choice = Integer.parseInt(str);
					if(Library.isValidChoice(choice)) {
						Library.chooseAction(choice);
						break;
					}
					else System.out.println("Invalid choice\n");
				}
				else if(str.equals("q")) {
					System.out.println("Quitting...");
					break;
				}
				else System.out.println("Invalid choice\n");
				
			} while(!str.equals("q"));
			in.close();
		}catch(Exception exc) {System.out.println(exc);}
	}
	
	static void chooseAction(int num) {
		switch(num) {
		case 1: {
			Book.getCollection();
			System.out.print("\npress 'b' to return to main menu...");
			Scanner sc = new Scanner(System.in);
			if(sc.next().equals("b")) {
				System.out.println();
				
				showMenu();
			}
		}
		break;
		case 2: editBook();
		break;
		case 3: addBook();
		break;
		case 4: System.out.println("Quitting..");
		break;
		
		}
	}
	
	static void editBook() {
		
	}
	
	static void addBook() {
		try {
			Scanner add = new Scanner(System.in);
			
			System.out.print("\nenter author: ");
			String author = add.nextLine();
			System.out.print("enter series: ");
			String series = add.nextLine();
			System.out.print("enter title: ");
			String title = add.nextLine();
			System.out.print("enter year: ");
			int year = Integer.parseInt(add.nextLine());
			
			Book newBook = new Book(author, series, title, year);
			Book.addToCollection(newBook);
						
			System.out.print("Do you want to add another book y/n?");
			String ch1 = add.next();
			if(ch1.equals("y")) addBook();
		
			if(ch1.equals("n")) {
				System.out.print("\nDo you want to save the Library y/n?");
				String ch2 = add.next();
				if(ch2.equals("n")) {
					System.out.println("Addition(s) discarded");
					System.out.println();
				}
				if(ch2.equals("y")) {
					System.out.println("Saving Library...");
					Book.saveCollection();				
					System.out.println("...Done");
					System.out.println();
				}
				
			}
			
		}catch (Exception e) {System.out.println(e);}
				
		showMenu();
	}
	
	static boolean isNumeric(String s) {
		char ch;
		for(int i=0; i<s.length(); i++) {
			ch = s.charAt(i);
			if((ch<'0') | (ch>'9') )
				return false;
		}
		return true;
	}
	
	static boolean isValidChoice(int num){
		if((num>0) && (num<=4)) return true;
		else return false;
	}
}

	