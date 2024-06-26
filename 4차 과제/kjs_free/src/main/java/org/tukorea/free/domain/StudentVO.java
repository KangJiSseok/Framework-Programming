package org.tukorea.free.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO {

	private String id;
	private String passwd;
	private String nickname;
	private String email;

	public StudentVO(String id, String passwd, String nickname, String email) {
		this.id = id;
		this.passwd = passwd;
		this.nickname = nickname;
		this.email = email;
	}

	@Override
	public String toString() {
		return "StudentVO{" +
				"id='" + id + '\'' +
				", passwd='" + passwd + '\'' +
				", nickname='" + nickname + '\'' +
				", email='" + email + '\'' +
				'}';
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
