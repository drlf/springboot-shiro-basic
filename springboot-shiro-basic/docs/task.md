【2015-9-21】
实现了xml配置和javaconfig 2中方式的userService单元测试，
PrepareTestData和PrepareTestData2, src/test/config下的spring-beans.xml和db.properties是xml使用的配置文件。
运行情况：
xml配置6秒，javaconfig 10秒，在同一个数量级，可不考虑xml配置方式的测试。
（如不使用jpa，xml方式可能还有优势，例如在mybatis下）
