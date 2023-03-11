package amdno2022.judgeservice.pojo;

import lombok.Data;

/**
 * @author: AMDNO2022
 * @description: TODO
 */
@Data
public class Question {
    int questionId;
    String questionName;
    String questionDescription;
    String questionInput;
    String questionOutput;
    String questionTestInput;
    String questionTestOutput;
}
