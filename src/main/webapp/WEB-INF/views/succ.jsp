<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <div>
        <a href="/">返回</a>
    </div>
    <div>
        创建订单成功
    </div>
    <div>
        订单ID：${orderId}
    </div>
    <div>
        所在数据库：db${dbInfo}
    </div>
    <div>
        所在表：t_order_${tableInfo}
    </div>
</body>