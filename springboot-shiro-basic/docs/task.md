【2015-9-22】
计划：
user等entity设计，及rest输出
shiro + Oauth管理登录过程及权限认证
设计用户、权限、角色的编辑页面，测试用例

试验下面这句
log.debug("Looked up AuthenticationInfo [{}] from doGetAuthenticationInfo", info);

【2015-9-21】
实现了xml配置和javaconfig 2中方式的userService单元测试，
PrepareTestData和PrepareTestData2, src/test/config下的spring-beans.xml和db.properties是xml使用的配置文件。
运行情况：
xml配置6秒，javaconfig 10秒，在同一个数量级，可不考虑xml配置方式的测试。
（如不使用jpa，xml方式可能还有优势，例如在mybatis下）
总结：
学习从csdn中下载的shirodemo例子，基本实现了springboot嵌入shiro的架设，但是在跑例子时，有个问题始终没弄明白
同样创建的2个用户，zhang和li，为什么一个登录成功，另一个登录不成，在密码匹配时失败？
嵌入shiro，登录验证成功，适用prepareTestData创建用户成功。
但是登录后没有转向到成功页面，输入其它页面仍旧调回login.jsp,是不是subject.login没有调用?

