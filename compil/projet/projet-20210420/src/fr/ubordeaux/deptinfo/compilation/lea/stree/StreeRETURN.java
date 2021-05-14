package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.intermediate.MEM;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.MOVE;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.NAME;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.Stm;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.temp.Label;
import fr.ubordeaux.deptinfo.compilation.lea.type.Type;
import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeRETURN extends Stree {

	private MOVE stm;

	public StreeRETURN(Stree left,Stree right) throws StreeException, TypeException {
		super(left,right);
		this.stm = new MOVE(new MEM(new NAME(new Label("returnValue"))), left.getExp());
	}

	@Override
	public Stm getStm() {
		return stm;
	}


	@Override
	public boolean checkType() throws StreeException {
		//TODO: Tu as bien avancé, tu as une erreur pour vérifier les deux types:
		//là on a Left qui est l'objet renvoyé et returnType qui est le type de retour, voir pourquoi ça dit qu'ils sont pas identiques
		return this.getLeft().getType().assertEqual(this.getRight().getType());
	}
}
