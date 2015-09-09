
public class assignmentStatement extends Statement{
	private Id variable;
	private arithmeticExpression derp; 

	public assignmentStatement(Id variable, arithmeticExpression derp) {
		this.variable = variable;
		this.derp = derp;
		
		

		
			}
	public void getStatement() {
		int a = derp.getArithmeticExpression();
		this.variable.setOperand(a, variable);
	}
		

	}
