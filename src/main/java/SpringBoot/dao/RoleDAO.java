package SpringBoot.dao;

import SpringBoot.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDAO {
    Role getRoleFromId(Long id);
    Set<Role> getRoles(String[] ids);
    List<Role> readRole();
}
