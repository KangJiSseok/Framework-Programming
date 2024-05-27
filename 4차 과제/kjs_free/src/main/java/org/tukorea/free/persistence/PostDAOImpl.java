package org.tukorea.free.persistence;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.dto.PostDTO;

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
        PostVO vo = sqlSession.selectOne(namespace+".postSelectByid", postNum);
        return vo;
    }

    @Override
    public List<PostVO> MyPostList(String memId) throws Exception {
        List<PostVO> myPostList = new ArrayList<>();
        myPostList = sqlSession.selectList(namespace + ".myPostList", memId);
        return myPostList;
    }

    @Override
    public void postUpdate(PostVO post) throws Exception {
        sqlSession.update(namespace + ".postUpdate", post);
    }


}
