package com.xw.exercise.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**
 * Created by AnKh on 2017/4/3.
 */
public class JDBCutils {
    private static DataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource();
    }

    public static QueryRunner getQueryRunner(){
        return new QueryRunner(dataSource);
    }
}
