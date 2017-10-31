package apoio;
import parser.*;

public class RecuperacaoErro {

	public static void recuperaErroPanico(int tokenSincronismo, String esperado) {
		  Token t = CompiladorHell.getToken(1);
		  System.out.println("\nErro sintatico (linha "+t.beginLine+") Encontrou \'"
		                     + t.image + "\', era esperado: " + esperado);

		  while(t.kind != tokenSincronismo && t.kind != 0) {
		     CompiladorHell.getNextToken();
		     t = CompiladorHell.getToken(1);
		  }
		  CompiladorHell.getNextToken();
			  
		}

}
