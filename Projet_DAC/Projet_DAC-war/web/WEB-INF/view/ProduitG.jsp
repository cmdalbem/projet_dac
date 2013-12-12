<%-- 
    Document   : ServicesG
    Created on : 11 déc. 2013, 10:35:36
    Author     : Nicob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Descriptif produit Glisse</title>

        <link rel="stylesheet" title="style1" type="text/css" href="css/BaseG.css" >
        <link rel="stylesheet" title="style1" type="text/css" href="css/ProduitG.css" >
        <link rel="stylesheet" title="style1" type="text/css" href="css/bootstrap/css/bootstrap.min.css">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Nicob">
        <meta name="description" content="Descriptif produit glisse">
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
                        <a class="btn btn-warning btn-lg" role="button" href="Connexion">Connexion</a>
                    </div>
                    <div class='menu'>
                        <ul class='nav nav-pills'>
                            <li> <a href='AchatsG'>Achats en ligne</a> </li>
                            <li> <a href='LocationG'>Location</a></li>
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
                        <a class="espace" href="AccueilC"> Espace cycles</a>
                    </div>
                    <div class="glisse">
                        <p class="espace"> Espace glisse</p>
                    </div>
                </div>

                <div class="produit">
                    <div class="image">
                        <img class="produit" src="css/Images/skis.jpg" alt="Produit">
                    </div>
                    <div class="infos">
                        <div class="description">
                            <div class="prix">
                                20,00€
                            </div>
                            <div class="info">
                                <p>Skis 1m50<br>
                                    Bois</p>
                            </div>
                        </div>

                        <div class="commentaires" display="hidden">
                            <p class="commentaire">Super produit !</p>
                            <p class="commentaire">Pas convaincu...</p>
                            <p class="commentaire">Good</p>
                        </div> 

                        <div class="boutons">
                            <a class="btn btn-danger btn-lg" role="button" href="AchatsG">Retour au catalogue</a>
                            <a class="btn btn-primary btn-lg" role="button" href="Panier">Ajouter au panier</a>
                        </div>
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

