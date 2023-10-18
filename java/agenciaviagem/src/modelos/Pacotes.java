package modelos;

public class Pacotes {

	private int Id_pacote;
	private float Preco_pacote;
	private String Nome_pacote;

	public Pacotes() {
	}

	public Pacotes(int id_pacote, float preco_pacote, String nome_pacote) {
		Id_pacote = id_pacote;
		Preco_pacote = preco_pacote;
		Nome_pacote = nome_pacote;
	}

	public Pacotes(float preco_pacote, String nome_pacote) {
		Preco_pacote = preco_pacote;
		Nome_pacote = nome_pacote;
	}

	public int getId_pacote() {
		return Id_pacote;
	}

	public void setId_pacote(int id_pacote) {
		Id_pacote = id_pacote;
	}

	public float getPreco_pacote() {
		return Preco_pacote;
	}

	public void setPreco_pacote(float preco_pacote) {
		Preco_pacote = preco_pacote;
	}

	public String getNome_pacote() {
		return Nome_pacote;
	}

	public void setNome_pacote(String nome_pacote) {
		Nome_pacote = nome_pacote;
	}

	@Override
	public String toString() {
		return "Pacotes [Id_pacote=" + Id_pacote + ", Preco_pacote=" + Preco_pacote + ", Nome_pacote=" + Nome_pacote
				+ "]";
	}

}
