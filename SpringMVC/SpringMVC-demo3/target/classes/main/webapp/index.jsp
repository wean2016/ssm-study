<html>
    <body>

        <%--
            模拟修改操作
            1. 原始数据为： 1, Tom, 123456, Tom@wean2016.cn, 12
            2. 密码不能被修改
            3. 表单回显，模拟操作直接在表单填写对应的属性值
        --%>
        <form action="/springmvc/testModelAttribute" method="post">
            <input type="hidden" name="id" value="1">
            username: <input type="text" name="username" value="Tom">
            <br>
            email: <input type="text" name="email" name="" value="Tom@wean2016.cn">
            <br>
            age: <input type="text" name="age" value="15">
            <br>
            <input type="submit">
        </form>
        <br><br>

        <a href="/springmvc/testModelAndView">test  ModelAndView</a><br><br>

        <a href="/springmvc/testMap">test    Map</a><br><br>

        <a href="/springmvc/testModel">test  Model</a><br><br>

        <a href="/springmvc/testSessionAttribute">test  SessionAttribute</a><br><br>
    </body>
</html>