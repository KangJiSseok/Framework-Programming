package org.tukorea.free.service;

import org.tukorea.free.domain.PostVO;
import org.tukorea.free.dto.PostDTO;

import java.util.List;

public interface PostService {

    public void add(PostDTO dto) throws Exception;

    public List<PostVO> postList() throws Exception;

    public PostVO read(String postNum) throws Exception;


    public List<PostVO> MyPostList(String memId) throws Exception;

    public void postUpdate(PostVO post) throws Exception;
}
