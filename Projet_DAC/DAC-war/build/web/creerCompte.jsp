<%-- 
    Document   : creerCompte
    Created on : 15 déc. 2013, 20:24:04
    Author     : DARK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="creerClient" method="POST">
             <label> Nom:</label>
            <input type="text" name="nom">
            <br/>
            <label> Prénom:</label>
            <input type="text" name="prenom">
            <br/>
            <label> Adresse:</label>
            <input type="text" name="adresse">
            <br/>
            <label> Telephone:</label>
            <input type="tel" name="telephone">
            <br/>
            <label> mail:</label>
            <input type="email" name="mail">
            <br/>
            <label> MDP:</label>
            <input type="password" name="mdp">
            <br/>
            <label> Date de naissance:</label>
            <input type="date" name="dateNaissance">
            <br/>
             <input type="submit" value="Submit">
        </form>
    </body>
</html>
