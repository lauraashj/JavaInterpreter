
public class arithmeticExpression {
	private arithmeticOperand op;
	private Operand op1;
	private Operand op2;
	private int solve;
	
	/**********************************************
	 * solve should be a local variable
	 */
	
	public arithmeticExpression(arithmeticOperand op, Operand op1, Operand op2) {
		this.op = op;
		this.op1 = op1;
		this.op2 = op2;
		}

	public arithmeticExpression(Operand op1) {
		this.op1 = op1;
}

	public int getArithmeticExpression(){
		int one;
		int two;
		String operand;
		
		one = this.op1.getOperand();
		try{
		two = this.op2.getOperand();
		operand = op.getArithmeticOperand();
			if(operand.equals("add")){
			solve = one+two;
			return solve;
		}if(operand.equals("minus")){
			solve = one-two;
			return solve;
		}if(operand.equals("multi")){
			solve = one-two;
			return solve;
		}if(operand.equals("division")){
			solve = one/two;
			return solve;
		}
		}catch(NullPointerException ex){
			return one;
			}
		
		/***************************************************
		 * This will work but it is not a proper use of
		 * exceptions.
		 */
		return 0;
		}
	}
		




