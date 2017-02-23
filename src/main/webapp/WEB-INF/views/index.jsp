<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<body>
    <form method="post" action="/addOrder">
        <div>
            用户ID<input type="text" name="userId">
        </div>
        <div>
            价格<input type="text" name="price">
        </div>
        <div>
            <input type="submit" value="创建订单">
        </div>
    </form>
</body>