package com.niit.UserAuthentication.repository;

import com.niit.UserAuthentication.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    Admin findAdminByEmailAndPassword(String email, String password);

}
