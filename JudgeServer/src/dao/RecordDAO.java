package dao;

import constant.ResultStatus;

/**
 * @author:        usingvc6
 * @description:   record data access object
 */
public class RecordDAO {
    public void undateRecordById(String id, int resultStatus) {
        System.out.println(id + " : " + resultStatus);
    }
}
