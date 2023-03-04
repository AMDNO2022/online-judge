package dao;

import constant.LocalConstants;
import redis.clients.jedis.Jedis;
import vo.QuestionVO;

import java.util.*;

/**
 * @author: usingvc6
 * @description: question data access object
 */
public class QuestionDAO{
    Jedis jedis = null;
    public void initialize(){
        LocalConstants constants = LocalConstants.getInstance();
        jedis = new Jedis(constants.getRedisHost(), Integer.parseInt(constants.getRedisPort()));
        jedis.auth(constants.getRedisPassword());
    }
    public QuestionVO selectQuesionInputOutputById(int id) {
        List value = jedis.hmget("" + id, "qi", "qo");
        return new QuestionVO(value.get(0).toString(), value.get(1).toString());
    }
    public void destory() throws Exception {
        jedis.close();
    }
}
