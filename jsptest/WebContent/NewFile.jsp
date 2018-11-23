<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<title>Insert title here修改</title>
</head>
<body>
	<% out.println("IP："+request.getRemoteAddr()); %>
	<%! int i=1; %>
	<br/>
	<input type="text" id="txtRowCount">
	<button id="btnQuery">查詢</button>
	<table id="tblInfo">
		<tr>
			<th>用戶ID</th>
			<th>用戶名</th>
		</tr>
	</table>
	<%-- out.println(i); --%>
	<br/>
	<% String r; %>
	<% r=request.getParameter("qq"); %>
	<input type="text" value=<% out.println(r); %>>
	
	<input type="text" value="${result}">
	
	<% out.println(request.getAttribute("qq_req")); %>
	
	<% if(i==11) { %>
		<p>i==11</p>
	<% } else { %> 
		<p>i!=11</p>
	<% } %>
	
	<% 
		switch(i){
		case 11:
			out.println("11");
			break;
		case 12:
			out.println("12");
			break;
		default:
			out.println("0");
		}
	%>
	<br/>
	
	<%= (new java.util.Date()).toLocaleString()%>
	
	<script type="text/javascript">
		$("#btnQuery").click(function(){
			$("#tblInfo tr:not(:first)").remove();
			var dict={}
			
			strRowCount=$("#txtRowCount").val();
			
			dict["row_count"]=strRowCount;
			
			$.ajax({
				url:'Hello',
				type:'POST',
				data:dict,
				dataType:'json',
				async:true,
				success:function(pResult){
					//if(pResult.result=="OK"){
					//	alert("ok");
					//}
					$.each(pResult.emp_info,function(i,info){
						strEmpNo='<td>'+info.strEmpNo+'</td>';
						strEmpName='<td>'+info.strEmpName+'</td>';
						tr='<tr>'+strEmpNo+strEmpName+'</tr>';
						$("#tblInfo").append(tr);
					});
				},
				error:function(pResult){
					alert('NG');
				}
			});
		});
		
		$(document).ready(function(){
			
		});
	</script>
</body>
</html>