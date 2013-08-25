package web.scripts.security

import org.springframework.dao.DataIntegrityViolationException

class ScriptsUserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [scriptsUserInstanceList: ScriptsUser.list(params), scriptsUserInstanceTotal: ScriptsUser.count()]
    }

    def create() {
        [scriptsUserInstance: new ScriptsUser(params)]
    }

    def save() {
        def scriptsUserInstance = new ScriptsUser(params)
        if (!scriptsUserInstance.save(flush: true)) {
            render(view: "create", model: [scriptsUserInstance: scriptsUserInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'scriptsUser.label', default: 'ScriptsUser'), scriptsUserInstance.id])
        redirect(action: "show", id: scriptsUserInstance.id)
    }

    def show(Long id) {
        def scriptsUserInstance = ScriptsUser.get(id)
        if (!scriptsUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'scriptsUser.label', default: 'ScriptsUser'), id])
            redirect(action: "list")
            return
        }

        [scriptsUserInstance: scriptsUserInstance]
    }

    def edit(Long id) {
        def scriptsUserInstance = ScriptsUser.get(id)
        if (!scriptsUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'scriptsUser.label', default: 'ScriptsUser'), id])
            redirect(action: "list")
            return
        }

        [scriptsUserInstance: scriptsUserInstance]
    }

    def update(Long id, Long version) {
        def scriptsUserInstance = ScriptsUser.get(id)
        if (!scriptsUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'scriptsUser.label', default: 'ScriptsUser'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (scriptsUserInstance.version > version) {
                scriptsUserInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'scriptsUser.label', default: 'ScriptsUser')] as Object[],
                          "Another user has updated this ScriptsUser while you were editing")
                render(view: "edit", model: [scriptsUserInstance: scriptsUserInstance])
                return
            }
        }

        scriptsUserInstance.properties = params

        if (!scriptsUserInstance.save(flush: true)) {
            render(view: "edit", model: [scriptsUserInstance: scriptsUserInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'scriptsUser.label', default: 'ScriptsUser'), scriptsUserInstance.id])
        redirect(action: "show", id: scriptsUserInstance.id)
    }

    def delete(Long id) {
        def scriptsUserInstance = ScriptsUser.get(id)
        if (!scriptsUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'scriptsUser.label', default: 'ScriptsUser'), id])
            redirect(action: "list")
            return
        }

        try {
            scriptsUserInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'scriptsUser.label', default: 'ScriptsUser'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'scriptsUser.label', default: 'ScriptsUser'), id])
            redirect(action: "show", id: id)
        }
    }
}
