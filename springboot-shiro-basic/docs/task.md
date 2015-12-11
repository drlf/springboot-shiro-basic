【2015-10-08】
以为shiro-web的filter是顺序执行，取到第一个为有效，看来未必是。
如下：/access/**=anon
/**＝restAuthc
结果是/access/referesh会触发filter，把/**改为/rest/**就好了！

shiro－rest设计：
MyRestFilter继承自HttpMethodPermissionFilter，实现isAccessAllowed方法即可
在/access/longin中发放refereshToken，在/access/referesh中发放accessToken
访问/rest/**时，在header中带上accessToken

[spring-data-rest](http://docs.spring.io/spring-data/rest/docs/current/reference/html/)

【2015-10-06】
mac下运行h2，下载全平台，运行bin/h2.sh，报文件格式错误，拷贝到h1.sh,chmod 777 h1.sh,运行即可。
x修改h1.sh,在java命令尾部加上&，避免关闭term时退出程序。

为什么运行prepareTestData会报找不到column错，似乎是没有把字段的名称按驼峰命名方式转化为下划线。但是运行entityTest测试后（在user中插入一条数据），再次执行prepareTestData就成功了？
难道是创建的表有问题？


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

