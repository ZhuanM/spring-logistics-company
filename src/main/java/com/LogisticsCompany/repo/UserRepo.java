package com.LogisticsCompany.repo;

import com.LogisticsCompany.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
    Optional<AppUser> findById(Long id);
}
