# **SpringBoot开发模板(选课系统样例)**
> 技术选择:
>* SpringBoot
>* Mybatis-Plus 持久层控制
>* Sa-Token 安全框架
>* LogBack 日志打印保存

- - -

## 数据库设计
> 前端路由-数据库设计

![table-page](readmeImg\table-page.png)

* 不同的权限分组在前端的页面显示不同的路由，比如学生看不到课程修改界面选项
* 对接原则：
    * 每一次登录成功，后台服务器会传送该用户的信息(节选)给前端，前端对这个信息进行保存<br>
    * 前端根据这个data的page进行筛选路由显示 -> display:none / block
    
- - -
> 接口权限分组

![table-permission](readmeImg\table-perssion.png)

* 根据不同角色进行分配权限(也可以直接笼统地单单使用role进行分配)

![table-role](readmeImg\table-role.png)

* role表 设计中 用的是字符串拼接，这样可以不用再开一张表格出来了，一定程度上节约了空间
* 只需要后台进行拆分字符串，再进行sql

- - -

## 代码规范
* 在前后端API url中使用RESTFUL风格开发（前后端分离）遵从接口命名规范
* 在controller层和service之间的接口命名规范，即CRUD命名方式
* 数据库设计规范，目前每张表的主键都为int类型，后期可以根据开发需求进行更换<br>
但是要注意，多表查询的索引建议用int，不要用varchar以加快效率
