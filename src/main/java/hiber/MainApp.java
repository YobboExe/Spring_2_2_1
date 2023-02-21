package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.CarServiceImp;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      User dude1 = new User("Jon", "Bon", "veryCool@gmail.com");
      User dude2 = new User("Steve", "Minecraft", "block@gmail.com");
      User dude3 = new User("Jeff", "bezos", "capitalism@gmail.com");
      User dude4 = new User("An", "NPC", "ordinaryGuy@gmail.com");
      Car car1 = new Car(2101, "VAZ");
      Car car2 = new Car(524, "VAZ");
      Car car3 = new Car(24103, "VAZ");
      Car car4 = new Car(2664, "VAZ");
      dude1.setCar_id(car1);
      dude2.setCar_id(car2);
      dude3.setCar_id(car3);
      dude4.setCar_id(car4);


//      userService.getUserByCar(4);
      userService.add(dude1);
      userService.add(dude2);
      userService.add(dude3);
      userService.add(dude4);

      System.out.println(userService.getUserByCar(1));
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
