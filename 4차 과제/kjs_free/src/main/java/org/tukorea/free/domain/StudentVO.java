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
}
