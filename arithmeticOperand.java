
public class arithmeticOperand {
	String tok;
	static String s;
	
	/**************************************************
	 * instance fields should be private - s should not
	 * be static & should be a local variable
	 */
	public arithmeticOperand(String tok) {
		this.tok = tok;
		
		
	}
	public String getArithmeticOperand(){
		if(tok.equals("+")){
			s = "add";			
		}if(tok.equals("-")){
			s = "minus";
		}if(tok.equals("*")){
			s = "multi";				
		}if(tok.equals("/")){
			s = "division";
		
		}
		return s;	
	}
	
}
