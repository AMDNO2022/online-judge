package runnable;

import constant.StatusConstants;
import handler.CompileFileHandler;
import dao.QuestionDAO;
import dao.RecordDAO;
import handler.ExecuteFileHandler;
import handler.FileHandler;
import vo.QuestionVO;
import vo.RecordVO;

/**
 * @author:        AMDNO2022
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
            questionDAO.initialize();
            recordDAO.initialize();

            RecordVO recordVO = new RecordVO(Integer.parseInt(recordId), StatusConstants.TODO);

            if(!CompileFileHandler.compileJava(recordId)){
                recordVO.setStatus(StatusConstants.COMPILEERROR);
            }else{
                QuestionVO questionVO = questionDAO.selectQuesionInputOutputById(Integer.parseInt(questionId));
                final int result = ExecuteFileHandler.executeJava(recordId, questionVO.getQuestionInput(), questionVO.getQuestionOutput());
                recordVO.setStatus(result);
            }
            recordDAO.undateRecordById(recordVO);
            questionDAO.destory();
            recordDAO.destory();
        }catch (Exception e){
            e.printStackTrace();
        }
        //delete file anyway
        FileHandler.deleteFile(recordId);
    }
}
