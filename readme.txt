一、项目介绍
      广联达低代码开发平台内置了单据、字典等开发模板，为开发者提供了单据类及字典等模块开发所需的基础的增删改查等能力，开发者可在开发平
   台中直接使用模板提供的能力。同时，开发平台也提供了灵活的扩展机制，当内置模板所提供的基础能力无法满足用户业务需求时，可以采用自定义代
   码的方式进行扩展能力的开发。
      该项目适用于采用自定义代码方式进行组件开发的场景，项目中内置了开发所需的POM依赖、基础的应用配置、代码工程结构和简单的示例代码，
   开发者可采用继承重写或添加新方法的方式进行能力扩展。工程中的代码为示例代码、配置为最基础配置，开发者可根据实际情况进行调整。

二、技术栈
   1.java jdk 版本11
      jdk11下载地址：https://www.oracle.com/java/technologies/downloads/#java11-windows
   2.spring 版本5.2.12.RELEASE
   3.spring-boot 版本2.3.7.RELEASE
   4.spring-webflux 版本5.2.12.RELEASE
   5.maven 3
       maven下载地址：https://maven.apache.org/download.cgi

三、工程结构
├── src                         
├──── mian
├────── java     
├───────── com   
├─────────── example
├────────────── demo
│   	    ├── constants               // 常量类
│   	    ├── enums         		    // 枚举类
│   	    ├── handler                 // 处理器
│   	    ├── service                 // 业务逻辑层
│   	    ├── utils                   // 工具类
│   	    └── DemoApplication.java    // 启动类
├────── resources                   // 资源目录
│           ├── application.yml         // 应用配置
│           ├── bootstrap.yml           // 系统配置
├── pom.xml                         // pom依赖

四、开发流程
   1.修改配置
       在开发环境配置文件，设置对应的环境变量值，如下：
       env.cloudt.gateway.appKey:组件appKey            //开发平台颁发给该组件的appKey，访问平台开放网关时作为身份标识
       env.cloudt.gateway.appSecret:组件appSecret      //开发平台颁发给该组件的appSecret，访问平台开放网关时用于加密
       env.cloudt.gateway.baseUrl:平台开放网关地址      //访问平台基础服务接口
       env.gect.registry.hostUrl:元数据引擎服务地址     //组件服务启动时加载元数据的地址
       env.gect.cds.hostUrl:通用数据服务地址            //组件服务调用数据访问层的地址
       env.redis.host: redis连接地址
       env.redis.password: redis连接密码
       env.redis.port:  redis连接端口
       env.redis.database: redis数据库号

       配置文件中修改当前组件的元数据标识，如下：
       meta.registry.discovery.deployments:当前组件的元数据标识  //组件服务启动时会根据该标识加载对应的元数据注册为API接口

   2.开发service
       service为业务逻辑层，所有业务逻辑需要写到对应的service类中，DocService为服务层的顶层基类，该类中提供了基础的增删改查能力。
    同时，开发平台也内置了单据基类（BillService）和字典基类（DictService），提供了对单据和字典对象的补充扩展能力，包括提交、废弃、
    审批流程、excel导入导出等能力，开发者可根据实际情况选择继承对应的基类。

   3.开发handler
       handler为控制层，依赖service层，DocHandler为控制层的顶层基类，该类中调用对应的DocService对外提供基础的增删改查的接口服务。
    与Service对应，开发平台也提供了对应的单据控制器（BillHandler）和字典控制器（DictHandler）。控制器开发完成后，需要在开发平台中
    注册类和方法，然后就可以在对象中使用对应的方法定义为功能，前端页面或其他组件可以直接使用对象中的功能。在开发平台中注册自定义代码的
    方法为：我的组件-> 组件开发 -> 功能开发 -> 自定义代码 -> 新建 -> 保存。

五、常见问题
    问：一般我们开发api接口都需要定义controller，为什么该项目中不需要定义controller？
    答：因为我们是基于Spring webflux动态生成的api接口，handler相当于spring mvc当中定义的controller。

    问：handler中的方法都没有写请求路径，那么接口的路径是什么？
    答：在开发平台中，对象可以定义功能，功能包含请求路径和对应的自定义代码方法，平台会自动把对应的请求路径映射到handler中的方法上。

    问：handler中没有写增删改查的方法，为什么可以对该对象进行增删改查？
    答：平台中内置了一些对象操作的基类，包括DocHandler、BillHandler、DictHandler等，这些控制器中包含了对应对象的基本操作，包括增删
    改查等，开发者可以直接继承对应的控制器，无需重复开发，同时，基类中也提供了对应虚方法，以供开发者重写覆盖。