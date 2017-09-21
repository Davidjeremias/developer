package br.com.u2d.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.u2d.dao.EnderecoDao;
import br.com.u2d.model.Endereco;

@ManagedBean(name = "enderecoBean")
@SessionScoped
public class EnderecoBean {
	private Endereco endereco = new Endereco();
	private EnderecoDao enderecoDao = new EnderecoDao();
	
	public String AddEndereco() {
		enderecoDao.Salvar(endereco);
		return "sucesso";
	}
	
	public String RemoveEndereco() {
		enderecoDao.Excluir(endereco);
		return "sucesso";
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
