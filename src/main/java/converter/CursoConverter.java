package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import dao.CursoDao;
import models.Curso;

@FacesConverter("cursoConerverter")
public class CursoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) throws RuntimeException {
		try {
			Long codigo = Long.parseLong(valor);
			CursoDao cursoDao = new CursoDao();
			Curso curso = cursoDao.selecionar(codigo);
			return curso;
		} catch (Exception ex) {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try {
			Curso curso = (Curso) objeto;
			Long codigo = curso.getId();
			return codigo.toString();
		} catch (Exception ex) {
			return null;
		}
	}

}
