package com.example.System.repository;

import com.example.System.HibernateUtil;
import com.example.System.entity.Hall;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HallRepository {
    public Hall findById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.find(Hall.class, id);
    }

    public Hall save(Hall hall){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(hall);
        tx1.commit();
        session.close();
        return hall;
    }

    public Hall update(Hall hall) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(hall);
        tx1.commit();
        session.close();
        return hall;
    }

    public void deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Hall hall = session.find(Hall.class, id);
        session.remove(hall);
        tx1.commit();
        session.close();
    }

    public List<Hall> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("From Hall", Hall.class).list();
    }
}
