package sc.senac.br.cadastropessoa.bean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import sc.senac.br.cadastropessoa.dao.IBaseDao;
import sc.senac.br.cadastropessoa.model.Profession;

@Named
public class ProfessionConverter implements Converter {

	@Inject
	private IBaseDao<Profession> dao;


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Profession retorno = null;
		if (value != null) {
			Long id = new Long(value);
			retorno = dao.buscarPorID(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Profession) value).getId().toString();
		}
		return "";
	}

}
