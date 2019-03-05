<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuqin
  Date: 3/3/2019
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>MyCart Page</title>
    </head>
    <body>
        <h2>Your Cart:</h2>
        <%
            Map<String, Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
            // 遍历map
            if (map != null) {
                Set<String> keys = map.keySet();
                for (String key : keys) {
                    int value = map.get(key);
        %>
        <h3>Item: <%=key%>   ; Quantity:<%=value%>
        </h3>
        <%
                }
            }
        %>
        <a href="ClearCart"><h4>Clear</h4></a>
    </body>
</html>
