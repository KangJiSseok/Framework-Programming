package org.tukorea.myweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tukorea.myweb.domain.StudentVO;
import org.tukorea.myweb.service.MemberService;

@RestController
@RequestMapping(value = "/member/rest")
public class MemberRestController {

    @Autowired
    private MemberService memberService;

    private static final Logger logger = LoggerFactory.getLogger(MemberRestController.class);
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String readMember(@PathVariable("id") String id) throws Exception {
        logger.info(id);

        StudentVO studentVO = memberService.readMember(id);

        ObjectMapper mapper = new ObjectMapper();

        String voMapper = mapper.writeValueAsString(studentVO);

        return voMapper;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addMember(@RequestBody StudentVO vo) throws Exception {
        logger.info(vo.getId());
        memberService.addMember(vo);
        return "OK";
    }
}
