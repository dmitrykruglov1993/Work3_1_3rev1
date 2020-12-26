package SpringBoot.service;

import SpringBoot.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Role getRoleFromId(Long id);
    Set<Role> getRoles(String[] ids);
    List<Role> readRole();
}
