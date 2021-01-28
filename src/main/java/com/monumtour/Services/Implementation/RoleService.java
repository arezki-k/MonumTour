package com.monumtour.Services.Implementation;

import com.monumtour.Model.Role;
import com.monumtour.Repository.RoleRepository;
import com.monumtour.Services.Interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
