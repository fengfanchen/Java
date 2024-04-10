package cn.demo.test;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@DS("mysql")
public class MySQLTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> test(){
        return jdbcTemplate.queryForList("select * from XXX.XXX");
    }
}
