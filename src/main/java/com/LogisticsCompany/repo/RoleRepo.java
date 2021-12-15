package com.LogisticsCompany.repo;

import com.LogisticsCompany.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}
