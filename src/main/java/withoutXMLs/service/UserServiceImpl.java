package withoutXMLs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import withoutXMLs.dao.UserDAO;
import withoutXMLs.dao.UserDAOImpl;
import withoutXMLs.model.User;

import java.util.List;

@Component
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public void FirstSave() {
        userDAO.FirstSave();
    }

    @Override
    public User getFromId(Long id) {
        return userDAO.getFromId(id);
    }

    @Override
    public void deleteUser(Long id) {
    userDAO.deleteUser(id);
    }

    @Override
    public void updateUser(Long id, User user) {
    userDAO.updateUser(id,user);
    }
}
