package com.mai.journal.Repos;

import com.mai.journal.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
