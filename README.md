[![Build Status](https://travis-ci.org/liangyanghe/letv-payorder.svg?branch=master)](https://travis-ci.org/liangyanghe/letv-payorder)

如何运行？
--------

假设本地MySQL数据库的用户名和密码都为root

 * ``git clone https://github.com/liangyanghe/letv-payorder.git``
 * ``cd letv-payorder``
 * ``mysql -uroot -proot < t_order.sql``
 * ``mvn clean jetty:run``
 * 浏览器访问：``localhost:8080``
