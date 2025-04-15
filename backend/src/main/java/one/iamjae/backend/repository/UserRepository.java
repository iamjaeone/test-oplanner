package one.iamjae.backend.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import one.iamjae.backend.model.User;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public User find() {
        return jdbc.queryForObject("SELECT * FROM users WHERE id = 1;", new BeanPropertyRowMapper<>(User.class));
    }

}