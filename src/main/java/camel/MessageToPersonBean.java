package camel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.camel.Handler;
import org.apache.commons.lang3.StringUtils;

public class MessageToPersonBean {
	
	@Handler
	public Person deserialize(String msg) throws ParseException {
		Person person = new Person();
		person.setSex(msg.substring(0, 1));
		person.setName(StringUtils.trim(msg.substring(1, 20)));
		person.setBirthdate(new SimpleDateFormat("ddMMyy").parse(msg.substring(20, 26)));
		person.setPostcode(msg.substring(26, 30));
		return person;
	}

}
