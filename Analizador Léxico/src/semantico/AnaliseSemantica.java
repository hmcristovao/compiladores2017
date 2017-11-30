package semantico;

import parser.Token;

public class AnaliseSemantica {
	public static void decaracaoRepetida(Token t) {
		System.out.println("\nErro semantico (linha " + t.beginLine +") A variavel '" + 
				t.image + "' ja existe");
	}
}
