<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
      div.controls {
         margin: 0px 10px;
         font-size: 14px;
         font-family: Tahoma;
         color: #404040;
         height: 80px;
      }
      div#winVP {
         position: relative;
         height: 350px;
         border: 1px solid #dfdfdf;
         margin: 10px;
      }
</style>
<script>
    var winF,popW;
    //외부에서 어떻게 바뀔 지 모르기 때문에 winF;를 설정해 놓은 것이다.
    $(document).ready(function(){
    	winF = new dhtmlXWindows();
    	winF.attachViewportTo("winVP");
    	popW = winF.createWindow("win1",20,30,200,300).show();
    	//createWindow가 리턴 타입이 있기 때문에 show();가 동작할 수 있는 것.
    	popW.hide();
    	popW.setText("폼태그");
    })
    
    function showPopW(){
    	popW.show();
    }
</script>
<body>
    <dir id="winVP"></dir>
    <div class="controls">
        <button onclick="">떠라 창</button>        
    </div>    
</body>
</html>