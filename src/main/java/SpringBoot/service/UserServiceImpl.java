package SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import SpringBoot.dao.UserDAO;

import SpringBoot.model.Role;
import SpringBoot.model.User;


import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean saveUser(User user) {
        userDAO.saveUser(user);
        return true;
    }
    @Override
    public Role getRoleFromId(Long id){
        return userDAO.getRoleFromId(id);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public User getFromId(Long id) {
        return userDAO.getFromId(id);
    }

    @Override
    public User getUserByName(String login) {
        return userDAO.getUserByName(login);
    }

    @Override
    public List<Role> getAllRoles() {
        return userDAO.readRole();
    }

    @Override
    public void deleteUser(Long id) {
    userDAO.deleteUser(id);
    }
    @Override
    public Set<Role> getRoles(String[] ids) {
        return userDAO.getRoles(ids);
    }

    @Override
    public void updateUser(Long id, User user) {
    userDAO.updateUser(id,user);
    }

    @Override
    public User FindUserByName(String name){
      return userDAO.findUserByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(userDAO.findUserByName(s) == null){
            throw new UsernameNotFoundException("User not found");
        }
        return userDAO.findUserByName(s);
    }
}
