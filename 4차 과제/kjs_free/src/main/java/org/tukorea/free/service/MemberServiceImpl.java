package org.tukorea.free.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.free.domain.StudentVO;
import org.tukorea.free.persistence.MemberDAO;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Transactional(readOnly = true)
	public StudentVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}

	@Transactional(readOnly = true)
	public List<StudentVO> readMemberList() throws Exception{
		return memberDAO.readList();
	}

	@Transactional
	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}

	@Transactional
	public void deleteMember(String id) throws Exception {
		memberDAO.delete(id);
	}

	@Transactional
	public void updateMember(StudentVO student) throws Exception {
		memberDAO.update(student);
	}

	@Transactional(readOnly = true)
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
