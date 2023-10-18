package modelos;

public class Usuarios {
	private int Id;
	private int Cpf;
	private String Email;
	private String Nome;
	private String Senha;

	public Usuarios() {
	}

	public Usuarios(int id, int cpf, String email, String nome, String senha) {
		Id = id;
		Cpf = cpf;
		Email = email;
		Nome = nome;
		Senha = senha;
	}

	public Usuarios(int cpf, String email, String nome, String senha) {
		Cpf = cpf;
		Email = email;
		Nome = nome;
		Senha = senha;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCpf() {
		return Cpf;
	}

	public void setCpf(int cpf) {
		Cpf = cpf;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	@Override
	public String toString() {
		return "Usuarios [Id=" + Id + ", Cpf=" + Cpf + ", Email=" + Email + ", Nome=" + Nome + ", Senha=" + Senha + "]";
	}
	
}