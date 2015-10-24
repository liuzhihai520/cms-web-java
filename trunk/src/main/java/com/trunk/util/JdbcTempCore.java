package com.trunk.util;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.Map;
/**
 * 方法描述:重写jdbcTemplateMap
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/24
 */
public class JdbcTempCore extends JdbcTemplate {
    @Override
    public Map<String, Object> queryForMap(String sql) throws DataAccessException {
        try{
            return queryForObject(sql, getColumnMapRowMapper());
        }catch (Exception e){
            return new HashMap<String,Object>();
        }
    }

    @Override
    public Map<String, Object> queryForMap(String sql, Object[] args, int[] argTypes) throws DataAccessException {
        try {
            return queryForObject(sql, args, argTypes, getColumnMapRowMapper());
        }catch (Exception e){
            return new HashMap<String,Object>();
        }
    }

    @Override
    public Map<String, Object> queryForMap(String sql, Object... args) throws DataAccessException {
        try {
            return queryForObject(sql, args, getColumnMapRowMapper());
        }catch (Exception e){
            return new HashMap<String,Object>();
        }
    }
}
