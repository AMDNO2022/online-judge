package handler;

import constant.LocalConstants;
import constant.StatusConstants;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * @author:        AMDNO2022
 * @description:   执行文件（仅支持java）
 */
public class ExecuteFileHandler {
    public static int executeJava(String id, String input, String expectedResults){
        StringBuilder result = new StringBuilder();
        try{
            LocalConstants constants = LocalConstants.getInstance();
            //如果不设置classpath属性的话会导致运行a.class时报找不到类文件的错误
            Process process = Runtime.getRuntime().exec("cmd /c set CLASSPATH=" + constants.getFullPath() + " && java a" + id);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write(input);
            writer.close();

            boolean isTimeLimitNoExceeded = process.waitFor(constants.getMaxRunningTime(), TimeUnit.SECONDS);

            if(!isTimeLimitNoExceeded){
                process.destroy();
                return StatusConstants.TIMELIMITEXCEDDED;
            }

            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            //获得错误信息
            String errorMessage = errorReader.readLine();
            errorReader.close();
            if (errorMessage != null) {
                process.destroy();
                //后期可以添加更多错误的打印信息给用户
                return StatusConstants.RUNTIMEERROR;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            //获得执行结果，即执行文件System.out的内容
            while ((line = reader.readLine()) != null) {
                result.append(line + '\n');
            }
            reader.close();
            process.destroy();
        }catch(Exception e) {
            e.printStackTrace();
            return StatusConstants.RUNTIMEERROR;
        }
        if(result.toString().equals(expectedResults)){
            return StatusConstants.ACCEPT;
        }else{
            return StatusConstants.WRONGANSWER;
        }
    }
}
