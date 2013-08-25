<%@ page import="web.scripts.security.ScriptsUser" %>



<div class="fieldcontain ${hasErrors(bean: scriptsUserInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="scriptsUser.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${scriptsUserInstance?.username}"/>
</div>

