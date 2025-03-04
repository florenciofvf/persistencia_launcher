package testes;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import br.com.persist.plugins.instrucao.InstrucaoException;

public class ListaFiltroTest extends AbstratoTeste {
	public ListaFiltroTest() {
		super("lista_filtro");
	}

	@Test
	public void test() throws IOException, InstrucaoException {
		compilar();

		result = processador.processar(bibliotecaContexto.getNome(), "main");
		assertEquals("[[2, 4, 50, 6]]", result.toString());
	}
}