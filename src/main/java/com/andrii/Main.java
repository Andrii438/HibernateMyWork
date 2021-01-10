package com.andrii;

import com.andrii.entity.Book;
import com.andrii.entity.Reader;
import com.andrii.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Reader.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = null;
        Reader reader = null;
        Book book = null;
        List<Review> reviewPersonList = new ArrayList<>();
        List<Review> reviewBookList = new ArrayList<>();
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            reader = session.get(Reader.class, 2L);
//            System.out.println(reader);
            book = session.get(Book.class, 1L);
//            System.out.println(book);
       //     Review review = new Review("Great book",reader,book);
    //        session.save(review);
            reviewPersonList= reader.getReviews();
            reviewBookList=book.getReviews();

     //       session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
        reviewBookList.forEach(System.out::println);
        System.out.println("============");
        reviewPersonList.forEach(System.out::println);
    }
}
