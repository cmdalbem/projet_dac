<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Connexion</title>

        <link rel="stylesheet" title="style1" type="text/css" href="css/BaseG.css" >
        <link rel="stylesheet" title="style1" type="text/css" href="css/Connexion.css" >
        <link rel="stylesheet" title="style1" type="text/css" href="css/bootstrap/css/bootstrap.min.css">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Nicob">
        <meta name="description" content="Connexion">
    </head>

    <body>
        <div class="page">
            <div class='bandeau'>
                <div class="logo">
                    <a href="AccueilG">
                        <img src="css/Images/logo.jpg" class='imglogo'>
                    </a>
                </div>
                <div class="boitemenu">
                    <div class="connexion">
                        <a class="btn btn-warning btn-lg" role="button">Panier</a>
                        <a class="btn btn-warning btn-lg" role="button">Connexion</a>
                    </div>
                    <div class='menu'>
                        <ul class='nav nav-pills'>
                            <li> <a href='AchatsG'>Achats en ligne</a> </li>
                            <li> <a href='MenuLocationG'>Location</a></li>
                            <li> <a href='FideliteG'>Carte de fidélité</a> </li>
                            <li> <a href='SAVG'>SAV</a> </li>
                            <li> <a href='ServicesG'>Services</a> </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="contenu">
                <div class="espace">
                    <div class="cycles">
                        <a class="espace" href="#"> Espace cycles</a>
                    </div>
                    <div class="glisse">
                        <p class="espace"> Espace glisse</p>
                    </div>
                </div>

                <div class="identification">
                    <div class="conditions">
                        <p> <h1 class="titre">Utilisation de nos services</h1>						
                        Les services sont fournis par Glisse&AMP;Cycles. 
                        L'utilisation de nos Services implique votre acceptation des présentes Conditions d'Utilisation. 
                        N'utilisez pas nos Services de façon impropre. Ne tentez pas, par exemple, de produire des interférences avec nos Services ou d'y accéder en utilisant une méthode autre que l'interface et les instructions que nous mettons à votre disposition. 
                        Vous ne devez utiliser nos Services que dans le respect des lois en vigueur, y compris les lois et réglementations applicables concernant le contrôle des exportations et ré-exportations. 
                        Nous pouvons suspendre ou cesser la fourniture de nos Services si vous ne respectez pas les conditions ou réglements applicables, ou si nous examinons une suspicion d'utilisation impropre.
                        </p>
                        <p> <h1 class="titre">Protection de la vie privée et des droits d'auteur</h1>
                        Glisse&AMP;Cycles garantit la confidentialité des informations personnelles.
                        En utilisant nos Services, vous acceptez que Glisse&AMP;Cycles puisse utiliser ces données.</p>
                    </div>
                    <div class="login">
                        <form class="form-signin">
                            <h1 class="titre">Saisissez vos identifiants</h1>
                            <div class="champs">
                                <input type="text" class="form-control" placeholder="Courriel" required="" autofocus="">
                                <input type="password" class="form-control" placeholder="Mot de passe" required="">
                                <button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
                            </div>
                        </form>
                    </div>
                </div>			


                <div class="promo">
                    <p>Articles les plus populaires</p>
                    <div class="article">
                        <a href="ProduitG"><img class="article" src="css/Images/skis.jpg" alt="Article populaire 1"> </a>
                    </div>
                    <div class="article">
                        <a href="ProduitG"><img class="article" src="css/Images/skis.jpg" alt="Article populaire 2"> </a>
                    </div>
                    <div class="article">
                        <a href="ProduitG"><img class="article" src="css/Images/skis.jpg" alt="Article populaire 3"> </a>
                    </div>
                </div>
            </div>

            <div class="footer">
                <p class="footer">Glisse&amp;Cycles France</p>
                <p class="footer">Contactez-nous</p>
            </div>

        </div>
    </body>
