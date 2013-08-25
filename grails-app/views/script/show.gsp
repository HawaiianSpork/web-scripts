
<%@ page import="web.scripts.Script" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'script.label', default: 'Script')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-script" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-script" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list script">
			
				<g:if test="${scriptInstance?.contributors}">
				<li class="fieldcontain">
					<span id="contributors-label" class="property-label"><g:message code="script.contributors.label" default="Contributors" /></span>
					
						<g:each in="${scriptInstance.contributors}" var="c">
						<span class="property-value" aria-labelledby="contributors-label"><g:link controller="scriptsUser" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.createdBy}">
				<li class="fieldcontain">
					<span id="createdBy-label" class="property-label"><g:message code="script.createdBy.label" default="Created By" /></span>
					
						<span class="property-value" aria-labelledby="createdBy-label"><g:fieldValue bean="${scriptInstance}" field="createdBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="script.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${scriptInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="script.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${scriptInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.examples}">
				<li class="fieldcontain">
					<span id="examples-label" class="property-label"><g:message code="script.examples.label" default="Examples" /></span>
					
						<span class="property-value" aria-labelledby="examples-label"><g:fieldValue bean="${scriptInstance}" field="examples"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.isPublic}">
				<li class="fieldcontain">
					<span id="isPublic-label" class="property-label"><g:message code="script.isPublic.label" default="Is Public" /></span>
					
						<span class="property-value" aria-labelledby="isPublic-label"><g:formatBoolean boolean="${scriptInstance?.isPublic}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="script.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${scriptInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.lastUpdatedBy}">
				<li class="fieldcontain">
					<span id="lastUpdatedBy-label" class="property-label"><g:message code="script.lastUpdatedBy.label" default="Last Updated By" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdatedBy-label"><g:fieldValue bean="${scriptInstance}" field="lastUpdatedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="script.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${scriptInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.tags}">
				<li class="fieldcontain">
					<span id="tags-label" class="property-label"><g:message code="script.tags.label" default="Tags" /></span>
					
						<g:each in="${scriptInstance.tags}" var="t">
						<span class="property-value" aria-labelledby="tags-label"><g:link controller="tag" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.usage}">
				<li class="fieldcontain">
					<span id="usage-label" class="property-label"><g:message code="script.usage.label" default="Usage" /></span>
					
						<span class="property-value" aria-labelledby="usage-label"><g:fieldValue bean="${scriptInstance}" field="usage"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.users}">
				<li class="fieldcontain">
					<span id="users-label" class="property-label"><g:message code="script.users.label" default="Users" /></span>
					
						<g:each in="${scriptInstance.users}" var="u">
						<span class="property-value" aria-labelledby="users-label"><g:link controller="scriptsUser" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${scriptInstance?.id}" />
					<g:link class="edit" action="edit" id="${scriptInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
