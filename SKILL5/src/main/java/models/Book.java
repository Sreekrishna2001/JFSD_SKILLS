package models;

public class Book {
public int bookid;
public String bookname;
public String bookauthor;
public String bookdesc;
public int bookprice;
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String bookcoverurl;
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getBookauthor() {
	return bookauthor;
}
public void setBookauthor(String bookauthor) {
	this.bookauthor = bookauthor;
}
public String getBookdesc() {
	return bookdesc;
}
public void setBookdesc(String bookdesc) {
	this.bookdesc = bookdesc;
}
public int getBookprice() {
	return bookprice;
}
public void setBookprice(int bookprice) {
	this.bookprice = bookprice;
}
public String getBookcoverurl() {
	return bookcoverurl;
}
public void setBookcoverurl(String bookcoverurl) {
	this.bookcoverurl = bookcoverurl;
}

}
