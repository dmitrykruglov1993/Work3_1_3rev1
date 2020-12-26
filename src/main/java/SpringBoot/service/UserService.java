package SpringBoot.service;

import SpringBoot.model.Role;
import SpringBoot.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
     boolean saveUser(User user);
     List<User> getUsers();
     User FindUserByName(String name);
     User getFromId(Long id);
     void deleteUser(Long id);
     void updateUser(User user);
     User getUserByName(String login);
     User SetUserRole(String user);
}
