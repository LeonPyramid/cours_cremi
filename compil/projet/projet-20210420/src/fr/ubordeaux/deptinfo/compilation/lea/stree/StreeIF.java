package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.intermediate.Stm;
import fr.ubordeaux.deptinfo.compilation.lea.type.Tag;
import fr.ubordeaux.deptinfo.compilation.lea.type.Type;
import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.LABEL;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.CJUMP;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.SEQ;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.CONST;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.JUMP;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.temp.Label;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.CJUMP.Op;


public class StreeIF extends Stree {

	private Stm stm;

	public StreeIF(Stree left, Stree right) throws StreeException, TypeException {
		super(left, right);
		this.stm = generateIntermediateCode();
	}

	@Override
	public Stm getStm() {
		return stm;
	}

	@Override
	public Stm generateIntermediateCode()throws StreeException{ 
		Label label1 = new Label();
		Label label2 = new Label();
		Label label3 = new Label();

		//si  il  n'y a pas de else:
		//code du test 
		// goto label1 si ==0 sinon label2
		//	label 1:
		//		codeif
		//		
		//	label2:
		//
		
		if(getRight().getRight()==null){
			System.out.println("sans else");
			return new SEQ(new CJUMP(CJUMP.Op.EQ,getLeft().getExp(),new CONST(0),label1,label2),
				new SEQ(new LABEL(label1),
					new SEQ(getRight().getLeft().getStm(),
						new LABEL(label2))));
		}
		// code du test
		// goto label1 si == 0 sinon label2	
		//	label1:
		//		code if
		//		goto label3
		//  label2:
		//		code else
		// 		goto label3:
		//	label3:
		//	fin
		//
		//
		System.out.println("ifthelese");
		return new SEQ(	new CJUMP(CJUMP.Op.EQ, getLeft().getExp(),new CONST(0),label1,label2),
						new SEQ(new LABEL(label1),
							new SEQ(getRight().getLeft().getStm(),
								new SEQ(new JUMP(label3),
									new SEQ(new LABEL(label2),
										new SEQ(getRight().getRight().getStm(),
											new LABEL(label3)))))));
	}

	@Override
	public boolean checkType() throws StreeException {
		Type typeLeft = getLeft().getType();
		if (typeLeft != null)
			return typeLeft.assertBoolean();
		else
			throw new StreeException("Type error while checking null types !");
	}

}