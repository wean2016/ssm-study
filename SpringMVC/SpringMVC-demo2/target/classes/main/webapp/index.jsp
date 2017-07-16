<html>
    <body>
        <a href="/springmvc/testRequestParam?username=wean&age=20">test testRequestParam</a><br><br>
        <a href="/springmvc/testRequestHeader">test testRequestHeader</a><br><br>
        <a href="/springmvc/testCookieValue">test testCookieValue</a><br><br>
        <a href="/springmvc/testServletAPI">test testServletAPI</a><br><br>


        <form action="springmvc/testPojo" method="post">
            username: <input type="text" name="username">
            <br>
            password: <input type="password" name="password">
            <br>
            email: <input type="text" name="email">
            <br>
            age: <input type="text" name="age">
            <br>
            city: <input type="text" name="address.city">
            <br>
            province: <input type="text" name="address.province">
            <br>
            <input type="submit">
        </form>
        <br><br>
    </body>
</html>
