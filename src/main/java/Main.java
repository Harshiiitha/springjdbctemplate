import com.stackroute.springJdbc.config.SpringJdbcConfig;
import com.stackroute.springJdbc.controller.SpringJdbcController;
import com.stackroute.springJdbc.domain.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.*;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;

@Configuration
@ComponentScan("com.stackroute.*")
public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner=new Scanner(System.in);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SpringJdbcConfig.class);
        ctx.refresh();

        SpringJdbcController springJdbcController =(SpringJdbcController) ctx.getBean("springJdbcController");

        //Retrieving the contrnt based on id
        System.out.println("Enter an id of movie to display information the movie");
        int id=scanner.nextInt();
        System.out.println(springJdbcController.executeShow(id));
        //inserting into Movie
        System.out.println(springJdbcController.insert());
        //Updating a movie in list of movies
        System.out.println(springJdbcController.update());
        //deleting a record from movie table
        System.out.println(springJdbcController.delete());
        //List all the values
        System.out.println(springJdbcController.getAll());
    }
}