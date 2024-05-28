package org.tukorea.free.controller;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.dto.PostDTO;
import org.tukorea.free.service.MemberService;
import org.tukorea.free.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String newPostPage() {
        return "/NewPost";
    }

    @PostMapping(value = "/newPost")
    public String newPost(Model model, @ModelAttribute PostVO vo, HttpServletRequest request) throws Exception {
        logger.info("newPost");

        PostDTO postDTO = new PostDTO(request.getSession().getAttribute("id").toString(), vo.getPost_title(), vo.getPost_content());
        try {
            postService.add(postDTO);
        }catch (DataIntegrityViolationException e){
            return "/error";
        }
        List<PostVO> postList = postService.postList();
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

    @GetMapping(value = "/myPost")
    public String myPost(Model model, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        if (session.getAttribute("id") != null) {
            model.addAttribute("mypostlist", postService.MyPostList(session.getAttribute("id").toString()));
            return "/MyPost";
        } else {
            return "redirect:/member/Home";
        }
    }


    @GetMapping(value = "/postUpdate")
    public String postUpdatePage(Model model, @RequestParam("post_num") String postNum) throws Exception {
        PostVO post = postService.read(postNum);
        model.addAttribute("post", post);
        return "/PostUpdate";
    }

    @PostMapping(value = "/postUpdate")
    public String postUpdate(Model model, @ModelAttribute PostVO vo) throws Exception {
        postService.postUpdate(vo);

        PostVO post = postService.read(String.valueOf(vo.getPost_num()));
        String nick = memberService.readMember(post.getMem_id()).getNickname();

        model.addAttribute("greetings", "수정 완료");
        model.addAttribute("post", post);
        model.addAttribute("nick", nick);

        return "/Post";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam("post_num") String post_num) throws Exception {
        postService.postDelete(post_num);

        return "redirect:/member/Home";
    }
}
