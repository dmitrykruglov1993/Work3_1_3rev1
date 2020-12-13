package SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import SpringBoot.model.User;
import SpringBoot.service.UserService;

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

    //Добавление нового юзера

    @GetMapping("/new")
    public String getNewUser(@ModelAttribute("user") User user){
        return "newUser";
    }

    @PostMapping
    public String create(User user){
        userService.saveUser(user);
        return "redirect:/admin/page/";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/admin/page/";
    }

    //Обновить юзера
    @GetMapping("/up/{id}")
    public String ShowUpdatePage(@PathVariable("id") Long id, Model model){
        model.addAttribute("user",userService.getFromId(id));
        return "updatePage";
    }

    @PostMapping("/up/{id}")
    public String update(@ModelAttribute("user")User user,@PathVariable("id") Long id){
        userService.updateUser(id,user);
        return "redirect:/admin/page/";
    }
}
