
public class WhileStatement extends Statement{
	private booleanStatement b;
	private StatementList stmt;
	public WhileStatement(booleanStatement b, StatementList stmt) {
		this.b = b;
		this.stmt = stmt;
	}	

	public void getStatement() {		
	while(b.getBooleanExpression()){
		stmt.getStatementList();
		
		}
	}		
}


