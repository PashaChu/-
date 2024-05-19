package com.example.System.repository;

import com.example.System.HibernateUtil;
import com.example.System.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {
    public Client findById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.find(Client.class, id);
    }

    public Client save(Client client){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(client);
        tx1.commit();
        session.close();
        return client;
    }

    public Client update(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(client);
        tx1.commit();
        session.close();
        return client;
    }

    public void deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Client client = session.find(Client.class, id);
        session.remove(client);
        tx1.commit();
        session.close();
    }

    public Client findOne(String login, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Client> query = session.createQuery("From Client Where login = ?1 and password = ?2", Client.class);
        query.setParameter(1, login).setParameter(2, password);
        return query.getSingleResult();

    }

    public List<Client> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("From Client", Client.class).list();
    }
}
