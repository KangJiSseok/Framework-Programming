package org.tukorea.free.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.dto.PostDTO;
import org.tukorea.free.persistence.PostDAO;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostDAO postDAO;

    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    @Transactional
    public void add(PostDTO dto) throws Exception {
        postDAO.add(dto);
    }

    @Transactional(readOnly = true)
    public List<PostVO> postList() throws Exception{
        return postDAO.postList();
    }

    @Override
    @Transactional(readOnly = true)
    public PostVO read(String postNum) throws Exception {
        return postDAO.read(postNum);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostVO> MyPostList(String memId) throws Exception {
        return postDAO.MyPostList(memId);
    }

    @Transactional
    @Override
    public void postUpdate(PostVO post) throws Exception {
        logger.info("post = {}", post.toString());
        postDAO.postUpdate(post);
    }

    @Override
    public void postDelete(String post_num) throws Exception {
        postDAO.postDelete(post_num);
    }


}
