package amdno2022.judgeservice.mapper;

import amdno2022.judgeservice.pojo.Question;
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
public interface QuestionMapper {
    @Select("select question_id as questionId, question_name as questionName from question where question_id >= (select question_id from question order by question_id limit #{page_index1, jdbcType=INTEGER}, #{page_index2, jdbcType=INTEGER}) limit 10;")
    List<Question> getQuestionIdNameByIndex(int page_index1, int page_index2);
    @Select("select count(*) from question ;")
    int getQuestionRowCount();

}
