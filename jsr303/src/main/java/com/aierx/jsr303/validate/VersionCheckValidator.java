package com.aierx.jsr303.validate;

import com.aierx.jsr303.dao.UtilDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

public class VersionCheckValidator implements ConstraintValidator<VersionCheck, Object> {

    @Autowired
    UtilDao utilDao;

    private String tableName;

    @Override
    public void initialize(VersionCheck constraintAnnotation) {
        tableName = constraintAnnotation.tableName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Method methodGetId = null;
        Method methodGetVersion = null;
        try {
            methodGetId = value.getClass().getMethod("getId");
            int id = (int) methodGetId.invoke(value);
            methodGetVersion = value.getClass().getMethod("getVersion");
            int newVersion = (int) methodGetVersion.invoke(value);
            if (StringUtils.isEmpty(tableName)) {
                String simpleName = value.getClass().getSimpleName();
                tableName = "db_" + simpleName.substring(0, simpleName.length() - 2).toLowerCase();
            }
            int tableVersion = utilDao.getVersionById(tableName, id);
            if (newVersion + 1 > tableVersion) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
