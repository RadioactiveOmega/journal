package com.mai.journal.Services;

import com.mai.journal.Domain.Role;
import com.mai.journal.Domain.User;
import com.mai.journal.Repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;

   public boolean createUser(User user){
       String login = user.getLogin();
       if(userRepository.findByLogin(login) != null) return false;
       user.setActive(true);
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       user.getRoles().add(Role.USER);
       log.info("Saving new User {}", login);
       userRepository.save(user);
       log.info("Saved user.");
       return true;
   }
    public boolean createUser(String login, String password){
        if(userRepository.findByLogin(login) != null) return false;

        User user = new User(login, passwordEncoder.encode(password));
        user.setActive(true);
        user.getRoles().add(Role.USER);
        log.info("Saving new User {}", login);
        userRepository.save(user);
        log.info("Saved user.");
        return true;
    }
}
