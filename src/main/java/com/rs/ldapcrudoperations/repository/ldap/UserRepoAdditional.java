package com.rs.ldapcrudoperations.repository.ldap;

import com.rs.ldapcrudoperations.model.LdapUser;

public interface UserRepoAdditional {
    byte createLdapUser(LdapUser ldapUser);
    byte updateLdapUser(LdapUser ldapUser);
}
