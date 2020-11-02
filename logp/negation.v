Section Negation.
  Variables P Q R S T: Prop.

  (* unfold not: expansion de la négation dans le but *)
  (* unfold not in X: expansion de la négation dans l'hypothèse X *)
  (* exfalso: transforme le but courant en False; c'est l'équivalent
     de la règle d'élimination de la contradiction *)

  (* Executez cette preuve en essayant de comprendre le sens de chacune des nouvelles tactiques utilisées. *)
  Lemma absurde_exemple: P -> ~P -> S.
  Proof.
    intros p np.
    unfold not in np.
    exfalso.
    apply np.
    assumption.
  Qed.
  
  Lemma triple_neg_e : ~~~P -> ~P.
  Proof.
     intro H. 
     intro H0.
     apply H.
     intro H1.
     apply H1; assumption.
   Restart.  (* Annule la preuve en cours, et en commence un autre *)
   unfold not.
   auto.
   (* auto est une tactique qui est capable de beaucoup, mais qu'on
      s'interdira d'utiliser dans nos preuves *)
   Qed.


    (* Remplacer les Admitted par des scripts de preuve *)
  Lemma absurde: (P -> Q) -> (P -> ~Q) -> (P -> S).
  Proof.
    intro h0.
    intro h1.
    intro p.
    exfalso.
    apply h1.
    assumption.
    apply h0; assumption.
  Qed.


  Lemma triple_abs: ~P -> ~~~P.
  Proof.
    intro np.
    intro h0.
    apply h0;assumption.
  Qed.

  Lemma absurd' : (~P -> P) -> ~~P.
  Proof.
    intro h0.
    intro np.
    apply np.
    apply h0.
    assumption.
  Qed.

  Definition Peirce  := ((P -> Q) -> P) -> P.

  (* On va prouver non-non-Peirce *)
  Lemma Peirce_2 : ~~ Peirce.
  Proof.
    (* Strategie: sous hypothese ~Peirce [par intro], montrer ~P, puis s'en 
       servir pour montrer Peirce, et on aura une contradiction
       entre Peirce et ~Peirce *)
    intro.
    assert (np: ~P).
    - intro.
      apply H.
      intro.
      assumption.
    - unfold not in np.
      apply H.
      intro.
      apply H0.
      intro p.
      exfalso.
      apply np;assumption.
  Qed.

  (* Une série de séquents à prouver; à chaque fois, il faut
  l'énoncer, en introduisant les hypothèses au moyen d'une
  sous-section... *)

  (* P->Q, R->~Q, P->R |- P->S *)
  Section l1.
    Hypothesis h0 : P -> Q.
    Hypothesis h1 : R -> ~Q.
    Hypothesis h2 : P -> R.
    Lemma L1 : P -> S.
    Proof.
      intro.
      exfalso.
      apply h1.
      - apply h2; assumption.
      - apply h0; assumption.
    Qed.
  End l1.


  (* ~P->~Q |- ~~Q->~~P *)
  Section l2.
    Hypothesis h0 : ~P -> ~Q.
    Lemma L2 : ~~Q->~~P.
    Proof.
      intro.
      unfold not.
      intro.
      apply H.
      apply h0.
      assumption.
    Qed.
  End l2.
  (* P->~P |- ~P *)
  Section l3.
    Hypothesis H : P -> ~P.
    Lemma L3 : ~P.
    Proof.
      intro.
      apply H; assumption.
    Qed.
  End l3.

  (* ~~P |- ~P->~Q *)
  Section l4.
    Hypothesis nnp : ~~P.
    Lemma L4 : ~P->~Q.
    Proof.
      intro.
      intro.
      apply nnp; assumption.
    Qed.
  End l4.


  (* P->~Q, R->Q |- P->~R *)
  Section l5.
    Hypothesis H : P->~Q.
    Hypothesis H0 : R -> Q.
    Lemma L5 : P->~R.
    Proof.
      intro.
      intro.
      apply H.
      - assumption.
      - apply H0;assumption.
    Qed.
  End l5.


  (* ~(P->Q) |- ~Q *)
  Section l6.
    Hypothesis H : ~(P->Q).
    Lemma L6 : ~Q.
    Proof.
      intro.
      apply H.
      intro;assumption.
    Qed.
  End l6.

  (* Séquents proposés dans le test de la semaine 42 *)

  Section TestMercredi.
    
    Hypothesis H: P->Q.

    Lemma Mercredi: ~(~Q->~P) -> R.
    Proof.
      intro.
      exfalso.
      apply H0.
      intro.
      intro.
      apply H1.
      apply H.
      assumption.
    Qed.
  End TestMercredi.

  Section TestJeudi.
    Hypothesis H: ~(P->R).

    Lemma Jeudi: Q->(P->Q->R)->P.
    Proof.
      intro.
      intro.
      exfalso.
      apply H.
      intro.
      apply H1;assumption.
    Qed.
  End TestJeudi.

  Section TestVendrediMatin.
    Hypothesis H: ~(Q->R).

    Lemma VendrediMatin: (P->Q->R)->(P->Q).
    Proof.
      intro.
      intro.
      exfalso.
      apply H.
      intro.
      apply H0; assumption.
    Qed.
  End TestVendrediMatin.

  Section TestVendrediAM.
    Hypothesis H: ~~P.

    Lemma VendrediAM: Q->(P->Q->False)->P.
    Proof.
      intro.
      intro.
      exfalso.
      apply H.
      intro.
      apply H1;assumption.
    Qed.
  End TestVendrediAM.
    
End Negation.


