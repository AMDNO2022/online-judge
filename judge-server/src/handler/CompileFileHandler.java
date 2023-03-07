package handler;

/**
 * @author:        AMDNO2022
 * @description:   编译文件（仅支持java）
 */
public class CompileFileHandler {
    public static boolean compileJava(String id){
        try{
            FileHandler fileHandler = new FileHandler();
            Process process = Runtime.getRuntime().exec("javac " + fileHandler.idToFilePath(id));
            process.waitFor();
            process.destroy();
            if(!fileHandler.isClassFileExists(id)){
                return false;
            }
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
