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
import mg.itu.rakotonaivoambinintsoa.tp1.entities.MicroMarket;

/**
 * Façade pour gerer les Micromarket
 * @author rakot
 */
@RequestScoped
public class MicroMarketManager {
    
    @PersistenceContext(unitName="customerPU")
    private EntityManager em;
    
    //Lister tous les codes de reduction
    public List<MicroMarket> getAllMicromarket(){
        Query query = em.createNamedQuery("MicroMarket.findAll");
        return query.getResultList();
    }
    
    @Transactional
    public MicroMarket update(MicroMarket microMarket){
        return em.merge(microMarket);
    }
    
    //Chercher par ID
    public MicroMarket findById(String code) {
        return em.find(MicroMarket.class, code);
    }
}
