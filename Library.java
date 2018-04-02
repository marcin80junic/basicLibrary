package books;

public class Library {
	
	static void showMenu() {
		
		System.out.println("My Library Menu:");
		System.out.println();
		System.out.println("1. List all my books");
		System.out.println("2. Edit a book");
		System.out.println("3. Add a book");
		System.out.println("4. Search for a book");
		System.out.println("5. Remove a book");
		System.out.println("6. Quit");
		System.out.print("\nChoose one of avalaible options: ");
	}
	
	static void editBook() {
		
	}
	
	static void addBook(String author, String series, String title, int year) {
		
		Book newBook = new Book(author, series, title, year);
		Book.addToCollection(newBook);
			
	}
	
	static void removeBook() {
		
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
		if((num>0) && (num<=6)) return true;
		else return false;
	}
}
	