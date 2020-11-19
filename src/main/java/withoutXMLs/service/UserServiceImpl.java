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

    @Autowired
    private UserDAO userDAO;

    public void save(User user){

    }
}
