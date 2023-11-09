package system.gathering.repository.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.gathering.object.Chatting;
import system.gathering.object.User;
import system.gathering.object.Chat;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@Transactional
public class JdbcUserRepository implements UserRepository {

    private final NamedParameterJdbcTemplate template;
   // private final JdbcTemplate template2;
   private final EntityManager em;


    public JdbcUserRepository(DataSource dataSource,EntityManager em) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
        this.em = em;
       // this.template2 = new JdbcTemplate(dataSource);
    }

    public void save(String roomNum, String userName, String chat){
        String table = "club" + roomNum;
        String sql = "insert into " + table +"(name, content) values(?, ?)";
        JdbcTemplate jdbcTemplate = template.getJdbcTemplate();
        jdbcTemplate.update(sql,userName,chat);

    }
    public void save2(String roomNum, String userName, String chat){
        String table = "ltforum" + roomNum;
        String sql = "insert into " + table +"(name, content) values(?, ?)";
        JdbcTemplate jdbcTemplate = template.getJdbcTemplate();
        jdbcTemplate.update(sql,userName,chat);

    }

    @Override
    public User save(User user) {
        String sql = "insert into user2 (user_id, password, name, nickname, postcode, address, detail_address, " +
                "extra_address, phone_number,email)" +
                "values (:userId, :password, :name, :nickName, :postcode, :address, :detailAddress, :extraAddress,:phoneNumber,:email)";

        SqlParameterSource param = new BeanPropertySqlParameterSource(user);
        template.update(sql,param);
        return user;
    }
    @Override
    public User jpaSave(User user){
        em.persist(user);
        return user;
    }


    @Override
    public void create(String a){
        String sql = "create table " + a +  " (id bigint AUTO_INCREMENT, name varchar(255), content varchar(255), PRIMARY KEY (id))";
        //template2.execute(sql);
        JdbcTemplate jdbcTemplate = template.getJdbcTemplate();
        jdbcTemplate.execute(sql);
    }


    @Override
    public User findById(String userId) {
        String sql = "select * from user2 where user_id = :userid";
        Map<String, Object> param = Map.of("userid",userId);
        User user = template.queryForObject(sql, param, itemRowMapper());
        return user;
    }

    @Override
    public User findByEmail(String email) {
        String sql = "select * from user2 where email = :email";
        Map<String, Object> param = Map.of("email",email);
        User user = template.queryForObject(sql, param, itemRowMapper());
        return user;
    }

    @Override
    public List<Chatting> findChat(String a){
        String sql = "select * from " + a;
        JdbcTemplate jdbcTemplate = template.getJdbcTemplate();
        List<Chatting> query = jdbcTemplate.query(sql, new RowMapper<Chatting>() {
            @Override
            public Chatting mapRow(ResultSet rs, int rowNum) throws SQLException {
                Chatting chat = new Chatting();
                chat.setId(rs.getLong("id"));
                chat.setName(rs.getString("name"));
                chat.setContent(rs.getString("content"));
                return chat;
            }
        });
        return query;
    }
    @Override
    public void update(User user, String userId) {
        String sql = "update user2 set password=:password, name=:name, postcode=:postcode," +
                "address=:address, detail_address=:detailAddress, extra_address=:extraAddress, phone_number=:phoneNumber," +
                "upload_file=:uploadFile, store_file=:storeFile " +
                "where user_id=:userId";

        SqlParameterSource param = new BeanPropertySqlParameterSource(user);
        template.update(sql,param);
    }

    public User findByNickName(String nickName) {
        String sql = "select * from user2 where nickname = :nickname";
        Map<String, Object> param = Map.of("nickname",nickName);
        User user = template.queryForObject(sql, param, itemRowMapper());

        return user;
    }

    private RowMapper<User> itemRowMapper() {
        return BeanPropertyRowMapper.newInstance(User.class); //camel 변환 지원
    }
}
