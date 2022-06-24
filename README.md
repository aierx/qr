### 项目介绍

该项目包含许多小的项目，有许多的知识点

#### 1、 asm
使用asm框架操做字节码，在springframework框架中的aop部分利用cglib动态代理使用的该框架。在springframework可以使用@EnableAspectJAutoProxy注解开启aop的支持。如代理有默认实现的接口使用的是jdk的动态代理，如果没有实现接口则使用的cglib的动态代理。也可以指定字段proxyTargetClass为true默认使用cglib，在springboot框架中该字段默认为true。

#### 2、atx
简单使用了cxf框架和springboot继承
#### 3、config
自定义了springboot配置文件的来源，可以来自网络、数据库、文件等位置。
#### 4、cxf-jetty
使用了jetty去启动cxf的环境
#### 5、elasticsearch
jpa和es的基本使用
#### 6、fastjson
fastjson的使用
#### 7、jackson
jackson的使用
#### 8、jdbcpool
实现了一个简单的数据库连接池

#### 9、jsr107
jsr107 springboot缓存的实现


#### 9、jsr303
jsr303 参数校验


#### 10、jsr269
mapstruct 对象转换

#### 11、juc
juc包学习

#### 12、leetcode
leetcode刷题，红黑树实现、排序算法、aop示例代码

#### 13、mongo
mongo使用

#### 14、mybatis

mybatis使用

#### 14、netty

netty使用

#### 15、po

cxf和springboot集成

#### 16、rocketmq
mq使用

#### 17、springframework
简单版的springframework框架实现


#### 18、tomcat
内嵌版tomcat使用

#### HSDB生成动态代理类
java -classpath 'C:\Program Files\Java\jdk1.8.0_321\lib\*' sun.jvm.hotspot.HSDB
