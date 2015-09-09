
public class printStatement extends Statement{
	private Id id;
	public printStatement(){
		
	}
		
	public printStatement(Id id) {
		this.id = id;
	}

	public void getStatement() {
		System.out.println(id.getOperand());
		
	}
}

	
	
