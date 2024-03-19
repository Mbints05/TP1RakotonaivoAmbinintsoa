/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Création d'un Bean CDI CustomerManager pour la gestion des clients
package mg.itu.rakotonaivoambinintsoa.tp1.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.itu.rakotonaivoambinintsoa.tp1.entities.Customer;

/**
 * Façade pour gérer les Customers.
 *
 * @author rakot
 */
@RequestScoped
public class CustomerManager {

    //l'EntityManager (c'est l'annotation @PersistenceContext qui provoquera l'injection)
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    //getAllCustomers() qui retourne la liste de tous les customers ;
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    //update qui met à jour un customer dans la base de données.
    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

    //une méthode persist pour ajouter un nouveau customer dans la base de données, avec les valeurs contenues dans l'entité passée en paramètre
    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }
    
    //Chercher par ID
    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }
}
