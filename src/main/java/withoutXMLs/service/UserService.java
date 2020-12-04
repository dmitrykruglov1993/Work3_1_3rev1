package withoutXMLs.service;

import withoutXMLs.model.Role;
import withoutXMLs.model.User;

import java.util.List;

public interface UserService {
     boolean saveUser(User user);
     List<User> getUsers();
     User getUserByName(String login);
     User getFromId(Long id);
     void deleteUser(Long id);
     void updateUser(Long id,User user);
     User FindUserByName(String name);
     Role getRoleFromId(Long id);
}
