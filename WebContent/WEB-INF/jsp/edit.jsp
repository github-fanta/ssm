<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>

</head>
<body>

<form action="${pageContext.request.contextPath }/customer/update" method="post">
	修改客户：
	<input id="edit_cust_id" type="hidden" name="cust_id" value="${editCustomer.cust_id }"/><br/>
	客户姓名：<input id="edit_customerName" type="text" name="cust_name" value="${editCustomer.cust_name }"/><br/><br/>
	客户来源：<input id="edit_customerFrom" type="text" name="cust_source" value="${editCustomer.cust_source }"><br/><br/>
	所属行业:<input id="edit_custIndustry" type="text" name="cust_industry" value="${editCustomer.cust_industry }"><br/><br/>
	客户级别：<input id="edit_custLevel" type="text" name="cust_level" value="${editCustomer.cust_level }"><br/><br/>
	联系人：<input id="edit_linkMan" type="text" name="cust_linkman" value="${editCustomer.cust_linkman }"/><br/><br/>
	固定电话：<input id="edit_phone" type="text" name="cust_phone" value="${editCustomer.cust_phone }"><br/><br/>
	移动电话:<input id="edit_mobile" type="text" name="cust_mobile" value="${editCustomer.cust_mobile }"><br/><br/>
	邮政编码：<input id="edit_zipcode" type="text" name="cust_zipcode" value="${editCustomer.cust_zipcode }"><br/><br/>
	联系地址：<input id="edit_address" type="text" name="cust_address" value="${editCustomer.cust_address }"><br/><br/>
	<br/>	<br/>	<br/>
	<input type="submit"/>
</form>

</body>
</html>