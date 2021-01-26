package com.monumtour.Controller;



import com.monumtour.Model.Celebrite;
import com.monumtour.Services.Interfaces.ICelebriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Collection;
import java.util.Optional;

@Controller
public class CelebriteController {

    @Autowired
    private ICelebriteService celebriteService;

    @Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
    @RequestMapping(value = "/allCelebrite")
    public String allCelebrite(ModelMap modelMap,
                               @RequestParam(name="page",defaultValue = "0") int page,
                               @RequestParam (name="size", defaultValue = "100") int size){
        Page<Celebrite> celebrites = celebriteService.getAllCelebritesParPage(page, size);
        modelMap.addAttribute("celebrites", celebrites);
        modelMap.addAttribute("pages", new int[celebrites.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "Celebrites/allCelebrites";
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/addCelebrite")
    public String addCelebrite(@ModelAttribute("celebrite")Celebrite celebrite, ModelMap modelMap) throws ParseException {
        Celebrite celebriteToSave = celebriteService.addCelebrite(celebrite);
        String message = "New";
        modelMap.addAttribute("message", message);
        modelMap.addAttribute("mode", "new");
        return "Celebrites/celebriteForm";
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/deleteCelebrite")
    public String deleteCelebrite(@RequestParam("id") Long id,
                                     ModelMap modelMap,
                                     @RequestParam (name="page",defaultValue = "0") int page,
                                     @RequestParam (name="size", defaultValue = "100") int size)
    {
        celebriteService.deleteCelebrite(id);
        Page<Celebrite> celebrites = celebriteService.getAllCelebritesParPage(page, size);
        modelMap.addAttribute("celebrites", celebrites);
        modelMap.addAttribute("pages", new int[celebrites.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "Celebrites/allCelebrites";
    }
    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping("/updateCelebrite")
    public String editerCelebrite(@RequestParam("id") Long id,
                                  ModelMap modelMap)
    {
        Celebrite c = celebriteService.getCelebriteParId(id);
        modelMap.addAttribute("celebrite", c);
        modelMap.addAttribute("mode", "edit");
        return "Celebrites/celebriteForm";
    }





}
