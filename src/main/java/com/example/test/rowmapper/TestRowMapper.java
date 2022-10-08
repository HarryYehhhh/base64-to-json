package com.example.test.rowmapper;

import com.example.test.model.TestBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestRowMapper implements RowMapper<TestBean> {

    @Override
    public TestBean mapRow(ResultSet resultSet, int i) throws SQLException {
        TestBean tbean = new TestBean();
        tbean.setId(resultSet.getInt("idx"));
        tbean.setcAes256(resultSet.getString("c_aes256"));
        tbean.setcBase64(resultSet.getString("c_base64"));
        return tbean;
    }
}
