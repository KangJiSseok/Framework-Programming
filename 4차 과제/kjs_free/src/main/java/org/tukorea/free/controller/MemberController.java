package org.tukorea.free.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.domain.StudentVO;
import org.tukorea.free.service.MemberService;
import org.tukorea.free.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private PostService postService;
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    //	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    @GetMapping("/list")
    public String listMember(Model model) throws Exception {
        List<StudentVO> students = memberService.readMemberList();

        model.addAttribute("students", students);
        return "member/member_list";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String readMember(@RequestParam("id") String id, Model model) throws Exception {
        StudentVO student = memberService.readMember(id);

        model.addAttribute("student", student);
        return "member/member_read";
    }


    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyMemberGet(@RequestParam("id") String id, Model model) throws Exception {
        StudentVO student = memberService.readMember(id);

        model.addAttribute("student", student);
        return "member/member_modify";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyMemberPost(@ModelAttribute("student") StudentVO vo) throws Exception {
        memberService.updateMember(vo);
        return "redirect:/member/list";
    }


    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String createMemberGet() throws Exception {
        return "register";
    }

    @PostMapping("/register")
    public String createMemberPost(@ModelAttribute("student") StudentVO vo) throws Exception {
        memberService.addMember(vo);
        return "redirect:/member/Home";
    }

    @GetMapping("/Home")
    public String home(Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String id = null;
        if (session.getAttribute("id") != null) {
            id = session.getAttribute("id").toString();
        }
        if(id == null){
            return "/Home";
        }else{
            List<PostVO> postList = postService.postList();
            model.addAttribute("postlist", postList);
        }
        return "/Home";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "/Login";
    }

    @PostMapping(value = "login")
    public String login(@ModelAttribute("student") StudentVO vo, HttpServletRequest request) throws Exception {

        StudentVO student = memberService.login(vo.getId(), vo.getPasswd());

        if (student != null) {
            HttpSession session = request.getSession();
            session.setAttribute("id", student.getId());

            return "redirect:/member/Home";
        } else {
            return "redirect:/member/login";
        }
    }


    @GetMapping(value = "/myAccount")
    public String account(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        StudentVO member = memberService.readMember(session.getAttribute("id").toString());
        request.setAttribute("member", member);
        return "/MyAccount";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:/member/Home";
    }

    @GetMapping(value = "/update")
    public String updatePage(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        StudentVO member = memberService.readMember(session.getAttribute("id").toString());
        request.setAttribute("member", member);
        return "/MemberUpdate";
    }

    @PostMapping(value = "/update")
    public String update(Model model, @ModelAttribute("member") StudentVO vo) throws Exception {
        memberService.updateMember(vo);
        StudentVO member = memberService.readMember(vo.getId());
        model.addAttribute("member", member);
        return "/MyAccount";
    }

    @GetMapping(value = "/delete")
    public String delete(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);


        //session.removeAttribute("id");
        String strId = session.getAttribute("id").toString();
        memberService.deleteMember(strId);
        session.invalidate();
//        PostDAO postdao = PostDAO.getInstance();
//        ArrayList<PostVO> postList = postdao.getPostList();
//        ServletContext context = getServletContext();
//        context.setAttribute("postlist", postList);
        return "redirect:/member/Home";

    }
}
/*  MemberControllerAdvice에 예외처리 기능적용    
    @ExceptionHandler(DataNotFoundException.class)
    public String handleException(DataNotFoundException e) {
        return "member/not_found";
    }
*/
