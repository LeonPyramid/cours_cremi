(* Raccourcis clavier de coqide *)
(* CTRL-flèche bas: avancer d'une commande *)
(* CTRL-flèche haut: revenir en arrière d'une commande *)
(* CTRL-flèche droit: avancer ou revenir en arrière jusqu'au curseur *) 

(** premiers pas en Coq *)

(* Logique minimale "pure": pas de négation/contradiction *)

Section Declarations.

  Variables P Q R S T : Prop.

  (* Une Section peut contenir d'autres [sous-]Sections. C'est le bon endroit
     pour definir des hypotheses (et donc prouver des sequents avec hypotheses).

     Dans ce fichier, la section "Declarations" va jusqu'au bout *)
  
  Lemma imp_dist: (P -> Q -> R) -> (P -> Q) -> P -> R.
  Proof.
    intro H.
    intro H0.
    intro H1.
    apply H.
    - assumption.
    - apply H0.
      assumption.
  Qed.

  (* Explication des tactiques utilisées: *)
  (* intro: utilisation de la regle d'introduction pour changer de but *)
  (* apply: utilisation d'une implication qui a la bonne conclusion
     (il va falloir prouver ses hypotheses) *)
  (* Note: on ne peut faire "apply" que sur une propriété déjà prouvée,
     contrairement au modus ponens des preuves en arbres *)
  (* assumption: utilisation de la regle d'hypothese *)

  Check imp_dist.  (* On voit la formule prouvée *)
  Print imp_dist.  (* Pour voir le "terme de preuve" calculé *)

  (* exemple de preuve d'un sequent avec hypothèses *)

  Section S1.
    Hypothesis H : P -> Q.
    Hypothesis H0 : P -> Q -> R.

    Lemma L2 : P -> R.
    (* le sequent est: P->Q, P->Q->R |- P->R *)
    Proof.
      intro p.
      apply H0.
      + assumption.
      + apply H.
        assumption.
    Qed.

    Check L2. (* Les hypothèse font partie de la section *)
  End S1.

  (* Quand on ferme la section, ses hypotheses sont "exportees" sous la
     forme d'hypotheses supplementaires pour L2                         *)
  Check L2.

  
  Section About_cuts.
    Hypothesis H : P -> Q.
    Hypothesis H0 : P -> Q -> R.
    Hypothesis H1 : Q -> R -> S.
    Hypothesis H2 : Q -> R -> S -> T.

    (* preuve sans lemme (coupure) *)
    Lemma L3 : P -> T.
    (* Quel est le séquent qu'on s'apprête à prouver? *)

    (* Faites-en une preuve papier AVANT de continuer *)
    Proof.
      intro p.
      apply H2.
      apply H.
      assumption.
      apply H0.
      assumption.
      apply H.
      assumption.
      apply H1.
      apply H; assumption.
      apply H0.
      assumption.
      apply H;assumption.
    Qed.
    (* Réécrivez le script ci-dessus en introduisant des tirets 
       (-, *, +) à chaque fois qu'une tactique engendre plus d'un 
       sous-but *)
Lemma L''3 : P -> T.
    (* Quel est le séquent qu'on s'apprête à prouver? *)

    (* Faites-en une preuve papier AVANT de continuer *)
    Proof.
      intro p.
      apply H2.
      - apply H.
        assumption.
      - apply H0.
        assumption.
        apply H.
        assumption.
      - apply H1.
        + apply H; assumption.
        + apply H0.
          assumption.
          apply H;assumption.
    Qed.
    (* preuve avec coupures: on prouve Q et R une seule fois chacun,
       puis on les utilise *)

     Lemma L'3 : P -> T.
     Proof.
       intro p.
       assert (q: Q). { 
         apply H; assumption.
         }   
       assert (r: R). {
         apply H0.
         - assumption.
         - assumption.
          }
       assert (s : S). {
        apply H1; assumption.
       }
       apply H2; assumption.
     Qed.

     (* assert: permet d'ouvrir une nouvelle sous-preuve, *)
     (* dans laquelle on se définit un nouveau but; c'est *)
     (* une coupure. Les accolades sont optionnelles mais *)
     (* facilitent la lecture humaine                     *)
     
     Check L'3.

(* remarquez la différence entre les termes de preuves avec coupure et sans coupure. *)
     Print L'3.
     Print L3.

  End About_cuts.


 (* Exercices 

    Reprendre les exemples vus en TD, en utilisant les tactiques 
    assumption, apply, assert et intro/intros.

    Remplacer chaque commande Admitted par un script correct de preuve,
    suivi de la commande Qed.

  *)

  Lemma IdP : P -> P.
  Proof.
  intro p.
  assumption.
  Qed.

  Lemma IdPP : (P -> P) -> P -> P.
  Proof.
  intro p.
  assumption.
  Qed.

  (* sans regarder le fichier de demo, c'est de la triche *)
  Lemma imp_trans : (P -> Q) -> (Q -> R) -> P -> R.
  Proof.
  intros H H0 p.
  apply H0.
  apply H.
  assumption.
  Qed.

  Section proof_of_hyp_switch.
    Hypothesis H : P -> Q -> R.
    Lemma hyp_switch : Q -> P -> R.
    Proof.
    intros q p.
    apply H; assumption.
    Qed.

  End proof_of_hyp_switch.

  Check hyp_switch.
  Print hyp_switch.

  Section proof_of_add_hypothesis.
    Hypothesis H : P -> R.

    Lemma add_hypothesis : P -> Q -> R.
    Proof.
    intros p q.
    apply H; assumption.
    Qed.

  End proof_of_add_hypothesis.

  (* prouver le sequent (P -> P -> Q) |- P -> Q  
     (il faut l'énoncer, et faire la preuve) 
      *)
  Section proof_of_remove_dup_hypothesis.
    Hypothesis H : P -> P -> Q.

    Lemma remove_dup_hypothesis : P -> Q.
    Proof.
    intro p.
    apply H; assumption.
    Qed.

  End proof_of_remove_dup_hypothesis.

  (* même exercice avec le séquent P->Q |- P->P->Q *)
  Section proof_of_dup_hypothesis.
    Hypothesis H : P -> Q.

    Lemma dup_hypothesis : P -> P -> Q.
    Proof.
    intros p.
    assumption.
    Qed.


  End proof_of_dup_hypothesis.

  (* meme exercice avec 
     P -> Q , P -> R , Q -> R -> T |- P -> T  
   *)
  Section proof_of_distrib_impl.
    Hypothesis H : P -> Q.
    Hypothesis H0 : P -> R.
    Hypothesis H1 : Q -> R -> T.

    Lemma distrib_impl : P -> T.

    Proof.
    intro p.
    apply H1.
      - apply H;assumption.
      - apply H0;assumption.
    Qed.
  End proof_of_distrib_impl.

  (* même exercice, avec 
     P->Q, Q->R, (P->R)->T->Q, (P->R)->T |- Q   
     (ex. 9 de la feuille TD2)
   *)
  Section proof_of_ex9.
    Hypothesis H : P -> Q.
    Hypothesis H0 : Q -> R.
    Hypothesis H1 : (P -> R) -> T -> Q.
    Hypothesis H2 : (P -> R) -> T.

    Lemma ex9 : Q.

    Proof. 
    assert (h3 : P -> R). {
      intro p.
      apply H0.
      apply H; assumption.
    }
    apply H1.
      - assumption.
      - apply H2;assumption.
    Qed.

  End proof_of_ex9.
  
  (* exercice 12 de la feuille 1 *)
  Section Proof_of_weak_Peirce.

    Hypothesis H: (((P->Q)->P)->P)->Q.
    Lemma weak_Peirce : Q.
    Proof.
    apply H.
    intro h1.
    apply h1.
    intro p.
    apply H.
    intro h1'.
    assumption.
    Qed.

  End Proof_of_weak_Peirce.
  Check weak_Peirce.
  Print weak_Peirce. (* Pas facile à déchiffrer *)
End Declarations.

  
     