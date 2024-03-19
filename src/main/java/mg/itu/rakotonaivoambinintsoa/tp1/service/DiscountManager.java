/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.rakotonaivoambinintsoa.tp1.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.itu.rakotonaivoambinintsoa.tp1.entities.Discount;

/**
 * Façade pour gerer les discounts/les codes de reduction
 * @author rakot
 */
@RequestScoped
public class DiscountManager {
    
    @PersistenceContext(unitName="customerPU")
    private EntityManager em;
    
    //Lister tous les codes de reduction
    public List<Discount> getAllDiscounts(){
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }
    
    @Transactional
    public Discount update(Discount discount){
        return em.merge(discount);
    }
    
    //Chercher par ID
    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }
}
