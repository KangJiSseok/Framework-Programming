package org.tukorea.free.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.free.domain.StudentVO;
import org.tukorea.free.dto.Message;
import org.tukorea.free.persistence.MemberDAO;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public StudentVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}
	
	public List<StudentVO> readMemberList() throws Exception{
		return memberDAO.readList();
	}
	
	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}
	
	public void deleteMember(String id) throws Exception {
		memberDAO.delete(id);
	}
	
	public void updateMember(StudentVO student) throws Exception {
		memberDAO.update(student);
	}

	public StudentVO login(String id, String passwd) throws Exception {
		StudentVO vo = memberDAO.read(id);

		if (vo.getPasswd().equals(passwd)) {
			return vo;
		}
		else{
			return null;
		}
	}

}
