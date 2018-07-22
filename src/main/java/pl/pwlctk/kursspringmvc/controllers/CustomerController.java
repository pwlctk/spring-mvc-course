package pl.pwlctk.kursspringmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pwlctk.kursspringmvc.models.Customer;
import pl.pwlctk.kursspringmvc.services.CustomerService;
import java.util.ArrayList;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/hello")
    public String hello() {
        return "hello.html";
    }

    @RequestMapping("/customers")
    public String customers(Model model) {
        ArrayList<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @RequestMapping("/customer/create")
    public String create(Model model) {
        Customer customer = new Customer();
        model.addAttribute("action", "Tworzenie klienta");
        model.addAttribute("customer", customer);
        return "/createCustomer";
    }

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    public String createCustomer(Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customers";

    }

    @RequestMapping(value = "/customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";



    }
}
