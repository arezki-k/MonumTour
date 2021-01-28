package com.monumtour.Controller;



import com.monumtour.Model.User;
import com.monumtour.Services.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminContoller {
    @Autowired
    private IUserService userService;


    @Secured(value = {"ROLE_SUPER_ADMIN"})
    @RequestMapping("admin")
    public String admin(ModelMap modelMap){
        List<User> users = userService.getAllUsers();
        modelMap.addAttribute("users",users);
        return "Admin/admin";
    }

    @Secured(value = {"ROLE_SUPER_ADMIN"})
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("email")String email, ModelMap modelMap){
        userService.deleteUser(email);
        List<User> users = userService.getAllUsers();
        modelMap.addAttribute("users",users);
        return "Admin/admin";
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestParam("email") String email, ModelMap modelMap){
        User u = userService.getUser(email);
        modelMap.addAttribute("user", u);
        return "Admin/userForm";
    }

    @RequestMapping("saveUser")
    public String saveUser(@ModelAttribute("user") User user, ModelMap modelMap){
        User userToUpdate = userService.getUserById(user.getId());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setRoles(user.getRoles());
        userService.saveUser(userToUpdate);
        List<User> users = userService.getAllUsers();
        modelMap.addAttribute("users",users);
        return "Admin/admin";
    }

}
