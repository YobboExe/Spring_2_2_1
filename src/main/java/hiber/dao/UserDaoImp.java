package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
      return query.getResultList();
   }

   @SuppressWarnings("unchecked")
   public User getUserByCar(int car_id) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User where cars_id =: paramName", User.class);
      query.setParameter("paramName", car_id);
      return query.getSingleResult();
   }
}
