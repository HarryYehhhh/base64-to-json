package com.example.test.dao;

import com.example.test.model.TestBean;
import com.example.test.rowmapper.TestRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TestDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public TestBean search(){
        String sql = "select idx, c_aes256, c_base64 from table1";

        Map<String , Object> map = new HashMap<>();
        List<TestBean> list = namedParameterJdbcTemplate.query(sql, map, new TestRowMapper());
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

}
