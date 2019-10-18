package sc.senac.br.cadastropessoa.dao;

import java.io.Serializable;

import sc.senac.br.cadastropessoa.model.Profession;

public class ProfessionDao extends BaseDao<Profession> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ProfessionDao() {
		super(Profession.class);
	}
}
