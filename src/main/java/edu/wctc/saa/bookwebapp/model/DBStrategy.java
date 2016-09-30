
package edu.wctc.saa.bookwebapp.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Gladwin
 */
public interface DBStrategy {
     abstract void openConnection(String driverClass, String url, String userName, String password) throws ClassNotFoundException, SQLException;

    abstract void closeConnection() throws SQLException;

    abstract List<Map<String, Object>> findAllRecords(String tableName, int maxRecords) throws SQLException;

    abstract Map<String, Object> findById(String tableName, String primaryKeyFieldName, Object primaryKeyValue) throws SQLException;

    abstract int deleteById(String tableName, String pkColName, Object value) throws SQLException;

    abstract int updateRecordById(String tableName, List<String> colNames, List<Object> colValues, String pkColName, Object value) throws SQLException;

    abstract int insertOneRecord(String tablename, List<String> colNames, List<Object> values) throws SQLException;
    

}
