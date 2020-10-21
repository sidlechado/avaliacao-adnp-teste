package questao03;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class questao03 {

	@Test
	void testeVotoObrigatorio() throws Exception {
		CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
		VerificadorEleitoral ver = new VerificadorEleitoral(cartorioMock);
		
		int idade = 25;
		String cpf = "12345678910";
		
		when(cartorioMock.verificar(cpf)).thenReturn("OK");
		String res = ver.consultarSituacao(idade, cpf);
			
		assertEquals("voto obrigatório", res);
	}
	
	@Test
	void testeVotoFacultativo() throws Exception {
		CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
		VerificadorEleitoral ver = new VerificadorEleitoral(cartorioMock);
		
		int idade = 16;
		String cpf = "12345678910";
		
		when(cartorioMock.verificar(cpf)).thenReturn("OK");
		String res = ver.consultarSituacao(idade, cpf);
			
		assertEquals("voto facultativo", res);
	}
	
	@Test
	void testePendencia() throws Exception {
		CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
		VerificadorEleitoral ver = new VerificadorEleitoral(cartorioMock);
		
		int idade = 25;
		String cpf = "12345678910";
		
		when(cartorioMock.verificar(cpf)).thenReturn("pendencia");
		String res = ver.consultarSituacao(idade, cpf);
			
		assertEquals("regularize seu titulo", res);
	}
	
	@Test
	void testeMenorIdade() throws Exception {
		CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
		VerificadorEleitoral ver = new VerificadorEleitoral(cartorioMock);
		
		int idade = 15;
		String cpf = "12345678910";
		
		String res = ver.consultarSituacao(idade, cpf);
			
		assertEquals("nao pode votar", res);
	}
	
	@Test
	void testeVotoFacaTitulo() throws Exception {
		CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
		VerificadorEleitoral ver = new VerificadorEleitoral(cartorioMock);
		
		int idade = 25;
		String cpf = "12345678910";
		
		when(cartorioMock.verificar(cpf)).thenReturn("nao existe");
		String res = ver.consultarSituacao(idade, cpf);
			
		assertEquals("faca um titulo", res);
	}
	
	@Test
	void testeExceptionIdade() throws Exception {
		CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
		VerificadorEleitoral ver = new VerificadorEleitoral(cartorioMock);
		
		int idade = 0;
		String cpf = "12345678910";
		
		assertThrows(Exception.class, () -> ver.consultarSituacao(idade, cpf));
	}

	
	@Test
	void testeExceptionCPFNaoNumerico() throws Exception {
		CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
		VerificadorEleitoral ver = new VerificadorEleitoral(cartorioMock);
		
		int idade = 25;
		String cpf = "123456abcde";
		
		assertThrows(Exception.class, () -> ver.consultarSituacao(idade, cpf));
	}
	
	
	@Test
	void testeValorLimiteCPF() throws Exception {
		CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
		VerificadorEleitoral ver = new VerificadorEleitoral(cartorioMock);
		
		int idade = 25;
		String cpfTam10 = "1234567890";
		String cpfTam12 = "12345679012";
		
		assertThrows(Exception.class, () -> ver.consultarSituacao(idade, cpfTam10));
		assertThrows(Exception.class, () -> ver.consultarSituacao(idade, cpfTam12));
		
	}
	
	@Test
	void testeValorLimiteIdade() throws Exception {
		CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
		VerificadorEleitoral ver = new VerificadorEleitoral(cartorioMock);
		
		int idade1 = 0;
		int idade2 = 200;
		String cpf = "12345678910";
		
		assertThrows(Exception.class, () -> ver.consultarSituacao(idade1, cpf));
		assertThrows(Exception.class, () -> ver.consultarSituacao(idade2, cpf));
		
	}
}
