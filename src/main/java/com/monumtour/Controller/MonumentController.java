package com.monumtour.Controller;


import com.monumtour.Model.Departement;
import com.monumtour.Model.Lieu;
import com.monumtour.Services.Interfaces.IDepartementService;
import com.monumtour.Services.Interfaces.ILieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Controller
public class MonumentController {

}
