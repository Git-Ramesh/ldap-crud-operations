package com.rs.ldapcrudoperations.service.ldap.impl;

import com.rs.ldapcrudoperations.model.LdapUser;
import com.rs.ldapcrudoperations.repository.ldap.UserRepo;
import com.rs.ldapcrudoperations.service.ldap.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public String addLdapUser(LdapUser ldapUser) {
       return (userRepo.createLdapUser(ldapUser) > 0) ? "User has been added." : "Failed to add the user.";
    }

    @Override
    public String removeLdapUser(String username) {
        String status = "Unable to remove the user " + username;
        Optional<LdapUser> ldapUser = userRepo.findOne(LdapQueryBuilder.query().where("uid").is(username));
        ldapUser.ifPresent(user -> userRepo.delete(user));
        return ldapUser.isPresent() ? "User has been removed." : status;
    }

    @Override
    public String updateLdapUser(LdapUser ldapUser) {
        byte status = 0;
        status = userRepo.updateLdapUser(ldapUser);
        return (status > 0) ? "User has been updated." : "Unable to update ldap user";
    }

    @Override
    public List<LdapUser> getAllLdapUsers() {
        return (List<LdapUser>) userRepo.findAll();
    }

    @Override
    public LdapUser getLdapUserByUsername(String username) {
        Optional<LdapUser> userOptional = userRepo.findOne(LdapQueryBuilder.query().where("uid").is(username));
        return (userOptional.isPresent()) ? userOptional.get() : null;
    }

    @Override
    public List<LdapUser> getLdapUsersByLastName(String lastname) {
       return (List<LdapUser>) userRepo.findAll(LdapQueryBuilder.query().where("sn").is(lastname));
    }

}
