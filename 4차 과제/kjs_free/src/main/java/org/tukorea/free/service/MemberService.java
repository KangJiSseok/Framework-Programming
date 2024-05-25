package org.tukorea.free.service;

import org.tukorea.free.domain.StudentVO;
import org.tukorea.free.dto.Message;

import java.util.List;

public interface MemberService {
	
	public StudentVO readMember(String id) throws Exception;
	public List<StudentVO> readMemberList() throws Exception;
	public void addMember(StudentVO student) throws Exception;
	public void deleteMember(String id) throws Exception; 
	public void updateMember(StudentVO student) throws Exception;

	public StudentVO login(String id, String passwd) throws Exception;
}
