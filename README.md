# A online-judge website. (Spring Boot/Vue/Mysql/Redis)

一个使用Java开发的轻量级分布式Online Judge网站，支持提交Java代码解决算法问题并返回代码运行的不同结果，包含以下部分：

基于Socket、消息队列与线程池、计时线程的判题端；

基于SpringBoot和Mybatis的业务逻辑后端；

基于Vue3 Element-ui的前端；

基于Redis的数据缓存策略。
 
#这个项目将在四月内完成，现在你可以不用往下看了
 
## 目录

- [启动](#启动)
- [作者](#作者)
- [鸣谢](#鸣谢)

### 启动

以下内容面向开发者

请运行以下命令以确保你安装了有效版本的 Java \ Maven \ vue3 \ MySQL \ Redis：

```sh
java -version
mvn -v
vue -V
mysql -V
redis-server -v
```

1. 克隆

```sh
git clone https://github.com/AMDNO2022/online-judge.git
```

2. 启动判题端

配置你的文件
```sh
vim judge-server/src/JudgeServerProperties.properties
```
```sh
java judge-server/src/JudgeServerMain.java
java judge-server/src/JudgeServerMain
```

3. 启动后端
```sh
cd judge-service
nohup mvn spring-boot:run &
```

4.启动前端
```sh
cd online-judge/front
npm install
nohup npm run dev &
```

### 作者

Wu F.Y

### 等待实现的功能


### 已知的问题
