package br.com.u2d.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.u2d.dao.EnderecoDao;
import br.com.u2d.dao.PessoaDao;
import br.com.u2d.model.Endereco;
import br.com.u2d.model.Pessoa;

@ManagedBean(name = "pessoaBean")
@SessionScoped
public class PessoaBean {
	
	private Pessoa pessoa = new Pessoa();
	private Endereco endereco = new Endereco();
	private PessoaDao pessoaDao = new PessoaDao();
	private EnderecoDao enderecoDao = new EnderecoDao();
	
	public String AddPessoa() {
		enderecoDao.Salvar(endereco);
		pessoaDao.Salvar(pessoa);
		return "sucesso";
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public String RemovePessoa() {
		pessoaDao.Excluir(pessoa);
		return "sucesso";
	}
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
