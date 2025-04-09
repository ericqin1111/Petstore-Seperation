package com.example.petstoresep.controller;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseInit {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @PostConstruct
    public void init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS cartstore(" +
                "            username VARCHAR(25) NOT NULL ," +
                "            itemid VARCHAR(10) NOT NULL," +
                "            quantity INTEGER NOT NULL" +
                "    );");
        jdbcTemplate.execute(
                "create table if not exists item_order " +
                        "(" +
                        "    id  int auto_increment primary key ," +
                        "    item_id   varchar(255)          null," +
                        "    user_name   varchar(255)          null," +
                        "    code     varchar(255) null," +
                        "    add_time  datetime     null," +
                        "    total    varchar(255) null," +
                        "    is_delete int          null," +
                        "    status   int          null," +
                        "    check (`status` in (0, 1, 2, 3, 4))" +
                        ")");

    }
}

