package com.andrii;

import com.andrii.entity.Book;
import com.andrii.entity.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Reader.class)
                .buildSessionFactory();
        Session session = null;
        Reader reader = null;
        Book book = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            reader = session.get(Reader.class, 1L);
            System.out.println(reader);
            book = session.get(Book.class, 1L);
            System.out.println(book);

        } finally {
            factory.close();
            session.close();
        }
    }
}
