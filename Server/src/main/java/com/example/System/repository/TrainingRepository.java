package com.example.System.repository;

import com.example.System.HibernateUtil;
import com.example.System.entity.Training;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainingRepository {
    public Training findById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.find(Training.class, id);
    }

    public Training save(Training training){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(training);
        tx1.commit();
        session.close();
        return training;
    }

    public Training update(Training training) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(tx1);
        tx1.commit();
        session.close();
        return training;
    }

    public void deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Training training= session.find(Training.class, id);
        session.remove(training);
        tx1.commit();
        session.close();
    }

    public List<Training> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("From Training", Training.class).list();
    }
}
