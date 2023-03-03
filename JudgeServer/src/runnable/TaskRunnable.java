package runnable;

import constant.ResultStatus;
import handler.CompileFileHandler;
import dao.QuestionDAO;
import dao.RecordDAO;
import handler.ExecuteFileHandler;
import handler.FileHandler;
import vo.QuestionVO;

/**
 * @author:        usingvc6
 * @description:   消费者
 */

public class TaskRunnable implements Runnable{
    String recordId;
    String questionId;
    String code;

    public void setParam(String content){
        // 在后端传过来的数据中，前32位已被改为recordId，32-64位已被改为questionId
        // 64位以后的才是真正的代码，其中主函数入口类名已被改为'a' + recordId
        // 后端已做恶意代码检测
        recordId = content.substring(0, 32);
        questionId = content.substring(32, 64);
        code = content.substring(64);
    }

    @Override
    public void run() {
        try{
            FileHandler.makeFile(recordId, code);
            QuestionDAO questionDAO = new QuestionDAO();
            RecordDAO recordDAO = new RecordDAO();
            if(!CompileFileHandler.compileJava(recordId)){
                recordDAO.undateRecordById(recordId, ResultStatus.COMPILEERROR);
                return;
            }

            QuestionVO questionVO = questionDAO.selectQuesionInputOutputById(questionId);

            final int result = ExecuteFileHandler.executeJava(recordId, questionVO.getInput(), questionVO.getOutput());
            recordDAO.undateRecordById(recordId, result);

        }catch (Exception e){
            e.printStackTrace();
        }
        //delete file anyway
        FileHandler.deleteFile(recordId);
    }
}