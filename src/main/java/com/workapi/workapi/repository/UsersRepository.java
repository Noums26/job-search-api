package com.workapi.workapi.repository;

import com.workapi.workapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findUsersByRoleIgnoreCase(String role);

    Users findUsersByUserNameIsLikeIgnoreCase(String username);

    Users findUsersByUserNameIsLikeIgnoreCaseAndPasswordIsLike(String username, String password);
}
