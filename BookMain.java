package books;

import java.util.*;

public class BookMain {

	public static void main(String[] args) {

		String str;
		int choice;
		Scanner in = new Scanner(System.in);

		try {
			Book.generateCollection();
			do {

				Library.showMenu();
				str = in.nextLine();
				if (Library.isNumeric(str)) {
					choice = Integer.parseInt(str);
					if (Library.isValidChoice(choice))
						switch (choice) {

						case 1:
							Book.printCollection();
							break;
						case 2:
							Book.printCollection();
							System.out.print("\nWhich book would you like to edit?\nchoose index number: ");
							String e = in.nextLine();
							if (Library.isNumeric(e)) {
								int i = Integer.parseInt(e);
								System.out.println("\n" + Book.getBook(i));
								Library.editBook(i);
								String ed = in.nextLine();
								if (Library.isNumeric(ed)) {
									int j = Integer.parseInt(ed);
									switch (j) {
									case 1:
										System.out.print("\nEnter new author: ");
										String aut = in.nextLine();
										System.out.print("\nDo you want to change " + Book.getAuthor(i) + " to " + aut
												+ " ? y/n: ");
										String ch1 = in.nextLine();
										if (ch1.equals("n"))
											System.out.println("Changes discarded");
										else if (ch1.equals("y")) {
											System.out.print("saving new author...");
											Book.setAuthor(i, aut);
											System.out.println("done");
										} else
											System.out.println("The choice must be \"y\" or \"n\"");
										break;
									case 2:
										System.out.print("\nEnter new series: ");
										String ser = in.nextLine();
										System.out.print("\nDo you want to change " + Book.getSeries(i) + " to " + ser
												+ " ? y/n: ");
										String ch2 = in.nextLine();
										if (ch2.equals("n"))
											System.out.println("Changes discarded");
										else if (ch2.equals("y")) {
											System.out.print("saving new series...");
											Book.setSeries(i, ser);
											System.out.println("done");
										} else
											System.out.println("The choice must be \"y\" or \"n\"");
										break;
									case 3:
										System.out.print("\nEnter new title: ");
										String tit = in.nextLine();
										System.out.print("\nDo you want to change " + Book.getTitle(i) + " to " + tit
												+ " ? y/n: ");
										String ch3 = in.nextLine();
										if (ch3.equals("n"))
											System.out.println("Changes discarded");
										else if (ch3.equals("y")) {
											System.out.print("saving new title...");
											Book.setTitle(i, tit);
											System.out.println("done");
										} else
											System.out.println("The choice must be \"y\" or \"n\"");
										break;
									case 4:
										System.out.print("Enter new year: ");
										String yea = in.nextLine();
										if (Library.isNumeric(yea)) {
											int nyear = Integer.parseInt(yea);
											System.out.print("\n Do you want to change " + Book.getYear(i) + " to "
													+ nyear + " ? y/n: ");
											String ch4 = in.nextLine();
											if (ch4.equals("n"))
												System.out.println("Changes discarded");
											else if (ch4.equals("y")) {
												System.out.print("saving new year...");
												Book.setYear(i, nyear);
												System.out.println("done");
											} else
												System.out.print("The choice must be \"y\" or \"n\"");
										} else
											System.out.println("Year must be a numeric value..");
										break;
									default:
										System.out.println("Not a valid choice..");
										break;
									}
								} else
									System.out.println("enter numeric value please..");
							} else
								System.out.println("enter numeric value please..");
							break;
						case 3:
							System.out.print("\nenter author: ");
							String author = in.nextLine();
							System.out.print("\nenter series: ");
							String series = in.nextLine();
							System.out.print("\nenter title: ");
							String title = in.nextLine();
							if (title.equals("") || series.equals("") || author.equals("")) {
								System.out.println("Error: can't accept empty fields");
								break;
							}
							System.out.print("\nenter year: ");
							String y = in.nextLine();
							if (Library.isNumeric(y)) {
								int year = Integer.parseInt(y);
								Book newBook = new Book(author, series, title, year);
								System.out.print("\nDo you want to save the Library y/n?");
								String ch2 = in.nextLine();
								if (ch2.equals("n"))
									System.out.println("Addition(s) discarded");
								else if (ch2.equals("y")) {
									System.out.print("Saving Library...");
									Book.saveCollection();
									System.out.println("...Done");
									Book.addToCollection(newBook);
								} 
								else {
									System.out.println("Error: year must be a number");
									break;
								}
							}
							break;
						case 4: 
							System.out.print("Enter a text to search for: ");
							String sea = in.nextLine();
								
							break;
						case 5:
							Book.printCollection();
							System.out.print("\nChoose the book to remove (enter the index number):");
							String s = in.nextLine();
							if (Library.isNumeric(s)) {
								int i = Integer.parseInt(s);
								System.out
										.print("Are you sure you want to remove this book: " + Book.getBook(i) + " ? ");
								String st = in.nextLine();
								if (st.equals("n"))
									System.out.println("Action cancelled");
								if (st.equals("y")) {
									System.out.print("\nRemoving a book...");
									Book.removeFromCollection(i);
									System.out.println("...Done");
								} else
									System.out.println("The choice must be \"y\" or \"n\"");
							} else
								System.out.println("wrong number format");
							break;
						default:
							System.out.println("\nnot a valid choice, try again...");
						}
					else
						System.out.println("\nnot a valid choice, try again...");
				}
				if (str.equals("q"))
					System.out.println("Quitting..");
			} while (!str.equals("q"));

			in.close();

		} catch (Exception exc) {
			System.out.println(exc);
		}
	}
}
