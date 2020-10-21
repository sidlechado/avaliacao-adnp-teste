package questao04;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class questao04 {
	Autenticacao auth = new Autenticacao();
	
	@Test
	void c1() {
		Usuario usuario = new Usuario("", "123567", "admin");
		assertEquals("e-mail/senha não podem ser vazio.", auth.login(usuario));
	}
	
	@Test
	void c2() {
		Usuario usuario = new Usuario("sid@sid.com", "", "admin");
		assertEquals("e-mail/senha não podem ser vazio.", auth.login(usuario));
	}
	
	@Test
	void c3() {
		Usuario usuario = new Usuario("t@teste@teste.com", "123567", "admin");
		assertEquals("e-mail fora do formato", auth.login(usuario));
	}
	
	@Test
	void c4() {
		Usuario usuario = new Usuario("t@teste.com", "123", "admin");
		assertEquals("a senha tem ao menos 4 caracteres", auth.login(usuario));
	}
	
	@Test
	void c5() {
		Usuario bd = mock(Usuario.class);
		Usuario usuario = new Usuario("teste@teste.com", "123456", "admin");
		
		when(bd.getEmail())
			.thenReturn("teste123@teste123.com");
		
		assertNotEquals(usuario.getEmail(), bd.getEmail());
		assertEquals("usuario nao existe", auth.login(usuario));
	}
	
	@Test
	void c6() {
		Usuario bd = mock(Usuario.class);
		Usuario usuario = new Usuario("teste@teste.com", "123456", "admin");
		
		when(bd.getSenha())
			.thenReturn("1010120");
		
		assertNotEquals(usuario.getSenha(), bd.getSenha());
		assertEquals("senha incorreta", auth.login(usuario));
	}
	
	@Test
	void c7() {
		Usuario bd = mock(Usuario.class);
		Usuario usuario = new Usuario("teste@teste.com", "123456", "admin");
		
		when(bd.getEmail())
			.thenReturn("teste@teste.com");
		when(bd.getSenha())
			.thenReturn("123456");
		
		assertEquals(usuario.getEmail(), bd.getEmail());
		assertEquals(usuario.getSenha(), bd.getSenha());
		assertEquals("logado como admin", auth.login(usuario));
	}
	
	@Test
	void c8() {
		Usuario bd = mock(Usuario.class);
		Usuario usuario = new Usuario("teste@teste.com", "123456", "normal");
		
		when(bd.getEmail())
			.thenReturn("teste@teste.com");
		when(bd.getSenha())
			.thenReturn("123456");
		
		assertEquals(usuario.getEmail(), bd.getEmail());
		assertEquals(usuario.getSenha(), bd.getSenha());
		assertEquals("logado", auth.login(usuario));
	}

}
