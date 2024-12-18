package Operations.JDBCCrud;

import Operations.JDBCCrud.dao.UserDao;
import Operations.JDBCCrud.userfile.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcCrudApplication implements CommandLineRunner {

	@Autowired
	private UserDao userdao;
	public static void main(String[] args) {
		SpringApplication.run(JdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

/*		User user=new User("Mit","Female","mit@gmail.com","Noida");
		User user1=new User("Hit","Male","Hit@gmail.com","Delhi");
		boolean status=userdao.InsertUser(user1);
		if(status){
			System.out.println("Inserted successfully");
		}
		else{
			System.out.println("Not inserted. Retry!!");
		}*/
		User user=new User("Geet","Female","mit@gmail.com","Roorkee");
		boolean status=userdao.Update_Sql(user);
		if(status){
			System.out.println("Updated");
		}
		else{
			System.out.println("Not Updated");
		}
	}
}
