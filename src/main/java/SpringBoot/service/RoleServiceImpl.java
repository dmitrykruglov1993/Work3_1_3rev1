package SpringBoot.service;

import SpringBoot.dao.RoleDAO;
import SpringBoot.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public Role getRoleFromId(Long id){
        return roleDAO.getRoleFromId(id);
    }

    @Override
    public Set<Role> getRoles(String[] ids) {
        return roleDAO.getRoles(ids);
    }

    @Override
    public List<Role> readRole() {
        return roleDAO.readRole();
    }
}
