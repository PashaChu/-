package com.example.System.repository;

import com.example.System.HibernateUtil;
import com.example.System.entity.Coach;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoachRepository {
    public Coach findById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.find(Coach.class, id);
    }

    public Coach save(Coach coach){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(coach);
        tx1.commit();
        session.close();
        return coach;
    }

    public Coach update(Coach coach) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(coach);
        tx1.commit();
        session.close();
        return coach;
    }

    public void deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Coach coach = session.find(Coach.class, id);
        session.remove(coach);
        tx1.commit();
        session.close();
    }

    public List<Coach> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("From Coach", Coach.class).list();
    }
}
