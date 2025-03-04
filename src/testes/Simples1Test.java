package testes;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import br.com.persist.plugins.instrucao.InstrucaoException;

public class Simples1Test extends AbstratoTeste {
	public Simples1Test() {
		super("simples1");
	}

	@Test
	public void test() throws IOException, InstrucaoException {
		compilar();

		assertNotNull(bibliotecaContexto);
	}
}