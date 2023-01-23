package de.northcodes.course.jsfspring.bean;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.northcodes.course.jsfspring.model.User;
import de.northcodes.course.jsfspring.service.UserService;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

@ViewScoped
@Component
@ManagedBean
public class UserDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private UserService userService;

	private User user;

	public User getUser() {
		return user;
	}

	public void onload() {
		user = userManager.isSignedIn() ? userManager.getCurrentUser() : new User();
	}

	public String submit() {
		return userManager.save(user);
	}

	public void validateEmail(FacesContext context, UIComponent component, Object value) {
		String emailAddress = (String) value;
		String regexPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
				+ "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		if (
				emailAddress == null || 
				emailAddress.isEmpty() || 
				!emailAddress.contains("@") || 
				!emailAddress.contains(".") ||
				!patternMatches(emailAddress, regexPattern)		||
				(!isUserOwnEmailAddress(emailAddress) && userService.isEmailAlreadyExisting(emailAddress))
			) {
			throw new ValidatorException(new FacesMessage("Please enter a valid e-mail address."));
		}
	}
	public static boolean patternMatches(String emailAddress, String regexPattern) {
		return Pattern.compile(regexPattern)
				.matcher(emailAddress)
				.matches();
	}
	private boolean isUserOwnEmailAddress(String emailAddress) {
		return user.getEmailAddress() != null && user.getEmailAddress().equals(emailAddress);
	}

	public void validatePhoneNumber(FacesContext context, UIComponent component, Object value) {
		String phoneNumber = (String) value;
		if (phoneNumber == null || phoneNumber.isEmpty()
				|| !( Pattern.compile("[0-9]{4}-[0-9]{7}").matcher(phoneNumber).matches()
				      || Pattern.compile("[0-9]{11}").matcher(phoneNumber).matches())){
			throw new ValidatorException(
					new FacesMessage("Please enter a valid phone number of the form: 0123-1234567 or 01231234567."));
		}
	}
	
	public void validateBirthDate(FacesContext context, UIComponent component, Object value) {
		Date birthDate = (Date) value;
		if (birthDate == null || !birthDate.before(new Date())) {
			throw new ValidatorException(new FacesMessage("Please enter a valid birth date."));
		}
	}
}
