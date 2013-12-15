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
        <title>Descriptif produit Cycles</title>

        <link rel="stylesheet" title="style1" type="text/css" href="css/BaseC.css" >
        <link rel="stylesheet" title="style1" type="text/css" href="css/ProduitC.css" >
        <link rel="stylesheet" title="style1" type="text/css" href="css/bootstrap/css/bootstrap.min.css">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Nicob">
        <meta name="description" content="Descriptif produit cycles">
    </head>

    <body>
        <div class="page">
            <div class='bandeau'>
                <div class="logo">
                    <a href="AccueilC">
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
                            <li> <a href='AchatsC'>Achats en ligne</a> </li>
                            <li> <a href='MenuLocationC'>Location</a></li>
                            <li> <a href='FideliteC'>Carte de fidélité</a> </li>
                            <li> <a href='SAVC'>SAV</a> </li>
                            <li> <a href='ServicesC'>Services</a> </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="contenu">
                <div class="espace">
                    <div class="cycles">
                        <p class="espace"> Espace cycles</p>
                    </div>
                    <div class="glisse">
                        <a class="espace" href="AccueilG"> Espace glisse</a>
                    </div>
                </div>




                <div class="produit">
                    <div class="image">
                        <img class="produit" src="css/Images/velo.jpg" alt="Produit">
                    </div>
                    <div class="infos">
                        <div class="description">
                            <div class="prix">
                                20,00€
                            </div>
                            <div class="info">
                                <p>Grand velo<br>
                                    aluminium</p>
                            </div>
                            <div class="taille">
                                <select> 
                                    <option>Mercure</option> 
                                    <option>Vénus</option> 
                                    <option selected="selected">Terre</option> 
                                    <option>Mars</option> 
                                    <option>Jupiter</option> 
                                    <option>Saturne</option> 
                                    <option>Uranus</option> 
                                    <option>Neptune</option> 
                                    <option>Pluton</option> 
                                </select> 
                            </div>
                        </div>

                        <div class="commentaires" display="hidden">
                            <p class="commentaire">Super produit !</p>
                            <p class="commentaire">Pas convaincu...</p>
                            <p class="commentaire">Good</p>
                        </div> 

                        <div class="boutons">
                            <a class="btn btn-danger btn-lg" role="button" href="AchatsC">Retour au catalogue</a>
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

