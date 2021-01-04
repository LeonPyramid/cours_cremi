Require Import Setoid.
(*  Logique intuitionniste *)
Definition EXM :=   forall A:Prop, A \/ ~A.

Ltac add_exm  A :=
  let hname := fresh "exm" in
  assert(hname : A \/ ~A);[auto|].



Section Exo3.
Variables A B : Prop.
Hypothesis  exm :  EXM.

  Lemma one:~(A->B)<->~~A/\~B.
  Proof.
    split.
      - intro.
        unfold not in H.
        unfold not.
        split.
          * intros.
            apply H.
            intro.
            exfalso.
            apply H0;assumption.
          * intro.
            apply H.
            intro;assumption.
      - unfold not.
        intro.
        destruct H.
        intro.
        assert(A->False).
        {
          intro.
          apply H0.
          apply H1;assumption.
        }
        apply H; assumption.
  Qed.

  Lemma two:~(A/\B)<->(~~A->~B).
  Proof.
    split.
      - unfold not.
        intros.
        destruct H.
        split.
          + add_exm A.
            destruct exm0.
             * assumption.
             * exfalso.
               apply H0;assumption.
          + assumption.
      - unfold not.
        intros.
        destruct H0.
        apply H.
          + intro.
            apply H2;assumption.
          + assumption.
  Qed.

  Lemma three:~(A\/B)<->~A/\~B.
  Proof.
    split.
      - unfold not.
        intro.
        split.
          + intro.
            apply H;left;assumption.
          + intro.
            apply H;right;assumption.
      - unfold not.
        intros.
        destruct H.
        destruct H0.
          + apply H;assumption.
          + apply H1;assumption.
  Qed.
End Exo3.

Section Exo4.
Variables A B C : Prop.

  Section intro_imp.
    Hypothesis H1 :~~A -> ~~B.

    Lemma intro_imp : ~~(A->B).
    Proof.
      unfold not.
      unfold not in H1.
      intro.
      apply H.
      intro.
      exfalso.
      apply H1.
        - intro;apply H2;assumption.
        - intro.
          apply H.
          intro;assumption.
    Qed.
  End intro_imp.

  Section mod_pon.
    Hypothesis H1 : ~~(A->B).
    Hypothesis H2 : ~~A.

    Lemma mod_pon : ~~B.
    Proof.
      unfold not.
      intro.
      apply H1.
      intro.
      apply H2.
      intro.
      apply H.
      apply H0;assumption.
    Qed.
  End mod_pon.

  Section exf.
    Hypothesis H: ~~False.

    Lemma exf : ~~A.
    Proof.
      intro.
      apply H.
      intro;assumption.
    Qed.
  End exf.

  Section abs.
    Hypothesis H1 : ~~A.
    Hypothesis H2 : ~~~A.

    Lemma abs : ~~B.
    Proof.
      exfalso.
      apply H2;assumption.
    Qed.
  End abs.

  Section intr_neg.
    Hypothesis H : (~~A) -> (~~False).

    Lemma intr_neg : ~~~A.
    Proof.
      intro.
      apply H.
        - assumption.
        - intro;assumption.
    Qed.
  End intr_neg.

  Section intr_dis1.
    Hypothesis H:~~A.

    Lemma intr_dis1:~~(A\/B).
    Proof.
      intro.
      apply H.
      intro.
      apply H0;left;assumption.
    Qed.
  End intr_dis1.

  Section intr_dis2.
    Hypothesis H:~~B.

    Lemma intr_dis2:~~(A\/B).
    Proof.
      intro.
      apply H.
      intro.
      apply H0;right;assumption.
    Qed.
  End intr_dis2.

  Section elim_dis.
    Hypothesis H1 : ~~(A\/B).
    Hypothesis H2 : (~~A) -> (~~C).
    Hypothesis H3 : (~~B) -> (~~C).
    
    Lemma elim_dis: ~~C.
    Proof.
      intro.
      apply H1.
      intro.
      destruct H0.
        - apply H2.
          + intro;apply H4;assumption.
          + assumption.
        - apply H3.
          + intro;apply H4;assumption.
          + assumption.
    Qed.
  End elim_dis.
  
  Section intro_conj.
    Hypothesis H1: ~~A.
    Hypothesis H2: ~~B.
    
    Lemma intro_conj: ~~(A/\B).
    Proof.
      intro.
      apply H1.
      intro.
      apply H2.
      intro.
      apply H.
      split;assumption.
    Qed.
  End intro_conj.
  
  Section elim_conj1.
    Hypothesis H : ~~(A/\B).
    
    Lemma elim_conj1: ~~A.
    Proof.
      intro.
      apply H.
      intro.
      destruct H1.
      apply H0;assumption.
    Qed.
  End elim_conj1.
  
  Section elim_conj2.
    Hypothesis H : ~~(A/\B).
    
    Lemma elim_conj2: ~~B.
    Proof.
      intro.
      apply H.
      intro.
      destruct H1.
      apply H0;assumption.
    Qed.
  End elim_conj2.
  
  Section ti_ex.
    Hypothesis H1 : (~~~A)->(~~B).
    Hypothesis H2 : (~~A) -> (~~B).
    
    Lemma ti_ex : ~~B.
    Proof.
      intro.
      apply H1.
      + intro.
        apply H2;assumption.
      + assumption.
    Qed.
  End ti_ex.
End Exo4.