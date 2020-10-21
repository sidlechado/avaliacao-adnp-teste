package questao01;

import java.util.ArrayList;

public class Resolvedor {
	private ClienteRepo repo;

	public Resolvedor(ClienteRepo repo) {
		this.repo = repo;
	}

	public ArrayList<Cliente> definirPromocao(int[] cods) throws Exception {
		/* 1 */ if (cods == null || cods.length == 0)
			/* 2 */
			/* 3 */throw new IllegalArgumentException("sem codigo");
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		/* 4 */for (int cod : cods) {
			/* 5 */Cliente c = repo.getCliente(cod);
			/* 6 */if (c == null)
				/* 7 */throw new Exception("Codigo do cliente invalido");
			/* 8 */clientes.add(c);
		}
		ArrayList<Cliente> resposta = new ArrayList<Cliente>();
		/* 9 */if (clientes.size() >= 3) {
			// todos ganham 20% de desconto
			/* 10 */ for (Cliente c : clientes) {
				/* 11 */c.setDesconto(20);
				resposta.add(c);
			}
		} else {
			// o 1º cliente ganha 10%
			/* 12 */clientes.get(0).setDesconto(10);
			resposta.add(clientes.get(0));
			// e, se existir, o 2º ganha 7%
			/* 13 */if (clientes.size() > 1) {
				/* 14 */clientes.get(1).setDesconto(7);
				resposta.add(clientes.get(1));
			}
		}
		/* 15 */return resposta;
	}
}
