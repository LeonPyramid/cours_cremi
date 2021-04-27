Dans cette archive se trouve la réponse à la question pour l'opérateur ternaire et pour l'enum.
L'opérateur ternaire fonctionne correctement.
Pour l'enum 'ai mis en place une MapEnvironment qui contient l'ensemble des TypeName présent dans les enums.
Elle me permet de vérifier dans la partie assignedVariable les enums existants (de base je voulais faire une autre expression dans la partie stm mais il y avait conflit de réduction).
Le souci est que du coup tout les noms existants sont globaux. Ca n'est pas un vrai problème car par la suite les noms sont testés pour voir s'ils appartiennent bien à l'enum en question, mais il n'y aura pas la bonne erreur, on aura une "(element) is ont an element of (enum)" au lieu de "unknown variable(element)".
J'ai fait un input-1-perso.lea qui contient les tests effectués pour les enum.