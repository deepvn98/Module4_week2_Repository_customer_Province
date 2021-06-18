package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ICustomerService;
import service.IProvinceService;

@Controller
@RequestMapping("Customer/")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;

//    @GetMapping("Showall")



}
