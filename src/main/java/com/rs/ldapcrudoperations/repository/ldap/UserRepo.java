package com.rs.ldapcrudoperations.repository.ldap;

import com.rs.ldapcrudoperations.model.LdapUser;
import org.springframework.data.ldap.repository.LdapRepository;

public interface UserRepo extends LdapRepository<LdapUser>, UserRepoAdditional {
}
