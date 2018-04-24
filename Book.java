package books;

import java.util.*;
import java.io.*;

public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	static private Map<Integer, Book> collection = new LinkedHashMap<Integer, Book>();
	private String author;
	private String series;
	private String title;
	private int year;
	static private int index;
	static int i;

	Book() {
	}

	Book(String author, String series, String title, int year) {
		this.author = author;
		this.series = series;
		this.title = title;
		this.year = year;
	}

	static void generateCollection() throws Exception{
		index = 1;
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("Ser.txt"));
			@SuppressWarnings("unchecked")
			ArrayList<Book> al = (ArrayList<Book>)oin.readObject();
			for(Book b: al) {
				collection.put(index,  b);
				index++;
			}
			oin.close();
		}catch (FileNotFoundException exc) {System.out.println("The archive doesn't exist or is empty");}
	}

	static void printCollection() {
		System.out.println();
		for (Map.Entry<Integer, Book> a : collection.entrySet()) {
			index = a.getKey();
			Book b = a.getValue();
			System.out.print("Index: " + index + ", Author: " + b.getAuthor() + ", Series: \"" + b.getSeries()
					+ "\", Title: \"" + b.getTitle() + "\", Year: " + b.getYear());
			System.out.println();
		}
		System.out.println();
	}
	
	static void sortCollection(int i) {
		ArrayList<Book> library = new ArrayList<>();
		index = 1;
		for(Map.Entry<Integer, Book> entry: collection.entrySet()) {
			Book b = entry.getValue();
			library.add(b);
		}
		switch(i) {
		
		case 1: Collections.sort(library, new Comparator<Book>() {
				public int compare(Book b1, Book b2) {
					return b1.author.compareTo(b2.author);
				}
			});
			for(Book b: library) {
				collection.put(index, b);
				index++;
			}
			printCollection();
			break;
		case 2: Collections.sort(library, new Comparator<Book>() {
				public int compare(Book b1, Book b2) {
					return b1.series.compareTo(b2.series);
				}
			});
			for(Book b: library) {
				collection.put(index, b);
				index++;
			}
			printCollection();
			break;
		case 3: Collections.sort(library, new Comparator<Book>() {
				public int compare(Book b1, Book b2) {
					return b1.title.compareTo(b2.title);
				}
			});
			for(Book b: library) {
				collection.put(index, b);
				index++;
			}
			printCollection();
			break;
		case 4: Collections.sort(library,  new Comparator<Book>() {
				public int compare(Book b1, Book b2) {
					if(b1.year==b2.year)return 0;
					else if(b1.year > b2.year) return 1;
					else return -1;
				}
			});
			printCollection();
			break;
		}
	}

	static void addToCollection(Book a) {
		int i = collection.size() + 1;
		collection.put(i, a);
	}

	static void addToCollection(Integer i, Book a) {
		collection.put(i, a);
	}

	static void removeFromCollection(int i) {
		try {
			collection.remove(i);
			saveCollection();
			collection.clear();
			generateCollection();
		}catch(Exception e) {System.out.println(e);}
	}

	static void saveCollection() throws Exception{
		FileOutputStream fout = new FileOutputStream("Ser.txt");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		ArrayList<Book> al = new ArrayList<>();
		for(Map.Entry<Integer, Book> entry: collection.entrySet()) {
			Book b = entry.getValue();
			al.add(b);
		}
		out.writeObject(al);
		out.flush();
		out.close();
	}
	
	static void searchCollection(String sea) {
		System.out.println("The results matching \"" +sea+"\":");
		System.out.println();
		for(Map.Entry<Integer, Book> entry: collection.entrySet()) {
			Book b = entry.getValue();
			index = entry.getKey();
			if((b.author.contains(sea)) || (b.series.contains(sea)) || (b.title.contains(sea)) || (String.valueOf(b.year).contains(sea))) {
				System.out.println("Index: " + index + ", Author: " + b.getAuthor() + ", Series: \"" + b.getSeries()
					+ "\", Title: \"" + b.getTitle() + "\", Year: " + b.getYear());
			}
		}
		System.out.println();
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
		try {
			for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
				if (i == entry.getKey()) {
					Book b = entry.getValue();
					b.author = a;
					saveCollection();
				}
			}
		}catch(Exception e) {System.out.println(e);}
	}

	static void setSeries(int i, String s) {
		try {
			for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
				if (i == entry.getKey()) {
					Book b = entry.getValue();
					b.series = s;
					saveCollection();
				}
			}
		}catch(Exception e) {System.out.println(e);}
	}

	static void setTitle(int i, String t) {
		try {
			for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
				if (i == entry.getKey()) {
					Book b = entry.getValue();
					b.title = t;
					saveCollection();
				}
			}
		}catch(Exception e) {System.out.println(e);}
	}

	static void setYear(int i, int y) {
		try {
			for (Map.Entry<Integer, Book> entry : collection.entrySet()) {
				if (i == entry.getKey()) {
					Book b = entry.getValue();
					b.year = y;
					saveCollection();
				}
			}
		}catch(Exception e) {System.out.println(e);}
	}

}
