Require Import Setoid.
(*  Logique intuitionniste *)

Section LJ.
 Variables P Q R S T : Prop.
 (*  Tactiques pour la conjonction 

    Introduction : pour prouver A /\ B : split (il faudra prouver A, puis B)
    Elimination : destruct H, si H : A /\ B 
                  variante : destruct H as [H1 H2].
        Dans les deux cas, on récupère deux hypothèses pour A et B (et on 
        choisit leurs noms, pour la variante "as...")
  *)
  Lemma and_comm : P /\ Q -> Q /\ P.
  Proof.
    intro H.
    destruct H as [H0 H1].

    split.
    - assumption.
    - assumption.
    (* "assumption" résoud les deux sous-buts engendrés par "split"
    donc on peut remplacer les trois dernières lignes par
    split; assumption.
    *)
    Undo 5.
    split; assumption. (* "assumption" s'applique à (et résout) tous les sous-buts *)
  Qed.
  (* Sous Forme linéaire :
  1 { Supposons P /\ Q
  2   { Supposons P
  3     Supposons Q
  4     Q /\ P [/\_i, 3, 2]
  6   }
  7   Q /\ P [/\_e, 1, 2-4]
  8 }
  9 P /\ Q -> Q /\ P [->_i, 1, 7]
  *)


 (* tactiques pour la disjonction 
    Introduction:
     pour prouver A \/ B a partir de A : left
     pour prouver A \/ B a partir de B : right

    Elimination:
     preuve par cas : destruct H, si H: A \/ B
                      variante : destruct H as [H1 | H2]
        On aura a faire deux preuves, une pour chaque cas (cas A, cas B)
  *)

  Lemma or_not : P \/ Q -> ~P -> Q.
  Proof.
    intros H H0.
    destruct H.
    - exfalso.
      apply H0.
      assumption.

      Undo 3.
      assert (f:False).
      {
        apply H0.
        assumption.
      }
      destruct f.
      (* "destruct f" sur f:False résoud n'importe quel but *)

      Undo 6.
      apply H0 in H.
      destruct H.

      Undo 2.
      absurd P.
      + assumption.
      + assumption.

   - assumption.
   Qed.
  (* Sous Forme linéaire :
  1 { Supposons P \/ Q
  2   Supposons ~P
  3   { Supposons P
  4     False [mp, 2, 3]
  5     Q [False_e, 4]
  6   }
  7   { Supposons Q
  8     Q [7]
  9   }
 10   Q [\/_e, 1, 3-5, 7-8]
 11 }
 12 P \/ Q -> ~P -> Q [->_i, 1, 2, 10]
  *)

  (* Structuration de la preuve: -,+,*,--,++,**
     utiles quand on a plusieurs sous-preuves non triviales;
     améliorent la lisibilité du script *)

   (*  equivalence logique (<->, iff):
       unfold iff transforme A <-> B en
                             (A -> B) /\ (B -> A).
       donc split, destruct, etc, marchent

       (iff pour "if and only if", le "si et seulement si" en anglais)
    *)

  Lemma iff_comm : (P <-> Q) -> (Q <-> P).
  Proof.
    intro H.
    destruct H.
    split; assumption.
  Qed.

  (* la regle de remplacement est implantée en Coq *)
  (* "rewrite H" fait un remplacement uniforme quand H est une
     équivalence *)
  (* "rewrite H" réécrit le but courant avec H *)
  (* "rewrite H in H'" fait la réécriture de H dans une autre hypothèse H' *)
  (* "rewrite <- H" réécrit dans l'autre sens, le membre droit par le gauche *)
  Lemma L1 : (P <-> Q) -> ~(Q <-> ~P).
  Proof.
    intro H.
    rewrite H.
    intro H0.
    destruct H0.
    unfold not in H0.

    assert (~Q).
    {
      intro H2.
      apply H0; assumption.
    }
    apply H2.
    apply H1.
    assumption.

    Undo 8.
    assert Q.
    {
      apply H1.
      intro H2.
      apply H0; assumption.
    }
    apply H0; assumption.
  Qed.

  (* Fin des exemples, début des exercices *)

  (* Exercice : remplacer tauto par des vraies preuves 
     interactives *)
  (*  Exercices de la feuille 4 *)

  Lemma and_false : P /\ False -> False.
  Proof.
      intro.
      destruct H.
      assumption.
  Qed.

  Lemma and_assoc : (P /\ Q) /\ R <-> P /\ (Q /\ R).
  Proof.
      split.
        - intro.
          destruct H.
          destruct H.
          split.
          assumption.
          split;assumption.
        - intro.
          destruct H.
          destruct H0.
          split.
          + split;assumption.
          + assumption.
  Qed.


  (* Ex. 2 *)
  Lemma or_to_imp: ~ P \/ Q -> P -> Q.
  Proof.
   intro.
   destruct H.
    - intro.
      absurd P;assumption.
    - intro;assumption.
  Qed.   

  Lemma not_or_and_not: ~(P\/Q) -> ~P /\ ~Q.
  Proof.
    intro.
    unfold not in H.
    split;unfold not.
      - intro.
        apply H.
        left;assumption.
      - intro.
        apply H.
        right;assumption.
  Qed.

  (* Exercice 4 *)

  Lemma absorption_or: P \/ False <-> P.
  Proof.
    split.
      - intro.
        destruct H.
          + assumption.
          + exfalso;assumption.
      - intro.
        left;assumption.
  Qed.

  Lemma and_or_dist : P /\ (Q \/ R) <-> P /\ Q \/ P /\ R.
  Proof.
    split.
      - intro.
        destruct H.
        destruct H0.
          + left.
            split;assumption.
          + right.
            split;assumption.
      - intro.
        split.
          + destruct H.
            * destruct H;assumption.
            * destruct H;assumption.
          + destruct H.
            * left;destruct H;assumption.
            * right;destruct H;assumption.
  Qed.

  Lemma or_and_dist : P \/ (Q /\ R) <-> (P \/ Q) /\ (P \/ R).
  Proof.
    
  Qed.

  Lemma and_not_not_impl: P /\ ~ Q -> ~(P -> Q).
  Proof.
    tauto.
  Qed.

  Lemma de_morgan1 : ~ (P \/ Q) <-> ~P /\ ~Q.
  Proof.
    tauto.
  Qed.

  Lemma reductio_ad_absurdum: (P -> ~P) -> ~P.
  Proof.
    tauto.
  Qed.

  Lemma np_p_nnp: (~P -> P) -> ~~P.
  Proof.
    tauto.
  Qed.

  (* Exercice: reprendre toutes les preuves précédentes, 
     en simplifiant et clarifiant les scripts:
     - structurer les sous-preuves avec -/+/*
     - inversement, quand c'est possible, factoriser avec 
       l'enchainement de tactiques (par ";")

     Le but est de faire que le script soit plus facile à lire
     par un humain, pas pour la machine.
   *)
  
End LJ.

(*  Logique classique
    On peut sauter les 4 commandes suivantes 
 *)

(* un peu de magie noire *)
Definition EXM :=   forall A:Prop, A \/ ~A.

Ltac add_exm  A :=
  let hname := fresh "exm" in
  assert(hname : A \/ ~A);[auto|].

Section LK.

  Hypothesis  exm :  EXM.

  (* 
   Pour ajouter une instance du tiers-exclu de la forme  A \/ ~A 
   il suffit d'exécuter la commande "add_exm A"
   *)

  Variables P Q R S T : Prop.

  Lemma double_neg : ~~ P -> P.
  Proof.
    intro H.
    add_exm  P. (* "je fais un tiers exclus sur P " *)
    destruct exm0. (* Presque toujours, destruct suit add_exm *)
    - assumption.
    - assert (f:False).
      {
        apply H; assumption.
      }
      destruct f.

      Undo 5.
      exfalso.
      apply H; assumption.

      Undo 2.
      absurd (~P); assumption.
   Qed.

  (* Exercice: completer toutes les preuves, en remplaçant les
     "Admitted" par des preuves terminées par "Qed."; et 
     sans utiliser ni auto, ni tauto.  *)

  Lemma de_morgan : ~ ( P /\ Q) <-> ~P \/ ~Q.
  Proof.
  Admitted.

  Lemma not_impl_and : ~(P -> Q) <-> P /\ ~ Q.
  Proof.
  Admitted.

  Lemma contraposee: (P -> Q) <-> (~Q -> ~P).
  Proof.
  Admitted.

  Lemma exm_e : (P -> Q) -> (~P -> Q) -> Q.
  Proof.
  Admitted.

  Lemma exo_16 : (~ P -> P) -> P.
  Proof.
  Admitted.

  Lemma double_impl : (P -> Q) \/ (Q -> P).
  Proof.
  Admitted.

  Lemma imp_translation : (P -> Q) <-> ~P \/ Q.
  Proof.
  Admitted.

  Lemma Peirce : (( P -> Q) -> P) -> P.
  Proof.
  Admitted.

  (* Quelques exercices d'anciens tests *) 
  Lemma test_1: (P->Q)->(~P->R)->(R->Q)->Q.
  Proof.
  Admitted.

  Lemma test__2: (P \/ (Q\/R))-> (~P) -> (~R) -> (P\/Q).
  Proof.
  Admitted.

  Lemma test_3: (~P-> Q/\R)->(Q->~R)->P.
  Proof.
  Admitted.

  Lemma test_4: (~P->Q)->(~Q\/R)->(P->R)->R.
  Proof.
  Admitted.

  Lemma test_5: (P->Q)->(~P->~Q)->((P/\Q) \/ ~(P\/Q)).
  Proof.
  Admitted.

  Lemma test_6: (P->Q)->(~P->Q)->(Q->R)->R.
  Proof.
  Admitted.

End LK.

Section Club_Ecossais. (* version propositionnelle *)
  Variables E R D M K: Prop.
  (* Ecossais, chaussettes Rouges, sort le Dimanche, Marié, Kilt *)

  Hypothesis h1: ~E -> R.
  (* Tout membre non ecossais porte des chaussettes rouges *)
  Hypothesis h2: M -> ~D.
  (* Les membres maries ne sortent pas le dimanche *)
  Hypothesis h3: D <-> E.
  (* Un membre sort le dimanche si et seulement si il est ecossais *)
  Hypothesis h4: K -> E /\ M.
  (* Tout membre qui porte un kilt est ecossais et est marie *)
  Hypothesis h5: R -> K.
  (* Tout membre qui porte des chaussettes rouges porte un kilt *)
  Hypothesis h6: E -> K.
  (* Tout membre ecossais porte un kilt. *)

  Lemma personne: False. (* Le club est vide! *)
  Proof.
  Admitted.

End Club_Ecossais.  
  
(** On peut sauter cette section *)

(* Au sens strict, cette partie est hors programme; il s'agit de voir que 
   diverses hypothèses (toutes formulées "au second ordre": avec des 
   quantificateurs universels sur des propositions)
   sont équivalentes, et correspondent à la logique classique *)
Section Second_ordre. 
  Definition PEIRCE := forall A B:Prop, ((A -> B) -> A) -> A.
  Definition DNEG := forall A, ~~A <-> A.
  Definition IMP2OR := forall A B:Prop, (A->B) <-> ~A \/ B.

  Lemma L2 : IMP2OR -> EXM.
  Proof.
    unfold IMP2OR, EXM.
    intros.
    assert (~ A \/ A).
    {
      rewrite <- H. (* Coq "voit" qu'il suffit de prendre B=A; il va falloir prouver A->A *)
      admit.
    }
  admit.
  Admitted.


  Lemma L3 : EXM -> DNEG.
  Proof.
    unfold DNEG , EXM.
    intros.
    (* H permet de faire un tiers exclus sur A *)
    specialize H with (A:=A).
    admit.
  Admitted.

  Lemma L4 : PEIRCE -> DNEG.
  Proof.
    unfold DNEG , PEIRCE.
    (* On pourra utiliser :
       specialize H with (A:=à-compléter) (B:=à-compléter-aussi).
    *)
  Admitted.

  Lemma L5 : EXM -> PEIRCE.
  Proof.
  Admitted.

End Second_ordre.


