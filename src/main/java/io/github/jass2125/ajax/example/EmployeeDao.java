/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.ajax.example;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Anderson Souza
 */
public class EmployeeDao {

    private EntityManager em;

    public EmployeeDao() {
        this.em = Persistence.createEntityManagerFactory("pu").createEntityManager();
    }

    public Employee search(String name) {
        try {
            em.getTransaction().begin();
//            Query query = em.createQuery("SELECT * FROM employee as e where e.name = ?name");
//            query.setParameter("name", name);
//            Object singleResult = query.getSingleResult();
            TypedQuery<Employee> query = em.createQuery("SELECT E FROM Employee E WHERE E.name = :name", Employee.class);
            query.setParameter("name", name);
            Employee singleResult = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return singleResult;
        } catch (NoResultException e) {
            return null;
        }
    }

}
