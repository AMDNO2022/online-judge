package handler;

import constant.MyConstants;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * @author:        usingvc6
 * @description:   一些文件读写的操作
 */
public class FileHandler {


    public static void makeFile(String id, String content){
        File dir = new File(MyConstants.dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File sourceFile = new File(idToFilePath(id));
        try {
            if(!sourceFile.exists()){
                sourceFile.createNewFile();
            }
            Files.write(sourceFile.toPath(), content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 后端已将主函数入口类名改为'a' + recordId
    public static String idToFilePath(String id){
        return MyConstants.dirPath + "/a"+ id + ".java";
    }

    public static String idToClassFilePath(String id){
        return MyConstants.dirPath + "/a"+ id + ".class";
    }

    public static boolean isClassFileExists(String id){
        File file = new File(MyConstants.dirPath + "/a"+ id + ".class");
        return file.exists();
    }

    public static void deleteFile(String id) {
        File file = new File(idToFilePath(id));
        File classFile = new File(idToClassFilePath(id));
        file.delete();
        classFile.delete();
    }
}
