
public class Id extends Operand{
	private char c;
	private static int[] anArray = new int[26];
	private static String[] memory = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
			  "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	//for (int i = 0; i < anArray.length; i++)
		//anArray[i] = 'a';
	
	public Id(char c) {
		super();
		this.c = c;
		
		
		
		}
	public int getOperand() {
		for(int i = 0; i< memory.length; i++){
			if(memory[i].equals(Character.toString(c))){
				return anArray[i];
			}
		}
		return 0;
	}
	public void setOperand(int val, Id var) {	
		for(int i = 0; i<memory.length;i++){
			if(Character.toString(c).equals(memory[i]) ){
				anArray[i] = val;
				
				}
			}
		}
	
	/*************************************************
	 * There are more efficient ways to access memory.
	 */
}
	
