package pl.pwlctk.kursspringmvc.services;

import org.springframework.stereotype.Component;
import pl.pwlctk.kursspringmvc.models.Customer;
import pl.pwlctk.kursspringmvc.models.Package;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Component
public class CustomerService {


    @PersistenceContext
    private EntityManager em;

    private boolean initialized = false;
    private int lastId = 0;
    private HashMap<Integer, Customer> customers = new HashMap<>();

    public List<Customer> getAllCustomers() {
        List<Customer> customers = em.createQuery("from Customer", Customer.class).getResultList();
        return customers;
    }

    private void init() {
        if (!this.initialized) {
            this.customers = new HashMap<Integer, Customer>();
            int tmp = this.nextId();
            this.customers.put(tmp, new Customer(tmp, "Jerzy", "Bobek", new Package()));
            tmp = this.nextId();
            this.customers.put(tmp, new Customer(tmp, "Jerzy", "Bobek2", new Package()));
            tmp = this.nextId();
            this.customers.put(tmp, new Customer(tmp, "Jerzy", "Bob3ek", new Package()));
            this.initialized = true;
        }
    }

    @Transactional
    public void createCustomer(Customer customer) {
        em.persist(customer);
    }

    private int nextId() {
        return this.lastId++;
    }


    public void deleteCustomer(Integer id) {
        System.out.println(customers);
        System.out.println("Usuwam: " + id);
        customers.remove(id);
    }
}
