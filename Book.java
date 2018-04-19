package books;

import java.util.*;
import java.io.*;

public class Book {

	static private Map<Integer, Book> collection = new LinkedHashMap<Integer, Book>();
	private String author;
	private String series;
	private String title;
	private int year;
<<<<<<< HEAD
	static private int index;

	Book() {
	}

	Book(String author, String series, String title, int year) {
=======
			
	Book(){}
	
	Book(String author, String series, String title, int year){
>>>>>>> 40e5711425161bfadad20efdd74370a76765c999
		this.author = author;
		this.series = series;
		this.title = title;
		this.year = year;
	}

	static void generateCollection() {
		index = 1;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Library.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] book = line.split("\"");
				Book newBook = new Book(book[1], book[3], book[5], Integer.parseInt(book[7]));
				addToCollection(index, newBook);
				index++;
				for (int i = 0; i < book.length; i++)
					book[i] = null;
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Archive is empty");
		}
	}

	static void printCollection() {
		for (Map.Entry<Integer, Book> a : collection.entrySet()) {
			index = a.getKey();
			Book b = a.getValue();
			System.out.print("Index: " + index + ", Author: " + b.getAuthor() + ", Series: \"" + b.getSeries()
					+ "\", Title: \"" + b.getTitle() + "\", Year: " + b.getYear());
			System.out.println();
		}
		System.out.println();
	}

	static void addToCollection(Book a) {
		int i = collection.size() + 1;
		collection.put(i, a);
	}

	static void addToCollection(Integer i, Book a) {
		collection.put(i, a);
	}

	static void removeFromCollection(int i) {
		collection.remove(i);
		saveCollection();
		collection.clear();
		generateCollection();
	}

	static void saveCollection() {
		try {
			FileWriter fw = new FileWriter("Library.txt");
			for (Map.Entry<Integer, Book> a : collection.entrySet()) {
				fw.write(a.toString() + "\n");
			}
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String toString() {
<<<<<<< HEAD
		return "Author: \"" + author + "\", Series: \"" + series + "\", Title: \"" + title + "\", Year: \"" + year
				+ "\"";
	}

	static String getBook(int i) {
		for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
			if (i == entry.getKey()) {
				Book b = entry.getValue();
				return b.author + " " + b.series + " " + b.title + " " + b.year;
			}
		}
		return "invalid choice";
	}

	static String getAuthor(int i) {
		for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
			if (i == entry.getKey()) {
				Book b = entry.getValue();
				return b.author;
			}
		}
		return "invalid choice";
	}

	static String getSeries(int i) {
		for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
			if (i == entry.getKey()) {
				Book b = entry.getValue();
				return b.series;
			}
		}
		return "invalid choice";
	}

	static String getTitle(int i) {
		for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
			if (i == entry.getKey()) {
				Book b = entry.getValue();
				return b.title;
			}
		}
		return "invalid choice";
	}

	static String getYear(int i) {
		for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
			if (i == entry.getKey()) {
				Book b = entry.getValue();
				return String.valueOf(b.year);
			}
		}
		return "invalid choice";
	}

	String getAuthor() {
		return author;
	}

	String getSeries() {
		return series;
	}

	String getTitle() {
		return title;
	}

	int getYear() {
		return year;
	}

	static int getCollection() {
		return collection.size();
	}

	static void setAuthor(int i, String a) {
		for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
			if (i == entry.getKey()) {
				Book b = entry.getValue();
				b.author = a;
				saveCollection();
			}
		}
	}

	static void setSeries(int i, String s) {
		for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
			if (i == entry.getKey()) {
				Book b = entry.getValue();
				b.series = s;
				saveCollection();
			}
		}
	}

	static void setTitle(int i, String t) {
		for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
			if (i == entry.getKey()) {
				Book b = entry.getValue();
				b.title = t;
				saveCollection();
			}
		}
	}

	static void setYear(int i, int y) {
		for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
			if (i == entry.getKey()) {
				Book b = entry.getValue();
				b.year = y;
				saveCollection();
			}
		}
	}
=======
		return "Author: \""+author+"\", Series: \""+series+"\", Title: \""+title+"\", Year: \""+year+"\"";
	}
	
	String getAuthor() {return author;}
	String getSeries() {return series;}
	String getTitle() {return title;}
	int getYear() {return year;}
		
	void setAuthor(String a) {author = a;}
	void setSeries(String s) {series = s;}
	void setTitle(String t) {title = t;}
	void setYear(int y) {year = y;}
>>>>>>> 40e5711425161bfadad20efdd74370a76765c999

}
