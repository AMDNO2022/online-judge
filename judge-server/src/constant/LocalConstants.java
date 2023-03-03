package constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * @author: usingvc6
 * @description: 保存一些常量，单例模式
 */
public class LocalConstants {
    private static LocalConstants single;
    private Properties properties;

    public LocalConstants() throws IOException {
        properties = new Properties();
        InputStream is = LocalConstants.class.getClassLoader().getResourceAsStream("JudgeServerProperties.properties");
        properties.load(is);
    }
    public static LocalConstants getInstance(){
        if(single == null){
            try{
                single = new LocalConstants();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return single;
    }

    public String getTempDirPath(){
        return properties.get("dirPath").toString();
    }
    public int getMaxRunningTime(){
        return Integer.parseInt(properties.get("maxRunningTime").toString());
    }
    public String getFullPath(){
        return properties.get("fullPath").toString();
    }

    public Properties getProperties() {
        return properties;
    }

    public String getRedisHost() {
        return properties.get("redisHost").toString();
    }
    public String getRedisPort() {
        return properties.get("redisPort").toString();
    }
    public String getRedisPassword() {
        return properties.get("redisPassword").toString();
    }
}
