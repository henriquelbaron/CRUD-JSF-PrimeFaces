package sc.senac.br.cadastropessoa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import sc.senac.br.cadastropessoa.dao.IBaseDao;
import sc.senac.br.cadastropessoa.model.Profession;

@Named("profession")
@RequestScoped
public class CadastroProfessionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IBaseDao<Profession> daoProfession;
	private List<Profession> professions;
	private Profession profession;

	@PostConstruct
	public void init() {
		refresh();
	}

	private void refresh() {
		profession = new Profession();
		professions = daoProfession.buscarTodos();
	}

	private void message(String message) {
		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		mensagem.setSummary(message);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);

	}

	public void add() {
		daoProfession.saveOrUpdate(profession);
		refresh();
		message("Salvo com Sucesso!");
	}

	public void delete() {
		daoProfession.excluir(profession);
		refresh();
		message("Excluido com Sucesso!");
	}

	public void editar() {
		daoProfession.alterar(profession);
	}

	public void limpar() {
		profession = new Profession();
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

}
