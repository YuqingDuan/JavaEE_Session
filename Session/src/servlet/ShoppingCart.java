package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取要添加到购物车的商品的id
        int id = Integer.parseInt(request.getParameter("id"));
        String[] names = {"Iphone7", "Vivo3", "Huawei10", "Nokia", "Iphone6s"};
        String name = names[id];

        // 2.获取购物车存放东西的session Map<String, Integer>  iphone6s 3
        // 把一个map对象存放到session里面去，并且保证仅存一次
        Map<String, Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
        // session里面没有存放过任何商品
        if (map == null) {
            map = new LinkedHashMap<>();
            request.getSession().setAttribute("cart", map);
        }

        // 3.判断购物车里面有没有该商品
        if (map.containsKey(name)) {
            // 在原来的值的基础上+1
            map.put(name, map.get(name) + 1);
        } else {
            // 没有购买过该商品，当前数量为1
            map.put(name, 1);
        }

        // 4. 输出界面（跳转）
        response.getWriter().write("<a href='product_list.jsp'><h3>Continue Shopping</h3></a><br>");
        response.getWriter().write("<a href='cart.jsp'><h3>Pay</h3></a><br>");
    }
}
