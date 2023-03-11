package amdno2022.judgeservice.mapper;

import amdno2022.judgeservice.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: AMDNO2022
 * @description: TODO
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("")
    User getUserByAccount(String account);

    @Select("")
    User getUserById(int id);


    User getUserByPasswordCheck(String account, String password);

}
