package modelos;


public class Compras {

	private int Id_compra;
	private String data_compra;
	private int hora_compra;
	private String opcao_pagamento;

	Usuarios usuario;
	Pacotes pacote;

	public Compras() {
	}

	public Compras(int id_compra, String data_compra, int hora_compra, String opcao_pagamento, Usuarios usuario,
			Pacotes pacote) {
		Id_compra = id_compra;
		this.data_compra = data_compra;
		this.hora_compra = hora_compra;
		this.opcao_pagamento = opcao_pagamento;
		this.usuario = usuario;
		this.pacote = pacote;
	}

	public Compras(String data_compra, int hora_compra, String opcao_pagamento, Usuarios usuario, Pacotes pacote) {
		this.data_compra = data_compra;
		this.hora_compra = hora_compra;
		this.opcao_pagamento = opcao_pagamento;
		this.usuario = usuario;
		this.pacote = pacote;
	}

	public int getId_compra() {
		return Id_compra;
	}

	public void setId_compra(int id_compra) {
		Id_compra = id_compra;
	}

	public String getData_compra() {
		return data_compra;
	}

	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}

	public int getHora_compra() {
		return hora_compra;
	}

	public void setHora_compra(int hora_compra) {
		this.hora_compra = hora_compra;
	}

	public String getOpcao_pagamento() {
		return opcao_pagamento;
	}

	public void setOpcao_pagamento(String opcao_pagamento) {
		this.opcao_pagamento = opcao_pagamento;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Pacotes getPacote() {
		return pacote;
	}

	public void setPacote(Pacotes pacote) {
		this.pacote = pacote;
	}

	@Override
	public String toString() {
		return "Compras [Id_compra=" + Id_compra + ", data_compra=" + data_compra + ", hora_compra=" + hora_compra
				+ ", opcao_pagamento=" + opcao_pagamento + ", usuario=" + usuario + ", pacote=" + pacote + "]";
	}


}
