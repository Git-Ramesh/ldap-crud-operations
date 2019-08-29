package com.rs.ldapcrudoperations.controller;

import com.rs.ldapcrudoperations.model.LdapUser;
import com.rs.ldapcrudoperations.repository.ldap.UserRepo;
import com.rs.ldapcrudoperations.service.ldap.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ldap/user")
public class LdapUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<LdapUser> all() {
        return userService.getAllLdapUsers();
    }

    @GetMapping("/username/{username}")
    public LdapUser ldapUserByUsername(@PathVariable("username") String username) {
        return userService.getLdapUserByUsername(username);
    }

    @GetMapping("/lastname/{lastname}")
    public List<LdapUser> ldapUsersByLastName(@PathVariable("lastname") String lastname) {
        return userService.getLdapUsersByLastName(lastname);
    }
    @DeleteMapping("/remove/{username}")
    public String remove(@PathVariable("username") String username) {
        return userService.removeLdapUser(username);
    }
    @PutMapping("/update")
    public String update(@RequestBody LdapUser ldapUser) {
        return userService.updateLdapUser(ldapUser);
    }
    @PostMapping("/add")
    public String add(@RequestBody LdapUser ldapUser) {
        return userService.addLdapUser(ldapUser);
    }

}
