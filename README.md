# 1000 bornes

Ce jeu de 1000 bornes a été créé dans le cadre de notre DUT informatique. Il fallait respecter l'architecture choisie par les professeurs. Voici les points de différence avec la Javadoc fournie :

- La méthode `appliqueEffet` de la classe Bataille a été passée en `abstract` car tous ses descendants l'*overrident*.
- La méthode `choisitAdversaire` prend toujours une attaque en argument alors le type du paramètre a été changé par `Attaque` (au lieu de `Bataille`). 
- Une classe Application a été créée pour alléger la classe Main.
- `choisitCoupFoure` a été ajouté dans Joueur et EtatJoueur, il est appelé par Attaque.appliqueEffet si le joueur a la bonne botte dans la main.

Remarque : les commentaires précédant chaque méthode ont été générés depuis la Javadoc grâce à [un outil créé pour l'occasion](https://github.com/ribt/javadoc-reverse).

## Les bots

Un package `bot` a été créé. Il contient une classe abstraite Bot qui hérite de Joueur et trois classes correspondant à des niveaux de difficulté différents :

- BotDebile : joue complètement au hasard (et commet donc des erreurs)
- BotGentil : joue sa borne maximale ou la bonne parade s'il est bloqué
- BotMechant : joue comme BotGentil mais pose ses attaques sur le joueur avec le plus de kilomètres

## Utilisation

Compilez la classe Main du package mille_bornes ou exécutez le `.jar`. Le jeu se joue dans un terminal. Au début de la partie, le programme demande le nombre de joueurs et leurs noms, le nombre de bots et leurs niveaux. (Il est possible de choisir de ne faire jouer que des bots.)
