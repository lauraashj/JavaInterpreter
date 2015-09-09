
public class booleanStatement {
	private boolean stmt;
	
	/***************************************************
	 * stmt should be a local variable
	 */
	private BooleanRelativeOpEnum op;
	private Operand first;
	private Operand second;
	public booleanStatement(BooleanRelativeOpEnum op, Operand first, Operand second) {
		this.op = op;
		this.first = first;
		this.second = second;
	}

	public boolean getBooleanExpression() {
		// TODO Auto-generated method stub
		//(op == booleanStatement.BooleanOperator.greaterEqual) 
		if(op == BooleanRelativeOpEnum.greater){
			stmt = (first.getOperand() > second.getOperand());
			return stmt;
		}if(op== BooleanRelativeOpEnum.greaterEqual){
			stmt = (first.getOperand() >= second.getOperand());
			return stmt;
		}if(op == BooleanRelativeOpEnum.lesser){
			stmt = (first.getOperand() < second.getOperand());
			return stmt;
		}if(op == BooleanRelativeOpEnum.lesserEqual){
			stmt = (first.getOperand() <= second.getOperand());
			return stmt;
		}if(op == BooleanRelativeOpEnum.Equal){
			stmt = (first.getOperand() == second.getOperand());
			return stmt;
		}if(op == BooleanRelativeOpEnum.notEqual){
			stmt = (first.getOperand() != second.getOperand());
			return stmt;
		}
		return stmt;
	}

}
