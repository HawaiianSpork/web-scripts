<%@ page import="web.scripts.Script" %>



<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'contributors', 'error')} ">
	<label for="contributors">
		<g:message code="script.contributors.label" default="Contributors" />
		
	</label>
	<g:select name="contributors" from="${web.scripts.security.ScriptsUser.list()}" multiple="multiple" optionKey="id" size="5" value="${scriptInstance?.contributors*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="script.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${scriptInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'examples', 'error')} ">
	<label for="examples">
		<g:message code="script.examples.label" default="Examples" />
		
	</label>
	<g:textField name="examples" value="${scriptInstance?.examples}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'isPublic', 'error')} ">
	<label for="isPublic">
		<g:message code="script.isPublic.label" default="Is Public" />
		
	</label>
	<g:checkBox name="isPublic" value="${scriptInstance?.isPublic}" />
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="script.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${scriptInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'tags', 'error')} ">
	<label for="tags">
		<g:message code="script.tags.label" default="Tags" />
		
	</label>
	<g:select name="tags" from="${web.scripts.Tag.list()}" multiple="multiple" optionKey="id" size="5" value="${scriptInstance?.tags*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'usage', 'error')} ">
	<label for="usage">
		<g:message code="script.usage.label" default="Usage" />
		
	</label>
	<g:textField name="usage" value="${scriptInstance?.usage}"/>
</div>

