package vo;

/**
 * @author: AMDNO2022
 * @description: record value object
 */
public class RecordVO {
    int recordId;
    int recordStatus;

    public RecordVO(int id, int status) {
        recordId = id;
        recordStatus = status;
    }

    public void setStatus(int status) {
        recordStatus = status;
    }

    public int getRecordId() {
        return recordId;
    }

    public int getRecordStatus() {
        return recordStatus;
    }
}
