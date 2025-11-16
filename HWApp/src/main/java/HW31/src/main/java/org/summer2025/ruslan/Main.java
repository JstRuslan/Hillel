package org.summer2025.ruslan;


public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Book book1= new Book("One", "Uknown", 1);
        Book book2= new Book("Two", "Uknown", 2);
        Book book3= new Book("Three", "Uknown1", 3);
        Book book4= new Book("Four", "Uknown", 1);


        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        lib.addBook(book4);

        lib.printCatalog();

        lib.removeBook(book1);
        lib.printCatalog();
        }

}