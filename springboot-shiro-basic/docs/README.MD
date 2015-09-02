本项目为支持springboot的shiro例子,作为基础研究的基础项目，以后所有在项目中用到的技术都要在本项目中实现。

目标：
1、springboot支持shiro
2、实现xml和javaconfig配置2中方案
3、实现url集中配置和rest shiro控制
4、测试用例



# 短期目标
1. 脚手架代码自动生成
2. rest权限控制
3. 管理平台套Ace或其它模板
4. 实现用户和权限管理
5. 用户积分

# 问题
## http://127.0.0.1:8080/user/3，不存在该id 的user时，不异常，返回空。应该返回404错误。
没有记录时抛出异常
## 向http://127.0.0.1:8080/user/3发送PUT,type为application/json, 内容为
'{"id" : "3" , "name" : "lf23rrrr22111" , "phone" : "123111111" , "password" : "11111"}'
每次保存后，记录增加一条！！
**put方法有问题，需要参考现实项目！！！**
只能通过先find后set enrity属性的方式，事务结束后，自动提交。
## 如果数据库没有自增字段，怎么实现id？

## h2服务器需要以server的方式连接，这样才能在应用正常运行的同时，使用console访问数据。每次需要手动以server模式启动h2服务 2015-9-15
能否以file的方式运行应用，同时以console查看数据？

# 任务

## Mybatis及其测试
## JdbcTemplate及其测试
## JPA + RestController
可以使用@RepositoryRestResource，输出比较符合Rest规范。
## JPA及其测试 【2015-9-10】

 