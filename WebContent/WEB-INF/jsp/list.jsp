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


<form action="${pageContext.request.contextPath }/customer/list" method="post">
	客户姓名：<br/>
	<input type="text" placeholder="在此输入查询姓名" name="custName" value="${custName }"></input>
	
	<h4>客户来源：</h4>
	<select name="custSource">
		<option value="">--请选择--</option>
		<c:forEach items="${fromType }" var="sources">
		
			<option value="${sources.dict_id }"  <c:if test="sources.dict_id == custSource">selected</c:if>>${sources.dict_id }${sources.dict_item_name}</option>
		</c:forEach>
	</select>
	
	<h4>客户行业：</h4>
	<select name="custIndustry">
		<option value="">--请选择--</option>
		<c:forEach items="${industrySource }" var="item">
			<option value="${item.dict_id }" <c:if test="item.dict_id == custIndustry">selected</c:if>>${item.dict_id}${item.dict_item_name}</option>
		</c:forEach>
	</select>
	
	
	<h4>客户等级：</h4>
	<select name="custLevel">
		<option value="">--请选择--</option>
		<c:forEach items="${levellList }" var="item">
			<option value="${item.dict_id  }" <c:if test="item.dict_id == custLevel">selected</c:if>>${item.dict_id  }${item.dict_item_name}</option>
		</c:forEach>
	</select>
	<br/>
	<input  value="查找" type="submit" />
</form>

<table>
	<tr>
		<th>ID</th>
		<th>客户名称</th>
		<th>客户来源</th>
		<th>客户所属行业</th>
		<th>客户级别</th>
		<th>固定电话</th>
		<th>手机</th>
		<th>操作</th>
	</tr>
	
	<c:forEach items="${page.rows}" var="row">
		<tr>
			<td>${row.cust_id}</td>
			<td>${row.cust_name}</td>
			<td>${row.cust_source}</td>
			<td>${row.cust_industry}</td>
			<td>${row.cust_level}</td>
			<td>${row.cust_phone}</td>
			<td>${row.cust_mobile}</td>
			<td>
				<a href="${pageContext.request.contextPath }/customer/edit/${row.cust_id}">修改</a>
				<a href="${pageContext.request.contextPath }/customer/delete/${row.cust_id}">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>

<c:if test="${page.page > 1}">
	<a href="${pageContext.request.contextPath }/customer/list?currentPage=${page.page-1}">上一页</a>
</c:if>

<c:if test="${page.page < page.total/page.size}">
	<a href="${pageContext.request.contextPath }/customer/list?currentPage=${page.page+1}">下一页</a>
</c:if>

</body>
</html>