package withoutXMLs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import withoutXMLs.model.User;
import withoutXMLs.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/page")
    public String ViewUserListPage(Model model){
        model.addAttribute("user",userService.getUsers());
        return "/page";
    }

    //Добавление нового юзера

    @GetMapping("/new")
    public String getNewUser(@ModelAttribute("user") User user){
        return "newUser";
    }

    @PostMapping
    public String create(User user){
        userService.saveUser(user);
        return "redirect:/page";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/page";
    }

    //Обновить юзера

    @GetMapping("/up/{id}")
    public String ShowUpdatePage(@PathVariable("id") Long id, Model model){
        model.addAttribute("user",userService.getFromId(id));
        return "updatePage";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")User user,@PathVariable("id") Long id){
        userService.updateUser(id,user);
        return "redirect:/page";
    }
}
