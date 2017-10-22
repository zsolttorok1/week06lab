<%-- 
    Document   : 404
    Created on : Sep 20, 2017, 9:14:40 PM
    Author     : 725899
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404 page</title>
    </head>
    <body>
        <sait:debug debug="${param.debug != null}">
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}
        </sait:debug>
        <h1>404 - page not found!</h1>
    </body>
</html>
