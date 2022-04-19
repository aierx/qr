package com.aierx;

import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * @author leiwenyong
 * @since 2022/4/13
 */
public class MybatisLogTransformer implements ClassFileTransformer {


    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer){
        if (className.equals("org/apache/ibatis/executor/statement/PreparedStatementHandler")){
            try {
                //借助JavaAssist工具，进行字节码插桩
                ClassPool pool = ClassPool.getDefault();
                CtClass cc = pool.get("org.apache.ibatis.executor.statement.PreparedStatementHandler");
                CtMethod personFly = cc.getDeclaredMethod("instantiateStatement");

                //在目标方法前后，插入代码
                personFly.insertBefore("    String res = boundSql.getSql().replaceAll(\"\\\\n\", \"\").replaceAll(\"\\\\t\", \"\").replaceAll(\"\\\\r\", \"\");\n" +
                        "    Object parameterObject = boundSql.getParameterObject();\n" +
                        "    List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();\n" +
                        "    if (parameterMappings != null) {\n" +
                        "      for (int i = 0; i < parameterMappings.size(); i++) {\n" +
                        "        ParameterMapping parameterMapping = parameterMappings.get(i);\n" +
                        "        if (parameterMapping.getMode() != ParameterMode.OUT) {\n" +
                        "          Object value;\n" +
                        "          String propertyName = parameterMapping.getProperty();\n" +
                        "          if (boundSql.hasAdditionalParameter(propertyName)) { // issue #448 ask first for additional params\n" +
                        "            value = boundSql.getAdditionalParameter(propertyName);\n" +
                        "          } else if (parameterObject == null) {\n" +
                        "            value = null;\n" +
                        "          } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {\n" +
                        "            value = parameterObject;\n" +
                        "          } else {\n" +
                        "            MetaObject metaObject = configuration.newMetaObject(parameterObject);\n" +
                        "            value = metaObject.getValue(propertyName);\n" +
                        "          }\n" +
                        "          TypeHandler typeHandler = parameterMapping.getTypeHandler();\n" +
                        "          JdbcType jdbcType = parameterMapping.getJdbcType();\n" +
                        "          if (value == null && jdbcType == null) {\n" +
                        "            jdbcType = configuration.getJdbcTypeForNull();\n" +
                        "          }\n" +
                        "          res = res.replaceFirst(\"\\\\?\",\"'\"+value.toString()+\"'\");\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "    System.out.println(res);");

                personFly.insertAfter("System.out.println(\"--- after doBusiness ---\");");

                return cc.toBytecode();
            }catch (Exception exception){
                System.out.println("出现异常了");
            }

        }
        return null;
    }
}
