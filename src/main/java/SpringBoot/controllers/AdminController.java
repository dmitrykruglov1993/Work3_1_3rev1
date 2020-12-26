package SpringBoot.controllers;

import SpringBoot.model.Role;
import SpringBoot.model.User;
import SpringBoot.service.RoleService;
import SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;


    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/page")
    public String ViewUserListPage(User user,Model model){
        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userAuth",userService.getFromId(user.getId()));
        model.addAttribute("Alluser",userService.getUsers());
        return "page";
    }

}
