package Controllers;

import java.util.List;

import DAO.UsuarioDAO;
import Models.Usuario;

public class UsuarioController {
	public Usuario criar(String email, String senha, String nivel){
		Usuario Usuario1 = new Usuario(email, senha, nivel);
		Usuario p = null;
		try {
			p = UsuarioDAO.getInstance().salvar(Usuario1);
			System.out.println("Salvo " + p.getEmail() + " com sucesso");
			return p;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar usuário!");
			return null;
		}
	}

	public List<Usuario> listar(){
		try {
			List<Usuario> l = UsuarioDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + l.size());
			return l;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar usuário(s)!");
			return null;
		}

	}

	public Usuario buscar(int id){
		Usuario b= null;
		try {
			b = UsuarioDAO.getInstance().buscar(id);
			System.out.println("Achado com sucesso: " + b);
			return b;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar usuário!");
			return null;
		}
	}

	public Usuario atualizar(int id, String email, String senha, String nivel){
		Usuario Usuario2 = new Usuario(email, senha, nivel);
		Usuario b = null;
		try {
			b = UsuarioDAO.getInstance().buscar(id);
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar usuário!");
			return null;
		}
		
		if (b==null) {
			System.out.println("Usuário não encontrada pelo ID");
			return null;
		}		
		
		Usuario2.setId(b.getId());
				
		try {
			Usuario a = UsuarioDAO.getInstance().atualizar(Usuario2);
			System.out.println("Atualizado com sucesso: " + a.getEmail());
			return a;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar usuário!");
			return null;
		}
	}

	public void deletar(int id){
		try {
			UsuarioDAO.getInstance().deletar(id);
			System.out.println("Excluído com sucesso");
		} catch (Exception e) {
			System.err.println("Erro ao excluir Usuario!");
		}
	}
}
