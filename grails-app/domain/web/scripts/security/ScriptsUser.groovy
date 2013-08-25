package web.scripts.security

import org.springframework.security.core.userdetails.UserDetails

class ScriptsUser implements UserDetails {

	String username

	static constraints = {
		username blank: false, unique: true
	}

	static mapping = {
	}

	Set<ScriptsRole> getAuthorities() {
		ScriptsUserScriptsRole.findAllByScriptsUser(this).collect { it.scriptsRole } as Set
	}
    
    String getPassword() {
        throw new UnsupportedOperationException()
    }

    boolean isAccountNonExpired() {
        throw new UnsupportedOperationException()
    }

    boolean isAccountNonLocked() {
        throw new UnsupportedOperationException()
    }

    boolean isCredentialsNonExpired() {
        throw new UnsupportedOperationException()
    }

    boolean isEnabled() {
        throw new UnsupportedOperationException()
    }
}
