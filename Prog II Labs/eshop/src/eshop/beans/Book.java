package eshop.beans;

public class Book {
	private String author;
  private String id;
  private double price;
  private String title;
  private String ISBN;
  

	public String getISBN() { return ISBN; }
	public void setISBN(String ISBN) { this.ISBN = ISBN; }
	
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	
  }
