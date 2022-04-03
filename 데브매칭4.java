//-- 코드를 입력하세요
//        SELECT p.CART_ID "CART_ID",
//        CASE WHEN SUM(p.PRICE) < c.MINIMUM_REQUIREMENT
//        THEN 1
//        ELSE 0 END AS "ABUSED"
//        FROM CART_PRODUCTS p, COUPONS c
//        WHERE p.CART_ID = c.CART_ID
//        GROUP BY p.CART_ID
//        ORDER BY p.CART_ID