package com.rs.ldapcrudoperations.repository.ldap.impl;

import com.rs.ldapcrudoperations.model.LdapUser;
import com.rs.ldapcrudoperations.repository.ldap.UserRepo;
import com.rs.ldapcrudoperations.repository.ldap.UserRepoAdditional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserRepoImpl implements UserRepoAdditional {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepo.class);

    @Autowired
    private LdapTemplate ldapTemplate;

    @Override
    public byte createLdapUser(LdapUser ldapUser) {
        byte status = 0;
        try {
            ldapTemplate.create(ldapUser);
            status = 1;
        } catch(Exception e) {
            status = 0;
            LOGGER.error("Unable to create ldap user reason: {} ", e.getMessage());
            throw e;
        }
       return status;
    }

    @Override
    public byte updateLdapUser(LdapUser ldapUser) {
        byte status = 0;
        try {
            ldapTemplate.update(ldapUser);
            status = 1;
        } catch(Exception e) {
            status = 0;
            LOGGER.error("Unable to update ldap user reason: {} ", e.getMessage());
            throw e;
        }
        return 0;
    }
}
