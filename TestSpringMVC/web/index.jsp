<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/6
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"   %>
<html>
  <head>
    <title></title>
    <meta charset="utf-8">
  </head>
  <body>
  <a href="h/b">test</a>
  <a href="a/t">helloWorld</a>
  <h1>测试ResquestMapping的method属性</h1>
  <a href="a/handle01">handle01</a>

  <form action="http://localhost:8080/TestSpringMVC/a/handle01" method="post">
    <input type="submit" value="请求"/>
  </form>
  <h1>测试ResquestMapping的params属性</h1>
  <a href="a/handle02">handle02</a>
  <h1>测试ResquestMapping的headers属性</h1>
  <a href="a/handle03">handle03</a>
  <hr/>
  <h1>测试ResquestMapping-ant风格的url</h1>
  <a href="a/handle05">handle04</a>
  <hr/>
  <a href="goods/1">查询1号商品</a>
  <form action="goods/1" method="post">
    <input type="submit" value="添加商品"/>
  </form>
  <form action="goods/1" method="post">
    <input type="text" value="put" name="_method"/>
    <input type="submit" value="更新商品"/>
  </form>
  <form action="goods/1" method="post">
    <input type="text" value="delete" name="_method"/>
    <input type="submit" value="删除商品"/>

  </form>
  <hr/>
  <a href="a/handle09?uname=dxw">handle09</a>
  <a href="a/handle10">handle10</a>
  <a href="a/handle11">handle11</a>
  <hr/>
  <form action="a/addGoods" method="post">
    商品编号： <input type="text" name="gId" /><br/>
    商品名称： <input type="text" name="gName" /><br/>
    商品价格： <input type="text" name="price" /><br/>
    商品库存： <input type="text" name="stock" /><br/>
    生产地址 省：<input type="text" name="address.province" /><br/>
    市： <input type="text" name="address.city" /><br/>
    区： <input type="text" name="address.area" /><br/>
    <input type="submit" value="提交商品信息"/>
  </form>
  <hr/>
  <a href="a/handle12">request&response</a><br/>
  <a href="a/handle13">handle12</a><br/>
  <a href="a/handle14">handle13</a><br/>
  <a href="a/handle15">handle14</a><br/>
  <a href="a/handle16">handle15</a><br/>
  <hr/>
  <form action="a/updateGoods" method="post">
    商品编号： <input type="text" name="gId" /><br/>
    商品名称：辣条<br/>
    商品价格： <input type="text" name="price" /><br/>
    商品库存： <input type="text" name="stock" /><br/>

    <input type="submit" value="提交"/>
  </form>
  </body>
</html>
