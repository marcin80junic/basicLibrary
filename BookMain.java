package books;


import java.util.*;

public class BookMain {
	
	public static void main(String[] args) {
		
		Book.generateCollection();
		Library.showMenu();
		
		String str;
		int choice;
		Scanner in = new Scanner(System.in);
		
		try {
			
			do {
				
				str = in.nextLine();
				if(Library.isNumeric(str)) {
					choice = Integer.parseInt(str);
					if(Library.isValidChoice(choice)) switch(choice) {
						
						case 1:	System.out.println();
								Book.getCollection();
								System.out.println();
								Library.showMenu();
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
									Library.showMenu();
									break;
								}
								System.out.print("enter year: ");
								String y = in.nextLine();
								if(Library.isNumeric(y)) {
									int year = Integer.parseInt(in.nextLine());
									Library.addBook(author, series, title, year);
								}
								else {
									System.out.println("Error: year must be a number\n");
									Library.showMenu();
									break;
								}
								System.out.print("\nDo you want to save the Library y/n?");
								String ch2 = in.next();
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
								Library.showMenu();
								break;
						case 4: break;
						case 5: break;
						case 6: System.out.println("Quitting..");
								break;					
					}
				}
				
			}while(!str.equals("q"));
			
			in.close();
		
		} catch(Exception exc) {System.out.println(exc);}
	}
}
