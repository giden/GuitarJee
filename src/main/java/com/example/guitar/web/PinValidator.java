package com.example.guitar.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("pinValidator")
public class PinValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		String id = (String) value;
		if (id.length() != 3 ) {
			FacesMessage message = new FacesMessage();
			message.setDetail("PIN musi składać się z 3 znakow");
			message.setSummary("PIN musi składać się z 3 znakow");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
		if (!Character.isLetter(id.charAt(0))) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Pierwszy znak PINu musi być literą");
			message.setSummary("Pierwszy znak PINu musi być literą");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}
