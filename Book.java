package books;

import java.util.*;
import java.io.*;


public class Book {
	
	static private ArrayList<Book>collection = new ArrayList<Book>();
	private String author;
	private String series;
	private String title;
	private int year;
			
	Book(){}
	
	Book(String author, String series, String title, int year){
		this.author = author;
		this.series = series;
		this.title = title;
		this.year = year;
	}
	
	static void generateCollection() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Library.txt"));
			String line;
			while((line = br.readLine())!= null) {
				String[]book = line.split("\"");
				Book newBook = new Book(book[1], book[3], book[5], Integer.parseInt(book[7]));
				addToCollection(newBook);
				for(int i=0; i<book.length; i++) book[i] = null;
			}
			br.close();
		}catch(Exception e) {System.out.println(e);}
	}
	
	static void getCollection() {
		for(Book a:collection) {
			System.out.print("Author: "+a.getAuthor() +", Series: "+ a.getSeries() +", Title: " +a.getTitle() +", Year: " +a.getYear());
			System.out.println();
		}
	}
	
	static void addToCollection(Book a) {
		collection.add(a);
	}
	
	static void saveCollection() {
		try {
			FileWriter fw = new FileWriter("Library.txt");
			for(Book a: collection) fw.write(a.toString()+"\n");
			fw.close();
		}catch(Exception e) {System.out.println(e);}
	}
	
	public String toString() {
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

}
