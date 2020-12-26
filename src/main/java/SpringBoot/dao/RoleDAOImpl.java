package SpringBoot.dao;

import SpringBoot.model.Role;
import SpringBoot.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO{

    @PersistenceContext
    private EntityManager entityManager;

    public Role getRoleFromId(Long id){return entityManager.find(Role.class,id);}

    @Override
    public List<Role> readRole() {
        TypedQuery<Role> query= entityManager.createQuery("from Role", Role.class);
        return query.getResultList();
    }

    @Override
    public Set<Role> getRoles(String[] ids) {
        TypedQuery<Role> query= entityManager.createQuery("from Role where id = :id", Role.class);
        Set<Role> roles = new HashSet<>();
        Arrays.stream(ids).forEach(roleId -> {query.setParameter("id", Long.parseLong(roleId)); roles.add(query.getSingleResult());});
        return roles;
    }
}
