<html>
    <body>

        <a href="/springmvc/testRest/1" >test Rest Get</a><br><br>
        <form action="/springmvc/testRest" method="post">
            <input type="submit" value="test Rest Post">
        </form>
        <br><br>
        <form action="springmvc/testRest/1" method="post">
            <input type="hidden" name="_method" value="DELETE"/>
            <input type="submit" value="TestRest DELETE"/>
        </form>
        <br><br>
        <form action="/springmvc/testRest/1" method="post">
            <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="test Rest PUT">
        </form>
        <br><br>


        <a href="helloworld" >Hello world</a><br><br>
        <a href="/springmvc/testPathVariable/1" >test testPathVariable</a><br><br>
        <a href="/springmvc/testRequestMapping" >test springRequestMapping</a><br><br>
        <a href="/springmvc/testParamsAndHeaders?username=hahha&age=10" >test ParamsAndHeaders</a><br><br>
        <a href="/springmvc/testAntPath/sadas/abc" >test AntPath</a><br><br>
        <a href="/springmvc/testMethod" >test Method in GET</a><br><br>

        <form action="/springmvc/testMethod" method="post">
            <input type="submit"/>
        </form><br><br>
    </body>
</html>
