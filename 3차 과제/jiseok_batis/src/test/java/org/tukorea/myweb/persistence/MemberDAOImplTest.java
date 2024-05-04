package org.tukorea.myweb.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.tukorea.myweb.domain.StudentVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOImplTest {

    @Autowired
    private MemberDAO dao;
    private static Logger logger = LoggerFactory.getLogger(MemberDAOImplTest.class);

    @Test
    public void testReadByid() throws Exception {
        StudentVO vo;
        vo = dao.read("hansol");

        logger.info(vo.toString());
    }
    @Test
    public void testReadList() throws Exception {
        List<StudentVO> voList;
        voList = dao.readList();

        for(StudentVO svo : voList) {
            logger.info(svo.toString());
        }
    }

    @Test
    public void testAdd() throws Exception {
        StudentVO vo = new StudentVO();
        vo.setId("seok");
        vo.setPasswd("1234");
        vo.setUsername("seok");
        vo.setSnum("asdf");
        vo.setDepart("adsf");
        vo.setMobile("1234");
        vo.setEmail("asdf");

        dao.add(vo);
    }

}