package Operations.JDBCCrud.dao;

import Operations.JDBCCrud.userfile.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository //DAO class
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean InsertUser(User user){
        boolean status=false;
        try {
            String INSERT_INTO = "INSERT INTO USERS(name,email,gender,city) VALUES(?,?,?,?)";
            int count=jdbcTemplate.update(INSERT_INTO, user.name(), user.email(), user.gender(), user.city());
            if(count>0){
                status=true;
            }
            else{
                status=false;
            }
        }
        catch (Exception e){
            status=false;
            e.printStackTrace();
        }
        return status;
    }

    public boolean Update_Sql(User user){
        boolean status=false;
        try{
            String UPDATE_SQL_QUERY="UPDATE  USERS Set name=?,gender=?,city=? where email=?";
            int count=jdbcTemplate.update(UPDATE_SQL_QUERY,user.name(),user.gender(),user.city(),user.email());
            if(count>0){
                status=true;
            }
            else{
                status=false;
            }
        }
        catch (Exception e){
            status=false;
            e.printStackTrace();
        }
        return status;
    }

    public User get_User_Email(String email){
        String SELECT_QUERY="Select * from users where email=?";
        return jdbcTemplate.queryForObject(SELECT_QUERY,new Row_map(),email);
    }

    public List<User> Get_By(){
        String SQL_LIST_QUERY="Select * from users ";
        return jdbcTemplate.query(SQL_LIST_QUERY,new Row_map());
    }

    public static final class Row_map implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user=new User();
            user.setName(rs.getString("name"));
            user.setGender(rs.getString("gender"));
            user.setEmail(rs.getString("email"));
            user.setCity(rs.getString("city"));
            return user;
        }
    }
}
