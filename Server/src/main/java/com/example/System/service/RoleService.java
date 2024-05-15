package com.example.System.service;

import com.example.System.entity.Role;
import com.example.System.exception.UserNotFoundException;
import com.example.System.model.ModelRole;
import com.example.System.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){this.roleRepository = roleRepository;}

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public List<ModelRole> findAllRole(){
        return roleRepository.findAll().stream().map(ModelRole::toModel).collect(Collectors.toList());
    }

    public ModelRole getOneRole(Long id) throws UserNotFoundException {
        Role role = roleRepository.findById(id);
        if (role == null) {
            throw new UserNotFoundException("Роль не найдена.");
        }
        return ModelRole.toModel(role);
    }

    public Role updateRole(Role role) { return roleRepository.update(role); }

    public Long deleteRole(Long id) {
        roleRepository.deleteById(id);
        return id;
    }
}
