package dao;

import vo.QuestionVO;

/**
 * @author: usingvc6
 * @description: question data access object
 */
public class QuestionDAO{
    public QuestionVO selectQuesionInputOutputById(String id) {
        return new QuestionVO("1\n1\n", "1\n");
    }
}
