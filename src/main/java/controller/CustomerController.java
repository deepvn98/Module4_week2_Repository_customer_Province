package controller;

import model.Customer;
import model.CustomerFile;
import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ICustomerService;
import service.IProvinceService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("Customer/")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private Environment environment;

    @ModelAttribute("provinces")
    public List<Province> getList(){
        return (List<Province>) provinceService.findAll();
    }

    @GetMapping("Create")
    public ModelAndView formCreate(){
        ModelAndView modelAndView = new ModelAndView("customer/createcustomer");
        modelAndView.addObject("customerFile",new CustomerFile());
        return modelAndView;
    }

    @PostMapping("Create")
    public ModelAndView create(CustomerFile customerFile){
        ModelAndView modelAndView = new ModelAndView("customer/createcustomer");
        MultipartFile multipartFile = customerFile.getImg();
        String fileName = multipartFile.getOriginalFilename();
        String localFile = environment.getProperty("fileImg");
        try {
            FileCopyUtils.copy(multipartFile.getBytes(),new File(localFile+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Customer customer1 = new Customer();
        customer1.setId((long) (Math.random()*10000));
        customer1.setName(customerFile.getName());
        customer1.setProvince(customerFile.getProvince());
        customer1.setImg(fileName);
        customerService.save(customer1);
        modelAndView.addObject("Customer",new CustomerFile());
        modelAndView.addObject("message","Thêm mới thành công");
        return modelAndView;
    }

    @GetMapping("Show")
    public ModelAndView Show(){
        List<Customer> customerList = (List<Customer>) customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("customer/customers");
        modelAndView.addObject("customer",customerList);
        return modelAndView;
    }


    @GetMapping("Remove")
    public String remove(Long id){
        customerService.remove(id);
        return "redirect:Show";
    }






}
