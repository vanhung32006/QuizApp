/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services;

import com.dht.pojo.Category;
import com.dht.pojo.Question;
import com.dht.utils.MyConnSingleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionServices {
    public List<Question> getQuestions(String kw) throws SQLException {
        String sql = "SELECT * FROM question";
        PreparedStatement stm = MyConnSingleton.getInstance().connect().prepareCall(sql);
        ResultSet rs = stm.executeQuery();
        
        List<Question> questions = new ArrayList<>();
        while (rs.next()) {
            Question q = new Question();
            q.setId(rs.getInt("id"));
            q.setContent(rs.getString("content"));
            questions.add(q);
        }
        
        return questions;
    }
}
