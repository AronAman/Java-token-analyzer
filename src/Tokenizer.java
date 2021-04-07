import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Tokenizer
{

	public static void main(String[] args) throws IOException
	{
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try
		{
			fileReader = new FileReader("hello.java");
			bufferedReader = new BufferedReader(fileReader);
			StreamTokenizer st = new StreamTokenizer(bufferedReader);

			boolean done = false;

			while(!done){
				int token = st.nextToken();
				if(token == StreamTokenizer.TT_EOF){
					System.out.println("End of file");
					done=true;
				}else if(token == StreamTokenizer.TT_EOL){
					System.out.println("End of line");
					System.out.println("line number: "+st.lineno());
				}else if(token==StreamTokenizer.TT_WORD){
					System.out.println(st.sval);
				}else if(token==StreamTokenizer.TT_NUMBER){
					System.out.println(st.nval);
				}else{
					System.out.println((char)token);
				}
			}
		}
		finally
		{
			if (bufferedReader != null)
			{
				bufferedReader.close();
			}
		}

	}

}
