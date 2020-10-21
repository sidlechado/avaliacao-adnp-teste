package questao05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class questao05 {

	@Test
	void Mutante1() {
		Original o = new Original();
		Mutante1 mutante = new Mutante1();
		
		//1988 e 1992 bissextos, 3 nao é bissexto
		int[] arr = {1988, 1992, 3};
		
		assertEquals(2, o.calcularAnosBissexto(arr));
		assertEquals(2, mutante.calcularAnosBissexto(arr));
		
		// Mutante foi morto, pois deveria retornar 2 e retornou 0
	}
	
	@Test
	void Mutante2() {
		Original o = new Original();
		Mutante2 mutante = new Mutante2();
		
		// 1988 e 1992 bissextos, 3 nao é bissexto
		int[] arr = {1988, 1992, 3};
		
		assertEquals(2, o.calcularAnosBissexto(arr));
		assertEquals(2, mutante.calcularAnosBissexto(arr));
		
		// Mutante foi morto, pois deveria retornar 2 e retornou 3
	}
	
	@Test
	void Mutante3() {
		Original o = new Original();
		Mutante3 mutante = new Mutante3();
		
		int[] arr = {1988, 1992, 1360};
		
		assertEquals(3, o.calcularAnosBissexto(arr));
		assertEquals(3, mutante.calcularAnosBissexto(arr));
		
		/* Mutante equivalente, pois todo número que for % 400 == também será por % 40
		 * logo, a primeira condicao é igual, e a segunda nao houve mudanca, fazendo com que todos numeros que sejam
		 * verdadeiros pra um, serao para o outro.
		 */
	}

}
