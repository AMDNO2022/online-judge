package amdno2022.judgeservice.controller;

import amdno2022.judgeservice.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: AMDNO2022
 * @description:
 */

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    @GetMapping("/pagesize")
    public ResponseEntity getPageSize(){

        return ResponseEntity.ok(questionService.getPageSize());
    }
    @GetMapping("/{page}")
    public ResponseEntity getQuestionsByPage(@PathVariable("page") int page, HttpServletRequest httpServletRequest){
        int userId = Integer.parseInt(httpServletRequest.getParameter("user_id"));
        return ResponseEntity.ok(questionService.getQuestionListByPage(userId, page));
    }
    @PostMapping("/submit")
    public ResponseEntity postSubmit(){
        return null;
    }
}
