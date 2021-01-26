package com.monumtour.Controller;

import com.monumtour.Model.Departement;
import com.monumtour.Services.Interfaces.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Collection;

@Controller
public class DepartementController {
    @Autowired
    IDepartementService departementService;

    @RequestMapping("/allDepartements")
    public String getAllDepartements(ModelMap modelMap){
        Collection<Departement> departements = departementService.getAllDepartements();
        modelMap.addAttribute("departements", departements);
        return "Departements/allDepartements";
    }

    @RequestMapping("/updateDepartement")
    public String updateDepartement(@RequestParam("id") String id,
                                    ModelMap modelMap)
    {
        Departement d = departementService.getDepartement(id);
        modelMap.addAttribute("departement", d);
        modelMap.addAttribute("mode", "edit");
        return "Departements/departementForm";
    }

    @GetMapping("/addDepartement")
    public String addDepartement(ModelMap modelMap){
        modelMap.addAttribute("mode", "new");
        return "Departements/departementForm";
    }
    @RequestMapping("/saveDepartement")
    public String saveDepartement(@ModelAttribute("departement") Departement departement, ModelMap modelMap) throws ParseException
    {
        Departement saveDepartement = departementService.saveDepartement(departement);
        Collection<Departement> departements = departementService.getAllDepartements();
        modelMap.addAttribute("departements", departements);
        return "Departements/allDepartements";
    }
    @RequestMapping("/deleteDepartement")
    public String deleteDepartement(@RequestParam("id") String id,
                                       ModelMap modelMap)
    {
        departementService.deleteDepartementById(id);
        Collection<Departement> departements = departementService.getAllDepartements();
        modelMap.addAttribute("departements", departements);
        return "Departements/allDepartements";
    }

}
