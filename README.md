# lb-nginx-ms
Loadbalancer-Nginx-MicroServices

# Intention
Il s’agit de réaliser un laboratoire pratique impliquant aussi bien des notions informatiques, que de mathématiques. L’informatique sera utilisée pour réaliser une implémentation et les mathématiques pour valider si l’implémentation se comporte comme attendue.

# Contexte pratique
Vous êtes responsable de déployer une infrastructure mettant en œuvre des micro-services de différentes natures.

•	Un micro-service MySql : pour assurer la persistance de données.

   * [Docker - Official MySql Image](https://hub.docker.com/_/mysql)

•	Un micro-service NGINX : pour assurer le rôle de reverse proxy et load balancer.
   * [Docker - Official Nginx Image](https://hub.docker.com/_/nginx)
     
•	4 micro-services API-Spring « identiques »: implémentant la logique métier (de votre choix)
   * [Spring API-Rest Template](https://github.com/spring-guides/tut-rest)

# Analyse à livrer et à appuyer mathématiquement
Les load balancers offrent différentes stratégies de répartition de charge. Il vous est demandé d’en implémenter 2 différentes, de mettre l’infrastructure en charge et de prouver que la répartition fonctionne bien comme demandée.

* [LB Policies](https://www.f5.com/company/blog/nginx/choosing-nginx-plus-load-balancing-techniques)

Pour valider d’un point de vue mathématiques, il vous est demandé de faire des sessions de charges et de documenter les données observées et collectées.

* [Get Docker Metrics](https://docs.docker.com/config/daemon/prometheus/)

# Contraintes
Un orchestrer type K8s pourrait très bien réaliser ce contexte aisément, mais l’idée et de vous offrir la possibilité de configurer manuellement les composants à ensuite observer.

# Livrables
Le tout doit être livré sur ce dépôt.

* Journal de travail permettant de retracer vos actions et le temps investi.
* Un rapport présentant vos observations et conclusions.
* Le code nécessaire pour déployer l'infra.
* Un défense finale (à définir):
   * Démonstration fonctionnelle de l'infra.
   * Capture de métriques.
   * Génération des graphiques.
   * Explication mathématiques des stratégies de répartitions de charges (graphiques, fonctions mathématiques utilisées).

# Critères d'évaluation

* Les livrables attendus sont tous présents et de bonnes qualités. 
* L’effort produit vaut, a minima, les heures de cours manqués. 
* L’aspect mathématique doit valoir au moins de 30%.
* Les différentes pratiques vues en classes ont été suivies (git-branches, conventional commits, issues, schéma UML nécessaires).
