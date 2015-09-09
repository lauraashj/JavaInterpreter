import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class LexicalAnalyzer
{
	StringTokenizer token;
	static String buffer;
	static boolean bufferFull = false;
	static Scanner input;
	FileReader rd;
	
	/************************************************
	 * instance fields should be private
	 * 
	 * should not be using static here
	 */
	
	public static void main(String[] args) throws ParserException, FileNotFoundException{
		input = new Scanner(new File("test2.txt"));
		//while(input.hasNext()){
			//System.out.println(input.next());
			
		//}
		Parser par = new Parser();
		par.parse();
		
	}
	
	/********************************************************
	 * better style would be to have "main" in a separate class
	 * @return
	 */
	public  static String getToken() {
		
		if (bufferFull == true){
			bufferFull= false;
			return buffer;
		}
		String get = input.next();
		return get;
	}
	public static String look() {
		if(bufferFull == true){
			return buffer;
		}else{
		String get = input.next();
		buffer = get;
		bufferFull = true;
		return buffer;
		}
		
	}

	

}

/****************************************************
 * 96/100 Please see my comments in your code.
 */

//StringTokenizer token;

//FileReader rd = new FileReader("C:/derp.txt");

//public String getNextToken(String Name) throws IOException
//{
	
	//String tok  = rd.toString();
	//token = new StringTokenizer(tok, " ");
	//String tok1 = token.nextToken();
	//return tok1;
	