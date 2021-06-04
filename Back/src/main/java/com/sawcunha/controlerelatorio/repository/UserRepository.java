package com.sawcunha.controlerelatorio.repository;

import com.sawcunha.controlerelatorio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPasswordAndActive(String username, String password, boolean active);

}
