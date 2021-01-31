package org.furvent.web_app.utility.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getUserByDiscriminator(Long discriminator);
    List<User> getUserByUserName(String UserName);
    List<User> getUserByNickName(String nickName);
    List<User> getUserByReputation(int reputation);
    List<User> getUserByLevel(int level);
    List<User> getUserByBalance(int balance);
}
