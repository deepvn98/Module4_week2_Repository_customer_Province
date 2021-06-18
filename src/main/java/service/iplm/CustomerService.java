package service.iplm;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ICustomerRepository;
import service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remove(Long id) {

    }
}
