package model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customerList;

    public Province(String name, List<Customer> customerList) {
        this.name = name;
        this.customerList = customerList;
    }

    public Province(Long id, String name, List<Customer> customerList) {
        this.id = id;
        this.name = name;
        this.customerList = customerList;
    }

    public Province() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
