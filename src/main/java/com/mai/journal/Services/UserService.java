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
       user.setHash(passwordEncoder.encode(user.getHash()));
       user.getRoles().add(Role.USER);
       log.info("Saving new User {}", login);
       return true;
   }
}
