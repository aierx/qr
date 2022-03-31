package icu.aierx.mongo;

import icu.aierx.mongo.service.UserService;
import org.springframework.beans.factory.Aware;
import org.springframework.core.env.Environment;

public interface UserServiceAware extends Aware {
    void setUserService(UserService var1);
}
