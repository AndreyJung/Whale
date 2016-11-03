<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>
</head>
<body>
	 <a href="#this" class="btn" id="send">데이터 전송</a>
     
<%@ include file="/WEB-INF/include/include-body.jsp" %>
    <script type="text/javascript">
	    $(document).ready(function(){
	        $("#send").on("click", function(e){ //글쓰기 버튼
	            e.preventDefault();
	            fn_sendData();
	        }); 
	    });
	    
	    function fn_sendData(obj){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/test/selectIFTest.do' />");
            //comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
            comSubmit.submit();
        }
    </script> 
</body>
</html>