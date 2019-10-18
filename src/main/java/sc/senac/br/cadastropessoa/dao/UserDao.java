package sc.senac.br.cadastropessoa.dao;

import java.io.Serializable;

import sc.senac.br.cadastropessoa.model.User;

public class UserDao extends BaseDao<User> implements Serializable {
	private static final long serialVersionUID = 1L;

	public UserDao() {
		super(User.class);
	}
}
