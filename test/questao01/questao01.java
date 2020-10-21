package questao01;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class questao01 {

	@Test // 1 -> 3
	void CodNulo() throws Exception {
		ClienteRepo cr = mock(ClienteRepo.class);
		Resolvedor r = new Resolvedor(cr);
		
		int[] cod = null;
		assertThrows(IllegalArgumentException.class, () -> r.definirPromocao(cod));
	}
	
	@Test // 1 -> 2 -> 3
	void LenZero() throws Exception {
		ClienteRepo cr = mock(ClienteRepo.class);
		Resolvedor r = new Resolvedor(cr);
		
		int[] cod = new int[0];
		assertThrows(IllegalArgumentException.class, () -> r.definirPromocao(cod));
	}
	
	@Test // 1 -> 2 -> 4 -> 5 -> 6 -> 7
	void ClienteNulo() throws Exception {
		ClienteRepo cr = mock(ClienteRepo.class);
		Resolvedor r = new Resolvedor(cr);
		
		when(cr.getCliente(100)).thenReturn(null);
		
		int[] cod = {100};
		assertThrows(Exception.class, () -> r.definirPromocao(cod));
	}
	
	/* 1 -> 2 -> 4 -> 5 -> 6 -> 8 ->
	 * 4 -> 5 -> 6 -> 8 -> 4 -> 5 -> 6 -> 8 ->
	 * 9 -> 10 -> 11 -> 10 -> 11 -> 10 -> 11 -> 15
	 * */
	@Test
	void ListaMaior3() throws Exception {
		ClienteRepo cr = mock(ClienteRepo.class);
		Resolvedor r = new Resolvedor(cr);
		Cliente cli1 = new Cliente(100, "Sidnei L.");
		Cliente cli2 = new Cliente(200, "Sidnei A.");
		Cliente cli3 = new Cliente(300, "Sidnei J.");
		
		when(cr.getCliente(100)).thenReturn(cli1);
		when(cr.getCliente(200)).thenReturn(cli2);
		when(cr.getCliente(300)).thenReturn(cli3);
		
		int[] cod = {100, 200, 300};
		
		ArrayList<Cliente> resposta = r.definirPromocao(cod);
		assertEquals(20, resposta.get(0).getDesconto());
		assertEquals(20, resposta.get(1).getDesconto());
		assertEquals(20, resposta.get(2).getDesconto());
	}
	
	/* 1 -> 2 -> 4 -> 5 -> 6 -> 8 ->
	 * 4 -> 5 -> 6 -> 8 -> 9 -> 12 -> 13 -> 14 -> 15
	 */
	@Test
	void ListaMenor3() throws Exception {
		ClienteRepo cr = mock(ClienteRepo.class);
		Resolvedor r = new Resolvedor(cr);
		Cliente cli1 = new Cliente(100, "Sidnei L.");
		Cliente cli2 = new Cliente(200, "Sidnei A.");
		
		when(cr.getCliente(100)).thenReturn(cli1);
		when(cr.getCliente(200)).thenReturn(cli2);
		
		int[] cod = {100, 200};
		
		ArrayList<Cliente> resposta = r.definirPromocao(cod);
		assertEquals(10, resposta.get(0).getDesconto());
		assertEquals(7, resposta.get(1).getDesconto());
	}
	
	@Test // 1 -> 2 -> 4 -> 5 -> 6 -> 8 -> 9 -> 12 -> 13 -> 15
	void ListaIgual1() throws Exception {
		ClienteRepo cr = mock(ClienteRepo.class);
		Resolvedor r = new Resolvedor(cr);
		Cliente cli1 = new Cliente(100, "Sidnei L.");
		
		when(cr.getCliente(100)).thenReturn(cli1);
		
		int[] cod = {100};
		
		ArrayList<Cliente> resposta = r.definirPromocao(cod);
		assertEquals(10, resposta.get(0).getDesconto());
	}

}
