package com.LogisticsCompany.repo;

import com.LogisticsCompany.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
    Optional<AppUser> findById(Long id);

    @Query("SELECT u FROM AppUser u WHERE u.role = 'COURIER' OR u.role = 'ADMIN'")
    List<AppUser> getAllEmployees();

    @Query("SELECT u FROM AppUser u WHERE u.role = 'USER'")
    List<AppUser> getAllCustomers();
}
