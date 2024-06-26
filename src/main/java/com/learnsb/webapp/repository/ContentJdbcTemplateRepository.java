package com.learnsb.webapp.repository;


import com.learnsb.webapp.model.Content;
import com.learnsb.webapp.model.Status;
import com.learnsb.webapp.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ContentJdbcTemplateRepository {

    private final JdbcTemplate jdbctemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbctemplate){
        this.jdbctemplate = jdbctemplate;
    }

    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Content(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                Status.valueOf(rs.getString("status")),
                Type.valueOf(rs.getString("content_type")),
                rs.getTimestamp("date_created").toLocalDateTime(),
                rs.getTimestamp("date_updated").toLocalDateTime(),
                rs.getString("url"));
    }

    public List<Content> getAllContent(){
        String sql = "SELECT * FROM Content";
        List<Content> contents = jdbctemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
        return contents;
    }
    public void createContent(String title, String desc, Status status, Type contentType, String URL) {
        String sql = "INSERT INTO Content (title, desc, status, content_type, date_created, URL) VALUES (?, ?, ?, ?, NOW(), ?)";
        jdbctemplate.update(sql, title, desc, status, contentType, URL);
    }

    public void updateContent(int id, String title, String desc, Status status, Type contentType, String URL) {
        String sql = "UPDATE Content SET title=?, desc=?, status=?, content_type=?, date_updated=NOW(), url=? WHERE id=?";
        jdbctemplate.update(sql, title, desc, status, contentType, URL, id);
    }

    public void deleteContent(int id) {
        String sql = "DELETE FROM Content WHERE id=?";
        jdbctemplate.update(sql, id);
    }

    public Content getContent(int id) {
        String sql = "SELECT * FROM Content WHERE id=?";
        Content content = jdbctemplate.queryForObject(sql, new Object[]{id}, ContentJdbcTemplateRepository::mapRow);
        return content;
    }



}
