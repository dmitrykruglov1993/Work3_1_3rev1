package withoutXMLs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import withoutXMLs.model.User;

import java.util.List;

public interface UserDAO {
   boolean saveUser(User user);
   List<User> getUsers();
//   void AddRolesAndAdmin();
   User getUserByName(String login);
   User getFromId(Long id);
   void deleteUser(Long id);
   void updateUser(Long id,User user);
   User findUserByName(String name);
}
