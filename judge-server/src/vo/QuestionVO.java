package vo;

/**
 * @author:        AMDNO2022
 * @description:   Question value object
 */
public class QuestionVO {

    String questionInput;
    String questionOutput;
    public QuestionVO(String input, String output){
        questionInput = input;
        questionOutput = output;
    }
    public String getQuestionInput(){
        return questionInput;
    }
    public String getQuestionOutput(){
        return questionOutput;
    }
}
