package amdno2022.judgeservice.pojo;

import lombok.Data;

/**
 * @author: AMDNO2022
 * @description: TODO
 */
@Data
public class Record {
    int recordId;
    int userId;
    int questionId;
    int status;
    int language;
    String code;
    String submitTime;
}
