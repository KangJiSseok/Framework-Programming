package org.tukorea.free.persistence;

import org.tukorea.free.domain.PostVO;
import org.tukorea.free.domain.StudentVO;
import org.tukorea.free.dto.PostDTO;

import java.util.List;

public interface PostDAO {

	public void add(PostDTO dto) throws Exception;

	public List<PostVO> postList() throws Exception;

	public PostVO read(String postNum) throws Exception;
}
