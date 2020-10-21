package questao03;

public class VerificadorEleitoral {
	private CartorioEleitoral cartorioEleitoral;

	public VerificadorEleitoral(CartorioEleitoral cartorioEleitoral) {
		this.cartorioEleitoral = cartorioEleitoral;
	}

	public String consultarSituacao(int idade, String cpf) throws Exception {
		String res = this.cartorioEleitoral.verificar(cpf);
		if(idade <= 0 || idade >= 200) throw new Exception();
		
		if (!(cpf.matches("[0-9]+") || cpf.length() != 11)) throw new Exception();
		
		if(idade < 16) return "nao pode votar";
		
		
		if(res.equals("OK")) {
			if((idade == 16 || idade == 17) || idade > 70) return "voto facultativo";
			else return "voto obrigatório";
		} else if(res.equals("nao existe")) return "faca um titulo";
		else return "regularize seu titulo";
		
	}
}
