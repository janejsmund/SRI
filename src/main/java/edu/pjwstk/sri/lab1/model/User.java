package edu.pjwstk.sri.lab1.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class User implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 1, max = 25, message = "1-25 letters and spaces")
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	@Column(name = "full_name")
	private String login;

	@NotNull
	@Size(min = 5, max = 25, message = "5-25 letters and spaces")
	@Pattern(regexp = "[^\\s]*", message = "Must not contain whitespaces")
	@Column(name = "password")
	private String password;

	@NotNull
	@Size(min = 10, max = 12, message = "10-12 Numbers")
	@Digits(fraction = 0, integer = 12, message = "Not valid")
	@Column(name = "phone_number")
	private String phoneNumber;

	@NotNull
	@Column(name = "birth_date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@NotNull
	@Column(name = "update_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof User) {
			User user = (User) object;
			if(user.getId().equals(this.getId())
					&& user.getLogin().equals(this.getLogin())
					&& user.getPhoneNumber().equals(this.getPhoneNumber())
					&& user.getBirthDate().equals(this.getBirthDate())
					&& user.getUpdateDate().equals(this.getUpdateDate())) {
				return true;
			}	
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 23;
		
		result = 17 * result + this.getLogin().hashCode();
		result = 17 * result + this.getPassword().hashCode();
		result = 17 * result + this.getPhoneNumber().hashCode();
		result = 17 * result + this.getBirthDate().hashCode();
		result = 17 * result + this.getUpdateDate().hashCode();
		
		return result;
	}
}















