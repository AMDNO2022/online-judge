package amdno2022.judgeservice.service;

import amdno2022.judgeservice.dto.QuestionRow;
import amdno2022.judgeservice.pojo.Question;

import java.util.List;

/**
 * @author: AMDNO2022
 * @description: TODO
 */
public interface QuestionService {

    int getPageSize();

    List<QuestionRow> getQuestionListByPage(int userId, int page);
}
