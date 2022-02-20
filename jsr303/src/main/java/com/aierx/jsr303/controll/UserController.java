package com.aierx.jsr303.controll;

import com.aierx.jsr303.dao.DecisionDao;
import com.aierx.jsr303.dao.UserDao;
import com.aierx.jsr303.model.po.DecisionPO;
import com.aierx.jsr303.model.po.UserPO;
import com.aierx.jsr303.util.Result;
import com.aierx.jsr303.validate.A;
import com.aierx.jsr303.validate.B;
import com.aierx.jsr303.validate.GroupSeq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    UserDao userDao;

    DecisionDao decisionDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setDecisionDao(DecisionDao decisionDao) {
        this.decisionDao = decisionDao;
    }

    @PostMapping("updateUser1")
    public Result updateUser(@Validated(GroupSeq.class) @RequestBody UserPO userPO) {
        userDao.updateUser(userPO);
        return Result.makeSuccess("操作成功", userPO);
    }

    @PostMapping("updateUser2")
    public Result updateUser(@Valid @RequestBody DecisionPO decisionPO) {
        decisionDao.updateDecision(decisionPO);
        return Result.makeSuccess("操作成功", decisionPO);
    }

    @PostMapping("/getUser")
    public Result getUser(@Valid @RequestBody UserPO userPO) {
        return Result.makeFail("操作成功");
    }

}
