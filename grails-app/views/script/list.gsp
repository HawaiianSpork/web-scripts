
<%@ page import="web.scripts.Script" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'script.label', default: 'Script')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-script" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-script" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="createdBy" title="${message(code: 'script.createdBy.label', default: 'Created By')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'script.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'script.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="examples" title="${message(code: 'script.examples.label', default: 'Examples')}" />
					
						<g:sortableColumn property="isPublic" title="${message(code: 'script.isPublic.label', default: 'Is Public')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'script.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${scriptInstanceList}" status="i" var="scriptInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${scriptInstance.id}">${fieldValue(bean: scriptInstance, field: "createdBy")}</g:link></td>
					
						<td><g:formatDate date="${scriptInstance.dateCreated}" /></td>
					
						<td>${fieldValue(bean: scriptInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: scriptInstance, field: "examples")}</td>
					
						<td><g:formatBoolean boolean="${scriptInstance.isPublic}" /></td>
					
						<td><g:formatDate date="${scriptInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${scriptInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
