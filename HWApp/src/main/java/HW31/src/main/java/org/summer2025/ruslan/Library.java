package org.summer2025.ruslan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private int bookCount;
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        if (checkBook(book)) {
            bookList.add(book);
            bookCount++;
        } else {
            System.out.printf("Book \'%s\' (ISBN=%d) didn`t add!\n", book.getTitle(), book.getIsbn());
        }
    }

    public boolean removeBook(Book book) {
        if (findBookInLibrary(book)) {
            bookCount--;
            System.out.printf("Book \'%s\' (ISBN=%d) removed from library!\n", book.getTitle(), book.getIsbn());
            return bookList.remove(book);
        } else {
            System.out.println("Book didn`t remove");
        }
        return false;
    }

    public List<Book> getBooks() {
        return bookList;
    }

    public int getBookCount() {
        return bookCount;
    }

    private boolean checkBook(Book book) {
        Objects.requireNonNull(book, "Parameter [book] must not be null!");
        if (book.getTitle() != null | book.getAuthor() != null | book.getIsbn() != 0) {
            if (!findBookInLibrary(book)) {
                return true;
            }
        } else {
            System.out.println("Some fields equal null");
        }
        return false;
    }

    private boolean findBookInLibrary(Book book) {
        for (Book bk : bookList) {
            if (bk.equals(book)) {
                return true;
            }
        }
        return false;
    }

    public void printCatalog() {
        System.out.println("Number of books: " + bookCount);
        int i = 0;
        for (Book book : bookList) {
            System.out.println(i + " : " + book);
            i++;
        }
    }
}

