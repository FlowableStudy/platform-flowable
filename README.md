

------

环境：

[jkd8+]()

[Flowable6.4.0]()

[mysql5.6+]()

[spring boot2.0.7]()

------

## 一、整合spring boot

新建springboot项目

## 二、整合flowable-modeler

- [下载flowable war包](https://github.com/flowable/flowable-engine/releases/download/flowable-6.4.0/flowable-6.4.0.zip)
- 解压flowable-modeler.war
- 复制静态文件到项目中

```
将flowable-modeler\WEB-INF\classes\static下的所有文件复制到src\main\resources\static\modeler下
```

- 添加拦截器配置类StaticResourceConfig

  由于springboot2.0.1之后的版本会拦截static下面的静态资源，故需要添加一个拦截器，不拦截static下面的静态资源

- 汉化处理

   拷贝文件：

  ```
  将flowable源码中的flowable-ui-modeler-logic项目下的src\main\resources\stencilset_bpmn.json、src\main\resources\stencilset_cmmn.json
  ```

  翻译此两个文件中的title和description的值。



## 三、启动

浏览器访问：http://localhost:9999/modeler/index.htm





