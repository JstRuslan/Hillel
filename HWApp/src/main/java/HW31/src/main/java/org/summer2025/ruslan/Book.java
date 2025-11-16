package org.summer2025.ruslan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
public class Book {
    private String title;
    private String author;
    private int isbn;

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        Book book = (Book) object;
        return getIsbn() == book.getIsbn();
    }

    @Override
    public int hashCode() {
        return getTitle().hashCode() +  getAuthor().hashCode() + getIsbn();
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn=" + isbn
                ;
    }
}
