package controller;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IProvinceService;

import java.util.List;

@Controller
@RequestMapping("Province/")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("Show")
    public ModelAndView showAll(){
        ModelAndView modelAndView = new ModelAndView("province/provinces");
        List<Province> provinces = (List<Province>) provinceService.findAll();
        modelAndView.addObject("province",provinces);
        return modelAndView;
    }

    @GetMapping("Create")
    public ModelAndView formCreate (){
        ModelAndView modelAndView = new ModelAndView("province/createProvince");
        modelAndView.addObject("create",new Province());
        return modelAndView;
    }

    @PostMapping("Create")
    public ModelAndView create(Province province) {
        ModelAndView modelAndView = new ModelAndView("province/createProvince");
        provinceService.save(province);
        modelAndView.addObject("mess" ,"Thêm mới thành công");
        modelAndView.addObject("create",new Province());
        return modelAndView;
    }

    @GetMapping("Update")
    public ModelAndView formUpdate(Long id){
        ModelAndView modelAndView = new ModelAndView("province/updateprovince");
        Province province = provinceService.findById(id);
        modelAndView.addObject("update",province);
        modelAndView.addObject("update1",new Province());
        return modelAndView;
    }

    @PostMapping("Update")
    public String update(Province province){
        provinceService.save(province);
        return "redirect:Show";
    }

    @GetMapping("Remove")
    public String remove(Long id){
        provinceService.remove(id);
        return "redirect:Show";
    }
}
