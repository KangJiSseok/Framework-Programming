package org.tukorea.free.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.dto.PostDTO;
import org.tukorea.free.service.MemberService;
import org.tukorea.free.service.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private MemberService memberService;

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @GetMapping(value = "/newPost")
    public String newPostPage(){
        return "/NewPost";
    }

    @PostMapping(value = "/newPost")
    public String newPost(Model model, @ModelAttribute PostVO vo, HttpServletRequest request) throws Exception {
        logger.info("newPost");

        PostDTO postDTO = new PostDTO(request.getSession().getAttribute("id").toString(), vo.getPost_title(), vo.getPost_content());
        postService.add(postDTO);
        logger.info("저장완료");

        List<PostVO> postList = postService.postList();
        logger.info("postList = {}", postList.get(0).toString());

        model.addAttribute("postlist", postList);

        return "/Home";
    }

    @GetMapping(value = "/post")
    public String post(Model model, @RequestParam("post_num") String postNum) throws Exception {

        PostVO postVO = postService.read(postNum);
        String nick = memberService.readMember(postVO.getMem_id()).getNickname();
        model.addAttribute("post", postVO);
        model.addAttribute("nick", nick);

        return "/Post";

    }
}
