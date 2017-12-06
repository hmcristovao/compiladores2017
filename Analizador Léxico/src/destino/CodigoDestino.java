package destino;


import java.io.BufferedWriter;

import parser.*;

import java.io.FileWriter;
import java.io.IOException;

import apoio.Config;
import intermediario.Expressao;
import intermediario2.*;

public class CodigoDestino {
    
	private String codigo = new String();

	public void geraCodigoAssembler(PrimitivoListaComandos lista) {
		this.codigo += ".source "+Config.nomeCodigoDestino+".java\r\n";
		this.codigo += ".class public "+Config.nomeCodigoDestino+"\r\n";
		this.codigo += ".super java/lang/Object\r\n";
		this.codigo += ".method public <init>()V\r\n";
		this.codigo += ".limit stack 1\r\n";
		this.codigo += ".limit locals 1\r\n";
		this.codigo += "aload_0\r\n";
		this.codigo += "invokespecial java/lang/Object/<init>()V\r\n";
		this.codigo += "return\r\n";
		this.codigo += ".end method\r\n\r\n";
		this.codigo += ".method public static main([Ljava/lang/String;)V\r\n";
		this.codigo += ".limit stack "+(Expressao.getMaxPilhaGeral()+2)+"\r\n";  
		this.codigo += ".limit locals "+(CompiladorHell.tabela.getMarcador()+2)+"\r\n\r\n"; 
		this.codigo += this.processaListaComandos(lista);
		this.codigo += "return\r\n";
		this.codigo += ".end method\r\n";
 	}

	public String processaListaComandos(PrimitivoListaComandos lista){
		String saida="";

		for(PrimitivoComando com: lista.comandos){
			saida+=com.geraCodigoDestino();
		}
		return saida;
	}
	
	
    public String toString() {
    	return codigo.toString();
    }

}