package web.scripts



import org.junit.*
import grails.test.mixin.*

@TestFor(ScriptController)
@Mock(Script)
class ScriptControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/script/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.scriptInstanceList.size() == 0
        assert model.scriptInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.scriptInstance != null
    }

    void testSave() {
        controller.save()

        assert model.scriptInstance != null
        assert view == '/script/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/script/show/1'
        assert controller.flash.message != null
        assert Script.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/script/list'

        populateValidParams(params)
        def script = new Script(params)

        assert script.save() != null

        params.id = script.id

        def model = controller.show()

        assert model.scriptInstance == script
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/script/list'

        populateValidParams(params)
        def script = new Script(params)

        assert script.save() != null

        params.id = script.id

        def model = controller.edit()

        assert model.scriptInstance == script
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/script/list'

        response.reset()

        populateValidParams(params)
        def script = new Script(params)

        assert script.save() != null

        // test invalid parameters in update
        params.id = script.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/script/edit"
        assert model.scriptInstance != null

        script.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/script/show/$script.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        script.clearErrors()

        populateValidParams(params)
        params.id = script.id
        params.version = -1
        controller.update()

        assert view == "/script/edit"
        assert model.scriptInstance != null
        assert model.scriptInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/script/list'

        response.reset()

        populateValidParams(params)
        def script = new Script(params)

        assert script.save() != null
        assert Script.count() == 1

        params.id = script.id

        controller.delete()

        assert Script.count() == 0
        assert Script.get(script.id) == null
        assert response.redirectedUrl == '/script/list'
    }
}
