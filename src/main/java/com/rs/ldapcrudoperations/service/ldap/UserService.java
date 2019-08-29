package com.rs.ldapcrudoperations.service.ldap;

import com.rs.ldapcrudoperations.model.LdapUser;

import java.util.List;

public interface UserService {
    String addLdapUser(LdapUser ldapUser);
    String removeLdapUser(String username);
    String updateLdapUser(LdapUser ldapUser);
    List<LdapUser> getAllLdapUsers();
    LdapUser getLdapUserByUsername(String username);
    List<LdapUser> getLdapUsersByLastName(String lastname);
}
