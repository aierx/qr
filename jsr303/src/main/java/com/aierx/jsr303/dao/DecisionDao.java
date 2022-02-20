package com.aierx.jsr303.dao;

import com.aierx.jsr303.model.po.DecisionPO;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionDao {
    public void updateDecision(DecisionPO decisionPO);
}
