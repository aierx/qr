package com.aierx.atx.dao;

import com.aierx.atx.model.po.UserPO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author leiwenyong
 * @since 2022-05-22
 */
public interface UserMongoDao extends MongoRepository<UserPO,String> {



}
