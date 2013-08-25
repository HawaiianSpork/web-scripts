package web.scripts.security

import java.util.Collection

import org.springframework.security.core.userdetails.User
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.ldap.core.DirContextOperations
import org.springframework.security.core.GrantedAuthority
import org.springframework.ldap.core.DirContextAdapter

class ScriptsUserDetailsContextMapper implements UserDetailsContextMapper {
    UserDetails mapUserFromContext(DirContextOperations ctx, String username,
            Collection<GrantedAuthority> authorities) {
        ScriptsUser user =  ScriptsUser.findByUsername(username)
        if (user == null) {
            user = new ScriptsUser(username: username)
            ScriptsUser.withTransaction {
                user.save(flush: true)
            }
        }
        return user
    }

    void mapUserToContext(UserDetails user, DirContextAdapter ctx) {
        throw new IllegalStateException("Only retrieving data from LDAP is currently supported")
    }
}
