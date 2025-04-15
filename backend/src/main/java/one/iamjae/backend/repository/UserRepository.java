package one.iamjae.backend.repository;

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

    private final RowMapper<User> rowMapper = (rs, rowNum) -> new User(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("email")
    );

    public List<User> findAll() {
        return jdbc.query("SELECT * FROM users", rowMapper);
    }

    public void save(User user) {
        jdbc.update("INSERT INTO users (name, email) VALUES (?, ?)", user.getName(), user.getEmail());
    }
}