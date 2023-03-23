package edu.iu.c322.customerservice.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import edu.iu.c322.customerservice.model.*;

@Repository
public class CustomerRepository {

    private List<Customer> customers = new ArrayList<>();


    public List<Customer> findAll(){
        return customers;
    }

    public int create(Customer customer){
        int id =customers.size() +1;
        customer.setId(id);
        customers.add(customer);
        return id;
    }

    public void update(Customer customer, int id){
        Customer x = getCustomerById(id);
        if (x != null){
            System.out.println(customer.getEmail());
            System.out.println(customer.getName());
            x.setName(customer.getName());
            x.setEmail(customer.getEmail());
        }
        else {
            throw new IllegalStateException("Not Valid");
        }
    }

    public void delete(int id){
        Customer x = getCustomerById(id);
        if (x != null){
            customers.remove(x);
        }
    }

    private Customer getCustomerById(int id){
        return  customers.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }



}
