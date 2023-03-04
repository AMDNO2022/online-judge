import runnable.TaskRunnable;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author:        usingvc6
 * @description:   Main function
 */
public class JudgeServerMain {
    public static void main(String[] argc){
        if(argc.length != 1){
            System.out.println("Invalid parameter! (\"Enter java JudgeServerMain {listen-port} \")");
            return;
        }
        int lestenPort = Integer.parseInt(argc[0]);

        //初始化线程池，对于线程池的使用可百度
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        try {
            //监听一个端口，网站后端会发封装好的任务过来。
            ServerSocket serverSocket = new ServerSocket(lestenPort);
            while(true){

                Socket socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String content = in.readUTF();
                socket.close();

                TaskRunnable taskRunnable = new TaskRunnable();
                taskRunnable.setParam(content);
                threadPoolExecutor.execute(taskRunnable);
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
