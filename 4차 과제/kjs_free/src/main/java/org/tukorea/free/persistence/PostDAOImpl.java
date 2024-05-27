package org.tukorea.free.persistence;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.domain.StudentVO;
import org.tukorea.free.dto.PostDTO;
import org.tukorea.free.service.PostServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "org.tukorea.free.mapper.postMapper";

    private static final Logger logger = LoggerFactory.getLogger(PostDAOImpl.class);

    @Override
    public void add(PostDTO dto) throws Exception {
        logger.info("dao dto = {}", dto.toString());
        sqlSession.insert(namespace + ".postInsert", dto);
    }

    @Override
    public List<PostVO> postList() throws Exception {
        List<PostVO> postList = new ArrayList<>();
        postList = sqlSession.selectList(namespace + ".postSelectAll");
        return postList;
    }

    @Override
    public PostVO read(String postNum) throws Exception {
        logger.info("dao postNum = {}", postNum);
        PostVO vo = sqlSession.selectOne(namespace+".postSelectByid", postNum);
        return vo;
    }
}
