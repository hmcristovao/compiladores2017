package destino;


import java.io.BufferedWriter;

import semantico.*;

import java.io.FileWriter;
import java.io.IOException;

import apoio.Config;
import intermediario.Expressao;
import intermediario2.*;

public class CodigoDestino {
    
	private String codigoDestino = new String();
	
	public void geraCodigoAssembler(PrimitivoListaComandos lista) {
            // ...
		BufferedWriter arqSaida;
		try{
			
			this.codigoDestino += ".source "+Config.nomeCodigoDestino+".java\r\n";
			this.codigoDestino += ".class public "+Config.nomeCodigoDestino+"\r\n";
			this.codigoDestino += ".super java/lang/Object\r\n";
            this.codigoDestino += ".method public <init>()V\r\n";
            this.codigoDestino += ".limit stack 1\r\n";
            this.codigoDestino += ".limit locals 1\r\n";
            this.codigoDestino += "aload_0\r\n";
            this.codigoDestino += "invokespecial java/lang/Object/<init>()V\r\n";
            this.codigoDestino += "return\r\n";
            this.codigoDestino += ".end method\r\n\r\n";
            this.codigoDestino += ".method public static main([Ljava/lang/String;)V\r\n";
            this.codigoDestino += ".limit stack "+(Expressao.getMaxPilhaGeral()+2)+"\r\n";  
            this.codigoDestino += ".limit locals "+(Simbolo.getMarcador()+2)+"\r\n\r\n"; 
            this.codigoDestino += processaListaComandos(lista);
            this.codigoDestino += "return\r\n";
            this.codigoDestino += ".end method\r\n";
            
            arqSaida = new BufferedWriter(new FileWriter(Config.nomeCodigoDestino + ".j"));
            arqSaida.write(this.codigoDestino);
            arqSaida.close();
            
		}catch(IOException e){
			System.out.println("Problemas na geracao do codigo destino");
			System.exit(1);
		}catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
	
	static String processaListaComandos(PrimitivoListaComandos lista){
		String saida="";
		for(PrimitivoComando com: lista.comandos){
			saida+=com.geraCodigoDestino();
		}
		return saida;
	}
	
	
    public String toString() {
    	return codigoDestino.toString();
    }

}