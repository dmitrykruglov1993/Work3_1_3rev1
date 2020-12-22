package SpringBoot.controllers;

import SpringBoot.model.Role;
import SpringBoot.model.User;
import SpringBoot.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@RestController
@RequestMapping("/rest")
public class MyRestController {

    private UserService userService;

    @Autowired
    public MyRestController(UserService userService) {
        this.userService = userService;
    }

    public List<String> massage = new ArrayList<>();

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public String  ViewUserListPage(){
        Gson gson = new Gson();
        String json = gson.toJson(userService.getUsers());
        return json;

    }
    @PostMapping
    public String postUser(@RequestBody String user){
    Gson gson = new Gson();

    User userFromJson = gson.fromJson(user,User.class);

//    Set<Role> Role_Admin=new HashSet<>();
//    Set<Role> Role_User=new HashSet<>();
//
//    Role_Admin.add(userService.getRoleFromId(2L));
//    Role_User.add(userService.getRoleFromId(1L));
//
//        if(user.equals("roleId")){
//            userFromJson.setRole(Role_User);
//        }else if(user.equals("\"roleId\":[\"2\"]")){
//            userFromJson.setRole(Role_Admin);
//        }

        System.out.println("userFromJson:"+userFromJson);
        System.out.println("userBeforeJson:"+user);
    userService.saveUser(userFromJson);

    return "userFromJson";
    }

    @PostMapping ("/delete")
    public String deleteUser(String id){

        userService.deleteUser(Long.parseLong(id));

        return id;
    }

//    @PostMapping("rest/edit")
//    public User editUser(String user) {
//        User userFromJson = getUser(user);
//        userService.update(userFromJson);
//        return userFromJson;
//    }

//    private User getUser(String user, String roleIds) {
//        Gson gson = new Gson();
//        Set<String> a;
//        User userFromJson = gson.fromJson(user, User.class);
//        List<String> roleIdsFromJson = gson.fromJson(roleIds, ArrayList.class);
//        String[] roleIdsFromList = new String[roleIdsFromJson.size()];
//        for (int i=0; i<roleIdsFromList.length; i++) {
//            roleIdsFromList[i] = roleIdsFromJson.get(i);
//        }
//        userFromJson.setRole(userService.getRoles(roleIdsFromList));
//        return userFromJson;
//    }

}
