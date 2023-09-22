<%-- 
    Document   : login
    Created on : 17-09-2023, 17:45:32
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" method="post" action="sLogin">
            <table width="461" border="0" cellspacing="1">
                <tr>
                    <td colspan="3">LOGIN</td>
                </tr>
                <tr>
                    <td width="82">&nbsp;</td>
                    <td width="157">&nbsp;</td>
                    <td width="212">&nbsp;</td>
                </tr>
                <tr>
                    <td>Usuario:</td>
                    <td>
                        <label>
                            <input type="text" name="txtUsuario" id="txtusuario">
                        </label>    
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>
                        <label>
                            <input type="text" name="txtPassword" id="txtPassword">
                        </label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td height="48">&nbsp;</td>
                    <td align="center">
                        <label>
                            <input type="submit" name="button" id="button" value="Acceder">
                        </label>                        
                    </td>
                </tr>
            </table>
        </form>
        <h1>&nbsp;</h1>
    </body>
</html>
