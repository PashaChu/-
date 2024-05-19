package com.example.System.repository;

import com.example.System.HibernateUtil;
import com.example.System.entity.RecordCenter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordRepository {
    public RecordCenter findById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.find(RecordCenter.class, id);
    }

    public RecordCenter save(RecordCenter record){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(record);
        tx1.commit();
        session.close();
        return record;
    }

    public RecordCenter update(RecordCenter record) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(record);
        tx1.commit();
        session.close();
        return record;
    }

    public void deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        RecordCenter record = session.find(RecordCenter.class, id);
        session.remove(record);
        tx1.commit();
        session.close();
    }

    public RecordCenter findOne(Long id, String login, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("From Record", RecordCenter.class)
                .setParameter("id", id)
                .setParameter("login", login)
                .setParameter("password", password).getSingleResult();
    }

    public List<RecordCenter> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("From Record", RecordCenter.class).list();
    }
}
