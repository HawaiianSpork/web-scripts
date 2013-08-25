package web.scripts.security

import org.apache.commons.lang.builder.HashCodeBuilder

class ScriptsUserScriptsRole implements Serializable {

	ScriptsUser scriptsUser
	ScriptsRole scriptsRole

	boolean equals(other) {
		if (!(other instanceof ScriptsUserScriptsRole)) {
			return false
		}

		other.scriptsUser?.id == scriptsUser?.id &&
			other.scriptsRole?.id == scriptsRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (scriptsUser) builder.append(scriptsUser.id)
		if (scriptsRole) builder.append(scriptsRole.id)
		builder.toHashCode()
	}

	static ScriptsUserScriptsRole get(long scriptsUserId, long scriptsRoleId) {
		find 'from ScriptsUserScriptsRole where scriptsUser.id=:scriptsUserId and scriptsRole.id=:scriptsRoleId',
			[scriptsUserId: scriptsUserId, scriptsRoleId: scriptsRoleId]
	}

	static ScriptsUserScriptsRole create(ScriptsUser scriptsUser, ScriptsRole scriptsRole, boolean flush = false) {
		new ScriptsUserScriptsRole(scriptsUser: scriptsUser, scriptsRole: scriptsRole).save(flush: flush, insert: true)
	}

	static boolean remove(ScriptsUser scriptsUser, ScriptsRole scriptsRole, boolean flush = false) {
		ScriptsUserScriptsRole instance = ScriptsUserScriptsRole.findByScriptsUserAndScriptsRole(scriptsUser, scriptsRole)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(ScriptsUser scriptsUser) {
		executeUpdate 'DELETE FROM ScriptsUserScriptsRole WHERE scriptsUser=:scriptsUser', [scriptsUser: scriptsUser]
	}

	static void removeAll(ScriptsRole scriptsRole) {
		executeUpdate 'DELETE FROM ScriptsUserScriptsRole WHERE scriptsRole=:scriptsRole', [scriptsRole: scriptsRole]
	}

	static mapping = {
		id composite: ['scriptsRole', 'scriptsUser']
		version false
	}
}
