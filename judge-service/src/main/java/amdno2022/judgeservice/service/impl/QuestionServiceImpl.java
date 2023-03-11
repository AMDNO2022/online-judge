package amdno2022.judgeservice.service.impl;

import amdno2022.judgeservice.dto.QuestionRow;
import amdno2022.judgeservice.mapper.QuestionMapper;
import amdno2022.judgeservice.mapper.RecordMapper;
import amdno2022.judgeservice.pojo.Question;
import amdno2022.judgeservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: AMDNO2022
 * @description: TODO
 */

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public int getPageSize() {
        return (int)(questionMapper.getQuestionRowCount() / 10.0) + 1;
    }

    @Override
    public List<QuestionRow> getQuestionListByPage(int userId, int page) {
        List<Question> questions = questionMapper.getQuestionIdNameByIndex(page * 10 - 10, page * 10 - 9);
        List<QuestionRow> questionRows = new LinkedList<>();
        for(int i = 0; i < questions.size(); i++){
            int questionId = questions.get(i).getQuestionId();
            String questionName = questions.get(i).getQuestionName();
            QuestionRow questionRow = new QuestionRow();
            questionRow.setQuestionId(questionId);
            questionRow.setQuestionName(questionName);
            Integer status = recordMapper.getRecordStatusByUserIdQuestionId(userId, questionId);
            if(status != null){
                questionRow.setStatus(status.intValue());
            }else{
                questionRow.setStatus(1000);
            }
            questionRows.add(questionRow);
        }
        return questionRows;
    }
}
