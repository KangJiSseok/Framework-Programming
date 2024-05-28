package org.tukorea.free.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.dto.PostDTO;
import org.tukorea.free.persistence.PostDAO;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class PostServiceImplTest extends TestCase {


    @Autowired
    private PostDAO postDAO;

    @Test
    public void read() throws Exception {

        PostVO post = postDAO.read("1");

        System.out.println(post.toString());
    }

    @Test
    public void postList() throws Exception {
        List<PostVO> postList = postDAO.postList();

        // postList가 비어 있는지 확인
        if (!postList.isEmpty()) {
            // List 안의 각각의 PostVO 객체에 접근하여 작업 수행
            for (PostVO post : postList) {
                System.out.println(post.toString());
            }
        } else {
            System.out.println("포스트 리스트가 비어 있습니다.");
        }
    }

    @Test
    public void MyPostList() throws Exception {
        List<PostVO> postList = postDAO.MyPostList("2");

        // postList가 비어 있는지 확인
        if (!postList.isEmpty()) {
            // List 안의 각각의 PostVO 객체에 접근하여 작업 수행
            for (PostVO post : postList) {
                System.out.println(post.toString());
            }
        } else {
            System.out.println("포스트 리스트가 비어 있습니다.");
        }
    }

    @Test
    public void add() throws Exception {
        PostDTO dto = new PostDTO("10", "10", "10");
        postDAO.add(dto);

    }


}