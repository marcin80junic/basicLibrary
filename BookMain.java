package books;


import java.util.*;

public class BookMain {
	
	public static void main(String[] args) {
		
		Book.generateCollection();
				
		String str;
		int choice;
		Scanner in = new Scanner(System.in);
		
		try {
			
			do {
				
				Library.showMenu();
				str = in.nextLine();
				if(Library.isNumeric(str)) {
					choice = Integer.parseInt(str);
					if(Library.isValidChoice(choice)) switch(choice) {
						
						case 1:	System.out.println();
								Book.getCollection();
								System.out.println();
								break;
						case 2: Library.editBook();
								break;
						case 3: System.out.print("\nenter author: ");
								String author = in.nextLine();
								System.out.print("enter series: ");
								String series = in.nextLine();
								System.out.print("enter title: ");
								String title = in.nextLine();
								if(title.equals("")||series.equals("")||author.equals("")) {
									System.out.println("Error: can't accept empty fields\n");
									break;
								}
								System.out.print("enter year: ");
								String y = in.nextLine();
								if(Library.isNumeric(y)) {
									int year = Integer.parseInt(y);
									Book newBook = new Book(author, series, title, year);
									Book.addToCollection(newBook);
								}
								else {
									System.out.println("Error: year must be a number\n");
									break;
								}
								System.out.print("\nDo you want to save the Library y/n?");
								String ch2 = in.nextLine();
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
								break;
						case 4: break;
						case 5: Book.getCollection();
								System.out.print("\nChoose the book to remove (enter the index number):");
								break;
						default: System.out.println("\nnot a valid choice, try again...\n");
					
					} else System.out.println("\nnot a valid choice, try again...\n");
				} if(str.equals("q")) System.out.println("Quitting..");
			}while(!str.equals("q"));
			
			in.close();
		
		}catch(Exception exc) {System.out.println(exc);} 
	}
}
