import java.util.ArrayList;


public class StatementList{

	private ArrayList<Statement> stmtList  = new ArrayList<Statement>();
	
	public StatementList() {
		
	}

	
	public void add(Statement statement) {
		stmtList.add(statement);
		
	}

	public void getStatementList() {
		for(int counter = 0; counter < stmtList.size(); counter ++)
		stmtList.get(counter).getStatement();

		
	}

}
