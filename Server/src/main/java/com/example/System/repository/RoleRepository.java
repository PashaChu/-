package com.example.System.repository;

import com.example.System.HibernateUtil;
import com.example.System.entity.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository {
    public Role findById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.find(Role.class, id);
    }

    public Role save(Role role){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(role);
        tx1.commit();
        session.close();
        return role;
    }

    public Role update(Role role) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(role);
        tx1.commit();
        session.close();
        return role;
    }

    public void deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Role role = session.find(Role.class, id);
        session.remove(role);
        tx1.commit();
        session.close();
    }

    public List<Role> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("From Role", Role.class).list();
    }
}
