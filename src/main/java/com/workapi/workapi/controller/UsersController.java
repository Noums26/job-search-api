package com.workapi.workapi.controller;

import com.workapi.workapi.model.Offers;
import com.workapi.workapi.model.Users;
import com.workapi.workapi.repository.UsersRepository;
import com.workapi.workapi.service.CandidacyService;
import com.workapi.workapi.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService;
    private CandidacyService candidacyService;

    @GetMapping("")
    public List<Users> getAll(){
        return usersService.getAll();
    }

    @GetMapping("/{users_id}")
    public Users getById(@PathVariable Long users_id){
        return usersService.getById(users_id);
    }

    @GetMapping("/profile")
    public Users findUserByUserName(@RequestParam String username){
        return usersService.findByUserName(username);
    }

    @GetMapping("/enterprises")
    public List<Users> getAllEnterprise(){
        return usersService.getByRole("enterprise");
    }

    @PutMapping("")
    public Users updateUser(@RequestBody Users user){
        return usersService.updateUser(user);
    }

    @PostMapping("")
    public Users signUp(@RequestBody Users users){
        return usersService.createUser(users);
    }

    @GetMapping("/{user_id}/candidacies")
    public List<Offers> getAllCandidacies(@PathVariable Long user_id){
        return candidacyService.getOffersForACandidate(user_id);
    }

    @GetMapping("/login")
    public Users mockLogin(@RequestParam String username,@RequestParam String password){
        return usersService.mockLogin(username, password);
    }

}
