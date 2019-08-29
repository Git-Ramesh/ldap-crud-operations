package com.rs.ldapcrudoperations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;
import java.io.Serializable;

@Entry(objectClasses = {"organizationalPerson", "person", "inetOrgPerson", "top"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LdapUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Name dn;
    @Attribute(name = "uid")
    private String username;
    @Attribute(name = "givenName")
    private String firstName;
    @Attribute(name = "sn")
    private String lastName;
    @Attribute(name = "userPassword")
    private String password;
    @Attribute(name = "mail")
    private String mail;

}
