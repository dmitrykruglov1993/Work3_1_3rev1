package SpringBoot.dao;

import SpringBoot.model.Role;
import SpringBoot.model.User;

import java.util.List;
import java.util.Set;

public interface UserDAO {
   boolean saveUser(User user);
   List<User> getUsers();
   User getUserByName(String login);
   User getFromId(Long id);
   void deleteUser(Long id);
   void updateUser(User user);
   User findUserByName(String name);

   User SetUserRole(String user);
}
