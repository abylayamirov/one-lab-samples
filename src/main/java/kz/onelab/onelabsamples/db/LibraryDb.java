package kz.onelab.onelabsamples.db;

import kz.onelab.onelabsamples.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryDb {

    public static List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
         books.add(book);
    }



}
