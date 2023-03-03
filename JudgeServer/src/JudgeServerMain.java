import runnable.TaskRunnable;

import java.io.IOException;
import java.net.ServerSocket;
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
                //测试阶段，
                /*
                Socket socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String content = in.readUTF();
                System.out.println(in.readUTF());
                socket.close();*/
                //测试用，模仿用户提交它的代码
                String content = "01234567890123456789012345678901" +
                        "01234567890123456789012345678901" +
                        "import java.util.Scanner;\n" +
                        "import java.io.IOException;\n" +
                        "\n" +
                        "public class a01234567890123456789012345678901{\n" +
                        "    public static void main(String[] args) throws IOException{\n" +
                        "        Scanner input = new Scanner(System.in);\n" +
                        "        int len = Integer.parseInt(input.nextLine());\n" +
                        "        for(int i = 0; i < len; i++){\n" +
                        "            System.out.println(input.nextLine());\n" +
                        "        }\n" +
                        "        input.close();\n" +
                        "    }\n" +
                        "}";

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
