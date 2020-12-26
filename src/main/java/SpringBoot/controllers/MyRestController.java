package SpringBoot.controllers;

import SpringBoot.model.Role;
import SpringBoot.model.User;
import SpringBoot.service.RoleService;
import SpringBoot.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/rest")
public class MyRestController {

    private UserService userService;

    @Autowired
    public MyRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User>  ViewUserListPage(){
        return userService.getUsers();
    }
    @PostMapping
    public User postUser(@RequestBody String user){
        userService.saveUser(userService.SetUserRole(user));
        return userService.SetUserRole(user);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/edit")
    public User putUser(@RequestBody String userUp){
        userService.updateUser(userService.SetUserRole(userUp));
        return userService.SetUserRole(userUp);
    }

}
