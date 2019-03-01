<%@ page import="model.CartItem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Kapitan Planeta
  Date: 2019-02-28
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Podsumowanie Zakupów</title>
</head>
<body>
    <h1> PODSUMOWANIE ZAKUPÓW </h1>
    <h2> Lista zakupów</h2>
    <ol>
        <%
            List<CartItem> cart = (List<CartItem>)request.getAttribute("cart");
            for(CartItem item:cart){
        %>
        <li>
            <%=
                String.format("%s, Cena Oryginalna: %.2f, Cena po rabacie: %2f", item.getProduct(), item.getOriginalPrice(), item.getDiscountPrice())
            %>
        </li>

        <%
            }
        %>
    </ol>

    <h2> Suma przed rabatem <%= request.getAttribute("originalSum") %> </h2>
    <h2> Suma po rabacie  <%= request.getAttribute("discountSum")%></h2>
</body>
</html>
