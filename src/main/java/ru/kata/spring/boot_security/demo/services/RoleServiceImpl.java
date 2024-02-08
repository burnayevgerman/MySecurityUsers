package ru.kata.spring.boot_security.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Role> getAllRoles() {
        return new HashSet<>(roleRepository.findAll());
    }


    @Override
    @Transactional(readOnly = true)
    public Role findRoleById(long id) {
        return roleRepository.findById(id);
    }
}
