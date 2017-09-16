package camel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Person implements Serializable {
	private String sex;
	private String name;
	private Date birthdate;
	private String postcode;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Person [sex=" + sex + ", name=" + name + ", birthdate=" + birthdate + ", postcode=" + postcode + "]";
	}

}
