package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IProvinceService;

@Controller
@RequestMapping("Province/")
public class ProvinceController {

    @Autowired
    private IProvinceService provinceService;

    @GetMapping("Show")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject()
    }

}
