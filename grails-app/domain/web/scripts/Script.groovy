package web.scripts

import web.scripts.security.ScriptsUser

class Script {
    def springSecurityService
    
    String name
    Date dateCreated
    Date lastUpdated
    ScriptsUser createdBy
    ScriptsUser lastUpdatedBy
    String usage
    String description
    String examples
    boolean isPublic
    
    static hasMany = [tags: Tag, contributors: ScriptsUser, users: ScriptsUser]
    
    static constraints = {
        createdBy nullable: true
        lastUpdatedBy nullable: true
        users nullable: true
        contributors nullable: true
        tags nullable: true
    }
    
    def beforeInsert() {
        def createUser = springSecurityService?.authentication?.name
        createdBy = ScriptsUser.findByUsername(createUser)
        lastUpdatedBy = createdBy
    }

    def beforeUpdate() {
        def updateUser = springSecurityService?.authentication?.name
        lastUpdatedBy = ScriptsUser.findByUsername(updateUser)
    }

    static mapping = {
        version false
        id generator: 'sequence', params: [sequence: "script_seq"]
        createdBy joinTable: [name: 'script_created_by', key: 'script_id']
        lastUpdatedBy joinTable: [name: 'script_updated_by', key: 'script_id']
        tags joinTable: [name: 'script_tag', key: 'script_id']
        contributors joinTable: [name: 'script_contributor', key: 'script_id']
        users joinTable: [name: 'script_user', key: 'script_id']
    }
}
