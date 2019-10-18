package sc.senac.br.cadastropessoa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import sc.senac.br.cadastropessoa.bean.util.MessageUtil;
import sc.senac.br.cadastropessoa.dao.IBaseDao;
import sc.senac.br.cadastropessoa.model.Profession;
import sc.senac.br.cadastropessoa.model.User;

@Named("user")
@RequestScoped
public class CadastroUserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	private User userDelete;
	@Inject
	private IBaseDao<User> daoUser;
	@Inject
	private IBaseDao<Profession> daoProfession;
	private List<User> users;
	private List<User> userFilters;
	private String senha2;
	private List<Profession> professions;
	private Profession profession;

	@PostConstruct
	public void init() {
		user = new User();
		users = daoUser.buscarTodos();
		profession = new Profession();
		professions = daoProfession.buscarTodos();
	}

	private void refresh() {
		user = new User();
		users = daoUser.buscarTodos();
	}

	public void add() {
		daoUser.saveOrUpdate(user);
		refresh();
		MessageUtil.info("Salvo com Sucesso!");
	}

	public void delete() {
		daoUser.excluir(user);
		refresh();
		MessageUtil.info("Excluido com Sucesso!");
	}

	public void editar() {
		daoUser.alterar(user);
	}

	public void limpar() {
		user = new User();
	}


	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public List<Profession> getProfessions() {
		return professions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User pessoa) {
		this.user = pessoa;
	}

	public List<User> getUsers() {
		return users;
	}

	public List<User> getUsersFilter() {
		return userFilters;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public List<User> getUserFilters() {
		return userFilters;
	}

	public void setUserFilters(List<User> userFilters) {
		this.userFilters = userFilters;
	}

	public User getUserDelete() {
		return userDelete;
	}

	public void setUserDelete(User userDelete) {
		this.userDelete = userDelete;
	}

}
