<html>
    <body>
        <a href="/emps">list all employees</a>

        <a href="/testJson">test Json</a>

        <form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
            File: <input type="file" name="file">
            Desc: <input type="text" name="desc">
            <input type="submit" value="Submit">
        </form>

        <br><br>
        <a href="/testResponseEntity">test ResponseEntity</a>
        <br> <br>


        <form action="testFileUpload" method="post" enctype="multipart/form-data">
            File: <input type="file" name="file">
            Desc: <input type="text" name="desc">
            <input type="submit" value="Submit">
        </form>
        <br><br>
        <a href="/testResponseStatusExceptionResolver?i=10">test    ResponseStatusExceptionResolver</a>
    </body>
</html>
