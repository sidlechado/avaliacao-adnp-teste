package questao07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class questao07 {

	@Test
	void Teste1() {
		SistemaDeRecurso sis = new SistemaDeRecurso();
		
		sis.login("adm", "123");
		assertTrue(sis.isLogado());
		
		sis.logout();
		assertFalse(sis.isLogado());
		
		sis.login("adm", "123");
		sis.acessar();
		sis.acessar();
		assertTrue(sis.isLogado());
		
		sis.logout();
		assertFalse(sis.isLogado());
	}
	
	@Test
	void Teste2() {
		SistemaDeRecurso sis = new SistemaDeRecurso();
		
		assertFalse(sis.isLogado());
		assertThrows(RuntimeException.class, () -> sis.modificar());
		
		sis.login("adm", "123");
		sis.acessar();
		assertEquals("REC1 modificado", sis.modificar());
		
		sis.acessar();
		assertEquals("REC2 modificado", sis.modificar());
		
	}
	
	@Test
	void Teste3() {
		SistemaDeRecurso sis = new SistemaDeRecurso();
		
		assertFalse(sis.isLogado());
		assertThrows(RuntimeException.class, () -> sis.acessar());
		assertThrows(RuntimeException.class, () -> sis.modificar());
		assertFalse(sis.login("admin", "123"));
		
	}

}
