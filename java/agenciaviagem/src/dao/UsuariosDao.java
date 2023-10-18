package dao;

import modelos.Usuarios;

public class UsuariosDao {

	public void create(Usuarios usuarios) {
		System.out.println(" *** CREATE ***");
	}

	public dao.ArrayList<Usuarios> read() {
		ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
		System.out.println(" *** READ ***");

		return usuarios;
	}

	public void update(Usuarios usuarios) {

		System.out.println(" *** UPDATE ***");
	}

	public void delete(int id) {
		System.out.println(" *** DELETE ***");
	}

	public Usuarios readeById(int id) {
		System.out.println(" *** DELETE ***");
		return new Usuarios();
	}
}
