package org.tukorea.free.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tukorea.free.domain.StudentVO;
import org.tukorea.free.service.MemberService;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class RestApi {

    @Autowired
    private MemberService memberService;

    private static final Logger logger = LoggerFactory.getLogger(RestApi.class);
    @GetMapping(value = "/memberList")
    public String rest() throws Exception {

        List<StudentVO> studentList = memberService.readMemberList();
        ObjectMapper mapper = new ObjectMapper();
        String voMapper = mapper.writeValueAsString(studentList);
        return voMapper;

    }

}
