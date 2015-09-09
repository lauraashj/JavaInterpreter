//implementation
public class Program
{

	private StatementList stmt;
	
	
	public Program(StatementList stmt) throws ParserException
	{
		this.stmt=stmt;		
		startProgram();
	}


	private void startProgram(){
		stmt.getStatementList();
	}
	
	

}
