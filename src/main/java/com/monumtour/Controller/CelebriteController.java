package com.monumtour.Controller;



import com.monumtour.Model.Celebrite;
import com.monumtour.Model.Monument;
import com.monumtour.Services.Interfaces.ICelebriteService;
import com.monumtour.Services.Interfaces.IMonumentService;
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
import java.util.List;

@Controller
public class CelebriteController {

    @Autowired
    private ICelebriteService celebriteService;
    @Autowired
    private IMonumentService monumentService;

    @Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
    @RequestMapping(value = "/allCelebrite")
    public String allCelebrite(ModelMap modelMap){
        Collection<Celebrite> celebrites = celebriteService.getAllCelebrites();
        modelMap.addAttribute("celebrites", celebrites);
        return "Celebrites/allCelebrites";
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/addCelebrite")
    public String addCelebrite(ModelMap modelMap) throws ParseException {
        List<Monument> monuments = monumentService.getAllMonuments();
        modelMap.addAttribute("monuments", monuments);
        modelMap.addAttribute("mode", "new");
        return "Celebrites/celebriteForm";
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/deleteCelebrite")
    public String deleteCelebrite(@RequestParam("id") Long id,
                                     ModelMap modelMap)
    {
        celebriteService.deleteCelebrite(id);
        Collection<Celebrite> celebrites = celebriteService.getAllCelebrites();
        modelMap.addAttribute("celebrites", celebrites);
        return "Celebrites/allCelebrites";
    }
    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping("/updateCelebrite")
    public String editerCelebrite(@RequestParam("id") Long id,
                                  ModelMap modelMap)
    {
        Celebrite c = celebriteService.getCelebriteParId(id);
        List<Monument> monuments = monumentService.getAllMonuments();
        modelMap.addAttribute("monuments", monuments);
        modelMap.addAttribute("celebrite", c);
        modelMap.addAttribute("mode", "edit");
        return "Celebrites/celebriteForm";
    }
    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping("/saveCelebrite")
    public String saveCelebrite(@ModelAttribute("celebrite") Celebrite c, ModelMap modelMap)
    {
        celebriteService.save(c);
        Collection<Celebrite> celebrites = celebriteService.getAllCelebrites();
        modelMap.addAttribute("celebrites", celebrites);
        return "Celebrites/allCelebrites";
    }





}
