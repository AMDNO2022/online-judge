package dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

import constant.LocalConstants;
import vo.RecordVO;
/**
 * @author:        usingvc6
 * @description:   record data access object
 */
public class RecordDAO {

    Connection con = null;
    public void initialize() throws Exception{
        LocalConstants constants = LocalConstants.getInstance();
        DataSource ds = DruidDataSourceFactory.createDataSource(constants.getProperties());
        con = ds.getConnection();
    }
    public void undateRecordById(RecordVO recordVO) throws Exception {
        Statement statement = con.createStatement();
        String sql = "update record set status = " + recordVO.getRecordStatus() + " where record_id = " + recordVO.getRecordId();
        statement.executeUpdate(sql);
        System.out.println(sql);
        statement.close();
    }
    public void destory() throws Exception {
        con.close();
    }
}
