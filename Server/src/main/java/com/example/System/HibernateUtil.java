package com.example.System;

import com.example.System.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil(){}

    static {
        try {
            StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();
            sessionFactory = new MetadataSources(standardServiceRegistry)
                    .addAnnotatedClass(Role.class)
                    .addAnnotatedClass(RecordCenter.class)
                    .addAnnotatedClass(Coach.class)
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(Hall.class)
                    .addAnnotatedClass(Training.class)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

