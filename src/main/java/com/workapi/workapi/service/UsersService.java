package com.workapi.workapi.service;

import com.workapi.workapi.model.Users;
import com.workapi.workapi.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService {
    UsersRepository usersRepository;

    @Transactional
    public Users createUser(Users users){
        // users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));
        return usersRepository.save(users);
    }

    public Users updateUser(Users user){
        return usersRepository.save(user);
    }

    public List<Users> getAll(){
        return usersRepository.findAll();
    }

    public List<Users> getByRole(String role){
        return usersRepository.findUsersByRoleIgnoreCase(role);
    }

    public Users getById(Long id){
        return usersRepository.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = usersRepository.findUsersByUserNameIsLikeIgnoreCase(userName);
        UserDetailsPrincipal userDetailsPrincipal = new UserDetailsPrincipal(user);
        return userDetailsPrincipal;
    }
    public Users findByUserName (String username){
        return usersRepository.findUsersByUserNameIsLikeIgnoreCase(username);
    }

    public Users mockLogin(String username, String password){
        return usersRepository.findUsersByUserNameIsLikeIgnoreCaseAndPasswordIsLike(username, password);
    }
}
