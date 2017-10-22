<%-- 
    Document   : login
    Created on : Oct 21, 2017, 3:09:33 PM
    Author     : 725899
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="username"%>
<%@attribute name="password"%>
<%@attribute name="checked"%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
    <h1>Remember Me Login Page</h1>
    <form action='login' method='POST'>
    Enter username: <input type='text' name='username' value='${username}'></br>
    Enter password: <input type='password' name='password' value='${password}'></br>
    <input type='submit' value='Login'></br>
    <input type="checkbox" name="remember" value="true" ${checked}> Remember me<br>
    </form>

    ${message}