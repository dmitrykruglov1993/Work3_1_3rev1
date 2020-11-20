package withoutXMLs.dao;

import withoutXMLs.model.User;

import java.util.List;

public interface UserDAO {
   void save(User user);
   List<User> getUsers();
   void FirstSave();
   User getFromId(Long id);
   void deleteUser(Long id);
   void updateUser(Long id,User user);
}
