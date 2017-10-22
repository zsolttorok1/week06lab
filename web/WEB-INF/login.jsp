<%-- 
    Document   : login
    Created on : Sep 20, 2017, 3:43:43 PM
    Author     : 725899
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <sait:debug debug="${param.debug != null}">
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}
        </sait:debug>
        <ct:login username="${username}" password="${password}" checked="${checked}" message="${message}"/>
    </body>
</html>