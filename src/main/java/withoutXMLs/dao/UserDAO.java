package withoutXMLs.dao;

import withoutXMLs.model.User;

import java.util.List;

public interface UserDAO {

   void save(User user);
   List<User> getUsers();
   void FirstSave();
   List<User> getFromId(Long id);
   void updateUser(Long id,User user);
//   List<User> getAllUsers(User user);
//    void DeleteUser();
//    void UpdateUser();
//    String GetUserByID(Long id);
}
