import java.util.ArrayList;
import java.util.NoSuchElementException;


public class Parser
{

	private LexicalAnalyzer lex;
	
/**********************************************
 * need to create lex in a constructor
 */
	
	Program parse() throws ParserException
	{
		match ("main");
		match ("(");
		match (")");
		StatementList stmt = getStatementList();
		return new Program (stmt);
	}

	private StatementList getStatementList() throws ParserException{
		// <statement> | <statement_list> ; <statement>
		StatementList s = new StatementList();
		try{
				
		Statement stmt = getStatement();
		s.add(stmt);
		String tok = lex.look();	
		while(tok.equals(";")){
			match (";");			
			Statement stmt1 = getStatement();
			s.add(stmt1);
			tok = lex.look();

			
		}
			
		}catch(ParserException ex){
			System.out.println("Error in StatementList");
			
		}catch(NoSuchElementException ex){
			return s;
			
			/************************************************
			 * by catching the exception here, you are having
			 * the code continue executing
			 */
		}
		return s;
	}
	private Statement getStatement() throws ParserException{
			String tok = lex.look();
			try {
			if (tok.equals("if")){
				ifStatement iff = getIfStatement();
				return iff;
			}else if (tok.equals("while")){
				WhileStatement whilee = getWhileStatement();
				return whilee;
			}else if(tok.length() == 1){
				assignmentStatement a = getAssignmentStatement();
				return a;
			}else if(tok.equals("display")){
				printStatement S = getPrintStatement();
				return S;			
				}
			}catch(ParserException ex){
				
				/********************************
				 * same comment
				 */
			}
			return null;
			
	}
	
	private ifStatement getIfStatement () throws ParserException{
		match ("if");
		booleanStatement bool = getBooleanExpression();
		match ("then");
		StatementList s1 = getStatementList();
		match ("else");
		StatementList s2 = getStatementList();
		match ("end");
		return new ifStatement(bool, s1, s2);

	}


	private assignmentStatement getAssignmentStatement() throws ParserException{
		//check to see
		//id, match, id
		Id Variable = getId();
		match ("<-");
		arithmeticExpression derp = getArithmeticExpression();
		return new assignmentStatement(Variable,derp);
		
	}

	private arithmeticExpression getArithmeticExpression() throws ParserException{
		try{
		//<Operand>|<arithmethic_op><operand><operand>
		String tok = lex.look();
				if(tok.equals("+") | tok.equals("-") | tok.equals("*") | tok.equals("/")){
					arithmeticOperand op =  getarithmeticOperand();
					Operand op1 = getOperand();
					Operand op2 = getOperand();
					return new arithmeticExpression(op, op1, op2);
					}else{
						Operand op1 = getOperand();
						return new arithmeticExpression(op1);
					}
		}catch(ParserException ex){
			System.out.println("Error in getArithmeticExpression");
			
			/**************************
			 * same comment
			 */
		}
		return null;
	}

	private arithmeticOperand getarithmeticOperand() throws ParserException {
		String tok = lex.look();
			if(tok.equals("+")){
				match("+");
			}else if (tok.equals("-")){
				match ("-");
			}else if (tok.equals("*")){
				match ("*");
			}else if (tok.equals("/")){
				match("/");
			}
			
		return new arithmeticOperand(tok);
		
	}

	private WhileStatement getWhileStatement()throws ParserException{
		// while <boolean_expression> do <statement_list> end
		match("while");
		booleanStatement bool = getBooleanExpression();
		match ("do");		
		StatementList stmt = getStatementList();
		match("end");
		return new WhileStatement(bool,stmt);	
		
	}

	private printStatement getPrintStatement() throws ParserException{
		match ("display");
		match ("(");
		Id id = getId();
		match (")");
		return new printStatement(id);
		
	}
	private booleanStatement getBooleanExpression() throws ParserException{
		//<relative_op><operand><operand>
		BooleanRelativeOpEnum op = getRelativeOp();
		Operand First = getOperand();
		Operand Second = getOperand();
		return new booleanStatement(op,First,Second);
			
		}
	

	private BooleanRelativeOpEnum getRelativeOp() throws ParserException {
		BooleanRelativeOpEnum op;
		String tok = lex.getToken();
		//if doesnt work look at arthimeticOperand
		if (tok.equals(">")) {
			op = BooleanRelativeOpEnum.greater;
			return op;
		} else if (tok.equals(">=")) {
			op = BooleanRelativeOpEnum.greaterEqual;
			return op;
		} else if (tok.equals("<")) {			
			op = BooleanRelativeOpEnum.lesser;
			return op;
		} else if (tok.equals("<=")) {
			op = BooleanRelativeOpEnum.lesserEqual;
			return op;
		} else if (tok.equals("=")) {
			op = BooleanRelativeOpEnum.Equal;
			return op;
		} else if (tok.equals("/=")) {
			op = BooleanRelativeOpEnum.notEqual;
			return op;
		} else
			throw new ParserException("boolean operator expected");

	}

	private Operand getOperand() throws ParserException{
		//needs work
		//id|constant
		//check each letter 
		//case or if statement
		//if statements else go to constant method
		//parse the look, throw declaration
		String tok = lex.look();
		//if character is digit (is digit
		if (Character.isLetter(tok.charAt(0))) {
				Id id = getId();
				return id;
		}else {
			Constant con = getConstant();
			return con;
		}
	}
	private Constant getConstant() throws ParserException{
		String tok = lex.getToken();
		int con = Integer.parseInt(tok);
		//get token return as constant
		return new Constant(con);
		
	}
	
	private void match(String expected) throws ParserException
	{
		String token = lex.getToken();
		if (!expected.equals(token)){
			throw new ParserException (expected + " expected");
		}
	
	}
	
	//private ForStatement getForStatement () throws ParserException
	//{
	//	match ("for");
	//	Id var = getId();
	//	match ("<-");
	//	Operand op1 = getOperand();
	//	match ("to");
	//	Operand op2 = getOperand();
	//	match ("do");
	//	Statement s = getStatement();
	//	return new ForStatement (var, op1, op2, s);
	//}
	private Id getId() throws ParserException{
		
		String tok = lex.getToken();
		if (tok.length() != 1) {
			throw new ParserException("id expected");
		} else if (Character.isLetter(tok.charAt(0))) {
			return new Id(tok.charAt(0));
		} else
			throw new ParserException("id expected");
	}

	
}
