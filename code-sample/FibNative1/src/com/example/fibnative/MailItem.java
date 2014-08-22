package com.example.fibnative;

import java.io.Serializable;

public class MailItem implements Serializable{

	private static final long serialVersionUID = -7334724625702415322L;
	
	private String Subject;
	private String Body;
	private String to;

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	public String getTo() {
		return to;
	}

	@Override
	public String toString() {
		return "MailItem [Subject=" + Subject + ", Body=" + Body + ", to=" + to
				+ "]";
	}

	public void setTo(String to) {
		this.to = to;
	}

	public MailItem(String subject, String body, String to) {
		super();
		Subject = subject;
		Body = body;
		this.to = to;
	}

}
