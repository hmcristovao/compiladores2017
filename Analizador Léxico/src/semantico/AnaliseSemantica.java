package semantico;

import java.util.Set;

import parser.Token;
import parser.CompiladorHell;

public class AnaliseSemantica {
	public static void decaracaoRepetida(Token t) {
		System.out.println("\nErro semantico (linha " + t.beginLine +") A variavel '" + 
				t.image + "' ja existe");
		System.exit(1);
	}
	public static void variavelNaoUtilizada(){
		  Set<String> chaves = CompiladorHell.tabela.getKeySet();
		  System.out.print("\n");
		  for (String chave : chaves){
			  if (!CompiladorHell.tabela.consultaSimbolo(chave).foiUsada()){
				  System.out.println("WARNING : Variavel "+chave+" nao foi usada.");
			  }
		  }
		  System.out.print("\n");
			
	}
}

