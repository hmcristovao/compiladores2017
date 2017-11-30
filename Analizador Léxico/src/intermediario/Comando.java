package intermediario;

import intermediario2.*;

public abstract class Comando
{
	public abstract PrimitivoListaComandos geraCodigoPrimitivo();

	public abstract String toString();
}