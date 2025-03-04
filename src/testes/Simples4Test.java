package testes;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import br.com.persist.plugins.instrucao.InstrucaoException;

public class Simples4Test extends AbstratoTeste {
	public Simples4Test() {
		super("simples4");
	}

	@Test
	public void test() throws IOException, InstrucaoException {
		compilar();

		result = processador.processar(bibliotecaContexto.getNome(), "dobrar", bi(30));
		assertEquals("[60]", result.toString());

		result = processador.processar(bibliotecaContexto.getNome(), "quadrado", bi(30));
		assertEquals("[900]", result.toString());

		result = processador.processar(bibliotecaContexto.getNome(), "somar", bi(30), bi(3));
		assertEquals("[-33]", result.toString());

		result = processador.processar(bibliotecaContexto.getNome(), "area", bi(30));
		assertEquals("[2827.4057100]", result.toString());
	}
}