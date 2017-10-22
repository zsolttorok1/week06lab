<%-- 
    Document   : mainPage
    Created on : Sep 20, 2017, 4:58:07 PM
    Author     : 725899
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Home Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <sait:debug debug="${param.debug != null}">
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}
        </sait:debug>
        <h1>Home Page</h1>
        <b>Hello ${username}.</b><br/>
        <br/>
        <a href="login?action=logout">Logout</a>
    </body>
</html>
