#文档说明
专门用于Entity测试，试验model间的关系及自动建表。

#项目内容

##BaseEntity
BaseEntity使用GenerationType.AUTO，会根据数据库不同进行选择，估计对Oracle不行。oracle的实现参考sequencedemo下的例子。

##@OneToMany
映射策略有2中
### 外键关联：两个表的关系定义在一个表中；
@OneToMany        @JoinColumn(name="customer_id") 根据关联表中的customer_id关联
### 表关联：两个表的关系单独定义一个表中通过一个中间表来关联。
@JoinTable(name="ref_customer_address",	//中间表名
joinColumn={@JoinColumn(name="customer_id",referencedColumnName="id")},  关联本对象
inverseJoinColumn={@JoinColumn(name="address_id",referencedColumnName="id")} 关联另一个对象
)
注：如果使用了表关联，并且该表又设置了外键，则在映射的实体关系时可以使用默认的映射关系设置。即@OneToMany不加任何其它标签。

实际完全可用，User使用@OneToMany（默认关联）关联Role，系统会自动创建中间表。



