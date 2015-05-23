package com.example.guitar.web;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.example.guitar.web.PersonConverter")
public class PersonConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent component, String value) {
		
		StringBuilder user = new StringBuilder();
		if(value.endsWith("a")){
		user.append("Pani ");
		}
		else{
			user.append("Pan ");
		}
		user.append(value);
	
		PersonFormBean.setName(user.toString());
		
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent component, Object value) {
		return value.toString();
	}

}
