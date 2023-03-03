package vo;

/**
 * @author:        usingvc6
 * @description:   Question value object
 */
public class QuestionVO {
    String input;
    String output;
    public QuestionVO(String a, String b){
        input = a;
        output = b;
    }
    public String getInput(){
        return input;
    }
    public String getOutput(){
        return output;
    }
}
