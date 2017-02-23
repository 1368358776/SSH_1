<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		//1.点击delete时，弹出确定要删除XXX的信息吗？若确定，执行删除，若不确定，则取消
		 $(".delete").click(function(){
			 var lastName = $(this).next(":input").val();
			//取消超链接的默认行为
			var flag = confirm("确定要删除"+lastName+"的信息吗？");
			if(flag){
				var $tr = $(this).parent().parent();
				//删除而且使用ajax的方式	
				var url = this.href;
				var args = {"time":new Date()};
				$.post(url,args,function(data){
					if(data == "1"){
						alert("删除成功！");
						$tr.remove();
					}else{
						alert("删除失败！");
					}
				});
				
			} 
			
			return false;

		});
	});
	
</script>

</head>
<body>
	<h4>Employee Lists Page</h4>
	<s:if test="#request.employees==null||#request.employees.size()== 0">
		没有任何员工信息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>id</td>
				<td>lastname</td>
				<td>email</td>
				<td>birth</td>
				<td>createtime</td>
				<td>dept</td>
				<td>delete</td>
			</tr>
			<s:iterator value="#request.employees">
				<tr>
					<td>${id}</td>
					<td>${lastName}</td>
					<td>${email}</td>
					<td>${birth}</td>
					<td>${createTime}</td>
					<td>${department.departmentName}</td>
					<td>
						<a href="emp-delete?id=${id }" class="delete">Delete</a>
						<input type="hidden" value="${lastName }"/>
					</td>
				</tr>
			
			</s:iterator>
		</table>
	</s:else>
</body>
</html>