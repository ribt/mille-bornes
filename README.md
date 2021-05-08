# 1000 bornes

Ce jeu de 1000 bornes a été créé dans le cadre de notre DUT informatique. Il fallait respecter l'architecture choisie par les professeurs. Voici les points de différence avec la Javadoc fournie :

- La classe EtatJoueur n'a plus d'attribut `joueur` car il n'était pas utilisé et cela créait un warning.
- La méthode `appliqueEffet` de la classe Bataille a été passée en `abstract` car tous ses descendants l'*overrident*.
- Une classe Application a été créée pour alléger la classe Main.



### Les bots

Un package `bot` a été créé. Il contient une classe abstraite Bot qui hérite de Joueur et trois classes correspondant à des niveaux de difficulté différents :

- BotDebile : joue complètement au hasard (et commet donc des erreurs)
- BotGentil : joue sa borne maximale ou la bonne parade s'il est bloqué
- BotMechant : joue comme BotGentil mais pose ses attaques sur le joueur avec le plus de kilomètres



Remarque : les commentaires précédents chaque méthode ont été générés depuis la Javadoc grâce à [un outil créé pour l'occasion](https://github.com/ribt/javadoc-reverse).