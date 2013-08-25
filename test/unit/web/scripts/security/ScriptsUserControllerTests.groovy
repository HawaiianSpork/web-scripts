package web.scripts.security



import org.junit.*
import grails.test.mixin.*

@TestFor(ScriptsUserController)
@Mock(ScriptsUser)
class ScriptsUserControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/scriptsUser/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.scriptsUserInstanceList.size() == 0
        assert model.scriptsUserInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.scriptsUserInstance != null
    }

    void testSave() {
        controller.save()

        assert model.scriptsUserInstance != null
        assert view == '/scriptsUser/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/scriptsUser/show/1'
        assert controller.flash.message != null
        assert ScriptsUser.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/scriptsUser/list'

        populateValidParams(params)
        def scriptsUser = new ScriptsUser(params)

        assert scriptsUser.save() != null

        params.id = scriptsUser.id

        def model = controller.show()

        assert model.scriptsUserInstance == scriptsUser
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/scriptsUser/list'

        populateValidParams(params)
        def scriptsUser = new ScriptsUser(params)

        assert scriptsUser.save() != null

        params.id = scriptsUser.id

        def model = controller.edit()

        assert model.scriptsUserInstance == scriptsUser
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/scriptsUser/list'

        response.reset()

        populateValidParams(params)
        def scriptsUser = new ScriptsUser(params)

        assert scriptsUser.save() != null

        // test invalid parameters in update
        params.id = scriptsUser.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/scriptsUser/edit"
        assert model.scriptsUserInstance != null

        scriptsUser.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/scriptsUser/show/$scriptsUser.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        scriptsUser.clearErrors()

        populateValidParams(params)
        params.id = scriptsUser.id
        params.version = -1
        controller.update()

        assert view == "/scriptsUser/edit"
        assert model.scriptsUserInstance != null
        assert model.scriptsUserInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/scriptsUser/list'

        response.reset()

        populateValidParams(params)
        def scriptsUser = new ScriptsUser(params)

        assert scriptsUser.save() != null
        assert ScriptsUser.count() == 1

        params.id = scriptsUser.id

        controller.delete()

        assert ScriptsUser.count() == 0
        assert ScriptsUser.get(scriptsUser.id) == null
        assert response.redirectedUrl == '/scriptsUser/list'
    }
}
