
public class ifStatement extends Statement{
	
	private static booleanStatement bool;
	private static StatementList s1;
	private static StatementList s2;
	
	public ifStatement (booleanStatement bool, StatementList s1,
			StatementList s2) {
		super();
		this.bool = bool;
		this.s1 =s1;
		this.s2 = s2;
		
		}

	public void getStatement() {
		//if <boolean_expression> then <statement_list> else <statement_list> end
		if(this.bool.getBooleanExpression()){
			s1.getStatementList();
		}else{
			s2.getStatementList();
		}
				
	}

}
