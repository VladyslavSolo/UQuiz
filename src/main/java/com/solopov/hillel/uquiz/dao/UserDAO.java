package com.solopov.hillel.uquiz.dao;

        import com.solopov.hillel.uquiz.model.User;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

public interface UserDAO extends CrudRepository<User,Integer> {
    User findUserByLoginLike(String login);
}
