package withoutXMLs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import withoutXMLs.dao.UserDAO;
import withoutXMLs.dao.UserDAOImpl;
import withoutXMLs.model.User;
import withoutXMLs.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //Добавление первой записи в БД
    @Autowired
    public void FirstUserInTable(){
        userDAO.FirstSave();
    }

    @GetMapping("/")
    public String ViewUserListPage(Model model){
        model.addAttribute("user",userDAO.getUsers());
        return "page";
    }

    //Добавление нового юзера
    @GetMapping("/new")
    public String getNewUser(@ModelAttribute("user") User user){
        return "newUser";
    }
    @PostMapping
    public String create(User user){
        userDAO.save(user);
        return "redirect:/";
    }

    //Показать юзера с id
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        model.addAttribute("user",userDAO.getFromId(id));
        return "show";
    }

    //Обновить юзера
    @GetMapping("/update/{id}")
    public String ShowUpdatePage(@PathVariable("id") Long id, Model model){
        model.addAttribute("user",userDAO.getFromId(id));
        return "updatePage";
    }

    @PatchMapping("{/id}")
    public String update(@ModelAttribute("user") User user,@PathVariable("id") Long id){
        userDAO.updateUser(id,user);
        return "redirect:/";
    }

}
