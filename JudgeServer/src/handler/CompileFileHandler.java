package handler;

/**
 * @author:        usingvc6
 * @description:   编译文件（仅支持java）
 */
public class CompileFileHandler {
    public static boolean compileJava(String id){
        try{
            Process process = Runtime.getRuntime().exec("javac " + FileHandler.idToFilePath(id));
            process.waitFor();
            process.destroy();
            if(!FileHandler.isClassFileExists(id)){
                return false;
            }
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
