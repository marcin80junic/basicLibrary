package books;

public class Library {

	static void showMenu() {
		System.out.println();
		System.out.println("My Library Menu:");
		System.out.println();
		System.out.println("1. List all my books");
		System.out.println("2. Edit a book");
		System.out.println("3. Add a book");
		System.out.println("4. Search for a book");
		System.out.println("5. Remove a book");
		System.out.println("Press \"q\" to quit");
		System.out.println();
		System.out.print("\nChoose one of avalaible options: ");
	}
	
	static void collectionMenu() {
		System.out.println();
		System.out.println("1. Sort according to author.");
		System.out.println("2. Sort according to series.");
		System.out.println("3. Sort according to title.");
		System.out.println("4. Sort according to year.");
		System.out.println("press \"q\" to go back to main menu");
		System.out.println();
		System.out.print("Choose one of the options:");
	}

	static void editBook(int i) {
		System.out.println();
		System.out.println("1. Author: " + Book.getAuthor(i));
		System.out.println("2. Series: " + Book.getSeries(i));
		System.out.println("3. Title: " + Book.getTitle(i));
		System.out.println("4. Year: " + Book.getYear(i));
		System.out.println();
		System.out.print("Choose which value would you like to change (enter a number): ");
	}

	static boolean isNumeric(String s) {
		char ch;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if ((ch < '0') | (ch > '9'))
				return false;
		}
		return true;
	}

	static boolean isValidChoice(int num, int opt) {
		if ((num > 0) && (num <= opt))
			return true;
		else
			return false;
	}
}
