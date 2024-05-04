package org.tukorea.di.persistence;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class MemberDAOTest{

    @Autowired
    MemberService memberService;

    @Test
    public void testReadMember() throws Exception {
        StudentVO member = memberService.readMember("hansol");
        System.out.println(member);
    }

    @Test
    public void testAddMember() throws Exception {
        String strID = "aaa";
        StudentVO studentVO = new StudentVO();
        studentVO.setId(strID);
        studentVO.setPasswd("aaa");
        studentVO.setUsername("aaa");
        studentVO.setSnum("aaa");
        memberService.addMember(studentVO);
        StudentVO studentVO1 = memberService.readMember("aaa");
        System.out.println(studentVO1.getId());
    }

    @Test
    public void testUpdateMember() throws Exception {
        String strID = "aaa";
        StudentVO studentVO = new StudentVO();
        studentVO.setId(strID);
        studentVO.setPasswd("1234");
        studentVO.setUsername("1234");
        studentVO.setSnum("2");
        memberService.updateStudent(studentVO);
        StudentVO studentVO1 = memberService.readMember("aaa");
        System.out.println(studentVO1.toString());
    }
}