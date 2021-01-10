package com.andrii.entity;

import javax.persistence.*;

@Entity
@Table(name = "books_readers")
public class Review {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "review")
    private String text;
    @ManyToOne
    @JoinColumn(name = "reader")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;

    public Review() {
    }

    public Review( String text, Reader reader, Book book) {
        this.text = text;
        this.reader = reader;
        this.book = book;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", reader=" + reader +
                ", book=" + book +
                '}';
    }

}
