package amdno2022.judgeservice.mapper;

import amdno2022.judgeservice.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: AMDNO2022
 * @description: TODO
 */
@Mapper
@Repository
public interface RecordMapper {
    List<Record> getRecordsByPage(int page);
    Record getRecordById(int id);

    @Select("select status from record where user_id = #{uid, jdbcType=INTEGER} and question_id = #{qid, jdbcType=INTEGER}")
    Integer getRecordStatusByUserIdQuestionId(int uid, int qid);
    @Select("select count(*) from record ;")
    int getRecordRowCount();
}
