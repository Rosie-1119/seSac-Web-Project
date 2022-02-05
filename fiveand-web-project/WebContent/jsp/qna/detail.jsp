<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>문의글 상세 페이지</title>

<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/bootstrap.min.css" />

<!-- Slick -->
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/slick.css" />
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/slick-theme.css" />

<!-- nouislider -->
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/nouislider.min.css" />

<!-- Font Awesome Icon -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/font-awesome.min.css">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/style.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->



<!-- 모달창 관련 -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/simple-modal.min.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/simple-modal-default.min.css">
<script
	src="${ pageContext.request.contextPath }/js/simple-modal.min.js">
</script>
<script>

function doAction(type) {
	switch(type) {
		case 'U':
			location.href="${ pageContext.request.contextPath }/qna/updateForm.do?bNo=${result.bNo}"
			break;
		case 'D':
			location.href="${ pageContext.request.contextPath }/qna/delete.do?bNo=${result.bNo}&pdNo=${result.pdNo}"
			break;
		case 'R':
			//location.href="reply.jsp?id=${ param.id }"
			$('#qnaReplyForm').css('display', 'block');
			break;
		case 'L':
			location.href="${ pageContext.request.contextPath }/auction/detail.do?no=${result.pdNo}"
			break;
	}
}

function doWrite(){
	let f = document.inputForm

	if(f.title.value == ''){
		alert('제목을 입력하세요')
		f.title.focus()
		return false
	}
	if(f.content.value == ''){
		alert('내용 입력하세요')
		f.content.focus()
		return false
	}
	else{
		alert('답글 등록이 완료되었습니다!')
	}

	return true
}

</script>

<style>
.bttn {
  display: inline-block;
  padding: 8px 20px;
  background-color: #FFF;
  border-color: #E4E7ED;
  border-radius: 15px;
  color: #000;
  font-weight: 700;
  text-align: center;
  -webkit-transition: 0.2s all;
  transition: 0.2s all;
}
</style>

</head>
<body>
	<!-- HEADER -->
	<c:choose>
		<c:when test="${ userVO.type eq 'A' }">
			<header>
				<jsp:include page="/jsp/include/topMenuAdmin.jsp" />
			</header>
		</c:when>
		<c:otherwise>
			<header>
				<jsp:include page="/jsp/include/topMenu.jsp" />
			</header>
		</c:otherwise>
	</c:choose>
	<!-- /HEADER -->
	<!-- BREADCRUMB -->
		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<h3 class="breadcrumb-header">QnA Page</h3>
						<ul class="breadcrumb-tree">
							<li><a href="${ pageContext.request.contextPath }/auction/detail.do?no=${result.pdNo}">List</a></li>
							<li class="active">Current Page</li>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->
		
	<section>
		<div align = "center">
		
		<br>
			
			<table border="1" width="900px" class="list">
				<tr>
					<th width="10%"><center>제목</center></th>
					<td width="50%">&nbsp;&nbsp;${ result.title }</td>
					<th width="10%"><center>작성자</center></th>
					<td width="10%">&nbsp;&nbsp;${ result.id }</td>
					<th width="10%"><center>등록일</center></th>
					<td width="10%"><center>${ result.regDate }</center></td>
				</tr>
				<tr>
					<td width="90%" height="200px" colspan="6">${ result.content }</td>
				</tr>
			</table>
			<table border="1" width="900px" id="reply_area">
				<tr reply_type="all">
					<!-- 뒤에 댓글 붙이기 쉽게 선언 -->
					<td colspan="4"></td>
				</tr>
				<!-- 댓글이 들어갈 공간 -->
			</table>
			<table border="1" width="900px">
				<tr>
					<td width="500px">ID: ${userVO.id }&nbsp;&nbsp;&nbsp;
						<button id="reply_save" name="reply_save">댓글 등록</button>
					</td>
				</tr>
				<tr>
					<td><textarea id="reply_content" name="reply_content" rows="4"
							cols="50" placeholder="댓글을 입력하세요."></textarea></td>
				</tr>
			</table>
			<br>
			
		<c:if test="${ result.id eq userVO.id }">
			<button class="bttn" onclick="doAction('U')">수정</button>
			<button class="bttn"onclick="doAction('D')">삭제</button>
			<button class="bttn"onclick="doAction('R')">답글</button>
			<!-- request 영역에 등록되어 있는 product.id 를 어떻게 가져오는지? -->
			
		</c:if>
			<button class="bttn" onclick="doAction('L')">목록</button>
		</div>
		
		<!-- 댓글 기능 -->
		<!-- <div class="input-group" role="group" style="margin-top: 10px; width: 100%;">
			<textarea class="form-control" rows="3" id="commentContent"
				placeholder="댓글을 입력하세요." style="width: 70%;"></textarea>
			<div class="btn-group btn-group-sm" role="group">
			
				<c:if test="${userVO.id == null}">
					<input type="button" class="btn btn-default" value="댓글 쓰기"
						disabled="disabled">
				</c:if>
				
				<c:if test="${userVO.id != null}">
					<input type="button" class="btn btn-default" value="댓글 쓰기"
						id="commentWrite">
				</c:if>
				
				<input type="button" class="btn btn-default"
					value="댓글 읽기"
					onclick="getComment(1, event)" id="commentRead">
			</div>
		</div> -->

		<!-- Comment 태그 추가 -->
		<!-- <div class="input-group" role="group" style="margin-top: 10px; width: 100%;">
			<div id="showComment" style="text-align: center;"></div>
		</div> -->
		
		<br><br>

		
		
		

		<div align="center" id="qnaReplyForm">
			<hr>
			<h2>답글 등록</h2>
			<hr>
			<br>
			<!-- submit이라는 타입을 가진 것을 눌렀을 때 실행되도록 하는 메소드 onsubmit -->
			<form action="${ pageContext.request.contextPath }/qna/reply.do"
				method="post" name="inputForm" onsubmit="return doWrite()">
				
				<input type="hidden" name="id" value="${ userVO.id }">
				<input type="hidden" name="pdNo" value="${ result.pdNo }">
				<input type="hidden" name="groupId" value="${ result.groupId }"> 
				<input type="hidden" name="depth" value="${ result.depth }"> 
				<input type="hidden" name="pos" value="${ result.pos }">
				

				<table border="1">
					<tr>
						<th width=23%>제목</th>
						<td>
							<input type="text" name="title" value="	&#8627;[Re]&nbsp;" required>
						</td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td>${ userVO.id }
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" rows="10" cols="60" placeholder="글을 적어 주세요." required></textarea></td>
					</tr>
				</table>
				<br> 
				<input type="submit" value="답글등록">
				<input type="button" value="취소" onclick="doAction('L')">
					
			</form>
		</div>
	</section>
	
	
	<!-- FOOTER -->
	<footer id="footer">
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
	<!-- /FOOTER -->

	<!-- jQuery Plugins -->
	<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script src="${ pageContext.request.contextPath }/js/slick.min.js"></script>
	<script src="${ pageContext.request.contextPath }/js/nouislider.min.js"></script>
	<script src="${ pageContext.request.contextPath }/js/main.js"></script>
	
	<script>
	//댓글 script
 $(document).ready(function(){
            	
            	var reply_count = 0; //원래 DB에 저장하고 저장 아이디 번호를 넘겨줘야 하는데 DB 없이 댓글 소스만 있어 DB 에서 아이디 증가하는것처럼 스크립트에서 순번을 생성
            	var status = false; //수정과 대댓글을 동시에 적용 못하도록
                 
                $("#list").click(function(){
                	alert("게시판 리스트로 이동");
                    //location.href = "/board/list";
                });
                 
                //댓글 저장
                $("#reply_save").click(function(){
                     
                    //널 검사
                    if($("#reply_writer").val().trim() == ""){
                        alert("이름을 입력하세요.");
                        $("#reply_writer").focus();
                        return false;
                    }
                     
                    if($("#reply_password").val().trim() == ""){
                        alert("패스워드를 입력하세요.");
                        $("#reply_password").focus();
                        return false;
                    }
                     
                    if($("#reply_content").val().trim() == ""){
                        alert("내용을 입력하세요.");
                        $("#reply_content").focus();
                        return false;
                    }
                     
                    var reply_content = $("#reply_content").val().replace("\n", "<br>"); //개행처리
                     
                    //값 셋팅
                    var objParams = {
                            board_id        : $("#board_id").val(),
                            parent_id       : "0",  
                            depth           : "0",
                            reply_writer    : $("#reply_writer").val(),
                            reply_password  : $("#reply_password").val(),
                            reply_content   : reply_content
                    };
                     
                    var reply_id;
                     
                    //ajax 호출 (여기에 댓글을 저장하는 로직을 개발)
                    /*
                    $.ajax({
                        url         :   "/board/reply/save",
                        dataType    :   "json",
                        contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
                        type        :   "post",
                        async       :   false, //동기: false, 비동기: ture
                        data        :   objParams,
                        success     :   function(retVal){
 
                            if(retVal.code != "OK") {
                                alert(retVal.message);
                            }else{
                                reply_id = retVal.reply_id;
                            }
                             
                        },
                        error       :   function(request, status, error){
                            console.log("AJAX_ERROR");
                        }
                    });
                    */
                    
                    
                    reply_id = reply_count++;//DB에 저장했다 하고 순번을 생성
                    
                    var reply_area = $("#reply_area");
                     
                    var reply = 
                        '<tr reply_type="main">'+
                        '   <td width="820px">'+
                        reply_content+
                        '   </td>'+
                        '   <td width="100px">'+
                        $("#reply_writer").val()+
                        '   </td>'+
                        '   <td width="100px">'+
                        '       <input type="password" id="reply_password_'+reply_id+'" style="width:100px;" maxlength="10" placeholder="패스워드"/>'+
                        '   </td>'+
                        '   <td align="center">'+
                        '       <button name="reply_reply" reply_id = "'+reply_id+'">댓글</button>'+
                        '       <button name="reply_modify" r_type = "main" reply_id = "'+reply_id+'">수정</button>      '+
                        '       <button name="reply_del" reply_id = "'+reply_id+'">삭제</button>      '+
                        '   </td>'+
                        '</tr>';
                         
                     if($('#reply_area').contents().size()==0){
                         $('#reply_area').append(reply);
                     }else{
                         $('#reply_area tr:last').after(reply);
                     }
 
                    //댓글 초기화
                    $("#reply_writer").val("");
                    $("#reply_password").val("");
                    $("#reply_content").val("");
                     
                });
                 
                //댓글 삭제
                $(document).on("click","button[name='reply_del']", function(){
                     
                    var check = false;
                    var reply_id = $(this).attr("reply_id");
                    var reply_password = "reply_password_"+reply_id;
                     
                    if($("#"+reply_password).val().trim() == ""){
                        alert("패스워드을 입력하세요.");
                        $("#"+reply_password).focus();
                        return false;
                    }
                     
                    //패스워드와 아이디를 넘겨 삭제를 한다.
                    //값 셋팅
                    var objParams = {
                            reply_password  : $("#"+reply_password).val(),
                            reply_id        : reply_id
                    };
                     
                    //ajax 호출
                    /*
                    $.ajax({
                        url         :   "/board/reply/del",
                        dataType    :   "json",
                        contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
                        type        :   "post",
                        async       :   false, //동기: false, 비동기: ture
                        data        :   objParams,
                        success     :   function(retVal){
 
                            if(retVal.code != "OK") {
                                alert(retVal.message);
                            }else{
                                 
                                check = true;
                                                                 
                            }
                             
                        },
                        error       :   function(request, status, error){
                            console.log("AJAX_ERROR");
                        }
                    });
                    */
                    
                    check = true;//삭제 되면 체크값을 true로 변경
                     
                    if(check){
                        //삭제하면서 하위 댓글도 삭제
                        var prevTr = $(this).parent().parent().next(); //댓글의 다음
                         
                        while(prevTr.attr("reply_type")=="sub"){//댓글의 다음이 sub면 계속 넘어감
                            prevTr = prevTr.next();
                            prevTr.prev().remove();
                        }
                         
                        //마지막 리플 처리
                        if(prevTr.attr("reply_type") == undefined){
                            prevTr = $(this).parent().parent();
                            prevTr.remove();
                        }
                         
                        $(this).parent().parent().remove(); 
                    }
                     
                });
                
                //댓글 수정 입력
                $(document).on("click","button[name='reply_modify']", function(){
                	
                    var check = false;
                    var reply_id = $(this).attr("reply_id");
                    var r_type = $(this).attr("r_type");
                    var reply_password = "reply_password_"+reply_id;
                     
                    if($("#"+reply_password).val().trim() == ""){
                        alert("패스워드을 입력하세요.");
                        $("#"+reply_password).focus();
                        return false;
                    }
                     
                    //패스워드와 아이디를 넘겨 패스워드 확인
                    //값 셋팅
                    var objParams = {
                            reply_password  : $("#"+reply_password).val(),
                            reply_id        : reply_id
                    };
                     
                    //ajax 호출
                    /*
                    $.ajax({
                        url         :   "/board/reply/check",
                        dataType    :   "json",
                        contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
                        type        :   "post",
                        async       :   false, //동기: false, 비동기: ture
                        data        :   objParams,
                        success     :   function(retVal){
 
                            if(retVal.code != "OK") {
                                alert(retVal.message);
                            }else{
                                 
                                check = true;
                                                                 
                            }
                             
                        },
                        error       :   function(request, status, error){
                            console.log("AJAX_ERROR");
                        }
                    });
                    */
                    
                    check = true;//패스워드가 맞으면 체크값을 true로 변경
                    
                    if(status){
                		alert("수정과 대댓글은 동시에 불가합니다.");
                		return false;
                	}
                	
                	status = true;
                    
                    if(check){
                    	//자기 위에 댓글 수정창 입력하고 기존값을 채우고 자기 자신 삭제
                    	var txt_reply_content = $(this).parent().prev().prev().prev().html().trim(); //댓글내용 가져오기
                    	if(r_type=="sub"){
                    		txt_reply_content = txt_reply_content.replace("→ ","");//대댓글의 뎁스표시(화살표) 없애기
                    	}
                    	
                    	var txt_reply_writer = $(this).parent().prev().prev().html().trim(); //댓글작성자 가져오기
                    	
                    	//입력받는 창 등록
                        var replyEditor = 
                           '<tr id="reply_add" class="reply_modify">'+
                           '   <td width="820px">'+
                           '       <textarea name="reply_modify_content_'+reply_id+'" id="reply_modify_content_'+reply_id+'" rows="3" cols="50">'+txt_reply_content+'</textarea>'+ //기존 내용 넣기
                           '   </td>'+
                           '   <td width="100px">'+
                           '       <input type="text" name="reply_modify_writer_'+reply_id+'" id="reply_modify_writer_'+reply_id+'" style="width:100%;" maxlength="10" placeholder="작성자" value="'+txt_reply_writer+'"/>'+ //기존 작성자 넣기
                           '   </td>'+
                           '   <td width="100px">'+
                           '       <input type="password" name="reply_modify_password_'+reply_id+'" id="reply_modify_password_'+reply_id+'" style="width:100%;" maxlength="10" placeholder="패스워드"/>'+
                           '   </td>'+
                           '   <td align="center">'+
                           '       <button name="reply_modify_save" r_type = "'+r_type+'" reply_id="'+reply_id+'">등록</button>'+
                           '       <button name="reply_modify_cancel" r_type = "'+r_type+'" r_content = "'+txt_reply_content+'" r_writer = "'+txt_reply_writer+'" reply_id="'+reply_id+'">취소</button>'+
                           '   </td>'+
                           '</tr>';
                        var prevTr = $(this).parent().parent();
                       	//자기 위에 붙이기
                        prevTr.after(replyEditor);
                        
                        //자기 자신 삭제
                        $(this).parent().parent().remove(); 
                    }
                     
                });
                //댓글 수정 취소
                $(document).on("click","button[name='reply_modify_cancel']", function(){
                	//원래 데이터를 가져온다.
                	var r_type = $(this).attr("r_type");
                	var r_content = $(this).attr("r_content");
                	var r_writer = $(this).attr("r_writer");
                	var reply_id = $(this).attr("reply_id");
                	
                	var reply;
                	//자기 위에 기존 댓글 적고 
                	if(r_type=="main"){
                		reply = 
                            '<tr reply_type="main">'+
                            '   <td width="820px">'+
                            r_content+
                            '   </td>'+
                            '   <td width="100px">'+
                            r_writer+
                            '   </td>'+
                            '   <td width="100px">'+
                            '       <input type="password" id="reply_password_'+reply_id+'" style="width:100px;" maxlength="10" placeholder="패스워드"/>'+
                            '   </td>'+
                            '   <td align="center">'+
                            '       <button name="reply_reply" reply_id = "'+reply_id+'">댓글</button>'+
                            '       <button name="reply_modify" r_type = "main" reply_id = "'+reply_id+'">수정</button>      '+
                            '       <button name="reply_del" reply_id = "'+reply_id+'">삭제</button>      '+
                            '   </td>'+
                            '</tr>';
                	}else{
                		reply = 
                            '<tr reply_type="sub">'+
                            '   <td width="820px"> → '+
                            r_content+
                            '   </td>'+
                            '   <td width="100px">'+
                            r_writer+
                            '   </td>'+
                            '   <td width="100px">'+
                            '       <input type="password" id="reply_password_'+reply_id+'" style="width:100px;" maxlength="10" placeholder="패스워드"/>'+
                            '   </td>'+
                            '   <td align="center">'+
                            '       <button name="reply_modify" r_type = "sub" reply_id = "'+reply_id+'">수정</button>'+
                            '       <button name="reply_del" reply_id = "'+reply_id+'">삭제</button>'+
                            '   </td>'+
                            '</tr>';
                	}
                	
                	var prevTr = $(this).parent().parent();
                   	//자기 위에 붙이기
                    prevTr.after(reply);
                   	
                  	//자기 자신 삭제
                    $(this).parent().parent().remove(); 
                  	
                    status = false;
                	
                });
                
              	//댓글 수정 저장
                $(document).on("click","button[name='reply_modify_save']", function(){
                	
                	var reply_id = $(this).attr("reply_id");
                	
                	//널 체크
                    if($("#reply_modify_writer_"+reply_id).val().trim() == ""){
                        alert("이름을 입력하세요.");
                        $("#reply_modify_writer_"+reply_id).focus();
                        return false;
                    }
                     
                    if($("#reply_modify_password_"+reply_id).val().trim() == ""){
                        alert("패스워드를 입력하세요.");
                        $("#reply_modify_password_"+reply_id).focus();
                        return false;
                    }
                     
                    if($("#reply_modify_content_"+reply_id).val().trim() == ""){
                        alert("내용을 입력하세요.");
                        $("#reply_modify_content_"+reply_id).focus();
                        return false;
                    }
                	//DB에 업데이트 하고
                	//ajax 호출 (여기에 댓글을 저장하는 로직을 개발)
                	var reply_content = $("#reply_modify_content_"+reply_id).val().replace("\n", "<br>"); //개행처리
                    
                	var r_type = $(this).attr("r_type");
                	
                	var parent_id;
                	var depth;
                	if(r_type=="main"){
                		parent_id = "0";
                		depth = "0";
                	}else{
                		parent_id = $(this).attr("reply_id");
                		depth = "1";
                	}
                	
                    //값 셋팅
                    var objParams = {
                            board_id        : $("#board_id").val(),
                            parent_id       : parent_id, 
                            depth           : depth,
                            reply_writer    : $("#reply_modify_writer_"+reply_id).val(),
                            reply_password  : $("#reply_modify_password_"+reply_id).val(),
                            reply_content   : reply_content
                    };
                    /*
                    $.ajax({
                        url         :   "/board/reply/update",
                        dataType    :   "json",
                        contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
                        type        :   "post",
                        async       :   false, //동기: false, 비동기: ture
                        data        :   objParams,
                        success     :   function(retVal){
 
                            if(retVal.code != "OK") {
                                alert(retVal.message);
                            }else{
                                reply_id = retVal.reply_id;
                            }
                             
                        },
                        error       :   function(request, status, error){
                            console.log("AJAX_ERROR");
                        }
                    });
                    */
                	//수정된댓글 내용을 적고
                    if(r_type=="main"){
                		reply = 
                            '<tr reply_type="main">'+
                            '   <td width="820px">'+
                            $("#reply_modify_content_"+reply_id).val()+
                            '   </td>'+
                            '   <td width="100px">'+
                            $("#reply_modify_writer_"+reply_id).val()+
                            '   </td>'+
                            '   <td width="100px">'+
                            '       <input type="password" id="reply_password_'+reply_id+'" style="width:100px;" maxlength="10" placeholder="패스워드"/>'+
                            '   </td>'+
                            '   <td align="center">'+
                            '       <button name="reply_reply" reply_id = "'+reply_id+'">댓글</button>'+
                            '       <button name="reply_modify" r_type = "main" reply_id = "'+reply_id+'">수정</button>      '+
                            '       <button name="reply_del" reply_id = "'+reply_id+'">삭제</button>      '+
                            '   </td>'+
                            '</tr>';
                	}else{
                		reply = 
                            '<tr reply_type="sub">'+
                            '   <td width="820px"> → '+
                            $("#reply_modify_content_"+reply_id).val()+
                            '   </td>'+
                            '   <td width="100px">'+
                            $("#reply_modify_writer_"+reply_id).val()+
                            '   </td>'+
                            '   <td width="100px">'+
                            '       <input type="password" id="reply_password_'+reply_id+'" style="width:100px;" maxlength="10" placeholder="패스워드"/>'+
                            '   </td>'+
                            '   <td align="center">'+
                            '       <button name="reply_modify" r_type = "sub" reply_id = "'+reply_id+'">수정</button>'+
                            '       <button name="reply_del" reply_id = "'+reply_id+'">삭제</button>'+
                            '   </td>'+
                            '</tr>';
                	}
                    
                    var prevTr = $(this).parent().parent();
                   	//자기 위에 붙이기
                    prevTr.after(reply);
                   	
                  	//자기 자신 삭제
                    $(this).parent().parent().remove(); 
                  	
                    status = false;
                	
                });
                 
                //대댓글 입력창
                $(document).on("click","button[name='reply_reply']",function(){ //동적 이벤트
                	
                	if(status){
                		alert("수정과 대댓글은 동시에 불가합니다.");
                		return false;
                	}
                	
                	status = true;
                     
                    $("#reply_add").remove();
                     
                    var reply_id = $(this).attr("reply_id");
                    var last_check = false;//마지막 tr 체크
                     
                    //입력받는 창 등록
                    var replyEditor = 
                       '<tr id="reply_add" class="reply_reply">'+
                       '   <td width="820px">'+
                       '       <textarea name="reply_reply_content" rows="3" cols="50"></textarea>'+
                       '   </td>'+
                       '   <td width="100px">'+
                       '       <input type="text" name="reply_reply_writer" style="width:100%;" maxlength="10" placeholder="작성자"/>'+
                       '   </td>'+
                       '   <td width="100px">'+
                       '       <input type="password" name="reply_reply_password" style="width:100%;" maxlength="10" placeholder="패스워드"/>'+
                       '   </td>'+
                       '   <td align="center">'+
                       '       <button name="reply_reply_save" reply_id="'+reply_id+'">등록</button>'+
                       '       <button name="reply_reply_cancel">취소</button>'+
                       '   </td>'+
                       '</tr>';
                         
                    var prevTr = $(this).parent().parent().next();
                     
                    //부모의 부모 다음이 sub이면 마지막 sub 뒤에 붙인다.
                    //마지막 리플 처리
                    if(prevTr.attr("reply_type") == undefined){
                        prevTr = $(this).parent().parent();
                    }else{
                        while(prevTr.attr("reply_type")=="sub"){//댓글의 다음이 sub면 계속 넘어감
                            prevTr = prevTr.next();
                        }
                         
                        if(prevTr.attr("reply_type") == undefined){//next뒤에 tr이 없다면 마지막이라는 표시를 해주자
                            last_check = true;
                        }else{
                            prevTr = prevTr.prev();
                        }
                         
                    }
                     
                    if(last_check){//마지막이라면 제일 마지막 tr 뒤에 댓글 입력을 붙인다.
                        $('#reply_area tr:last').after(replyEditor);    
                    }else{
                        prevTr.after(replyEditor);
                    }
                     
                });
                 
                //대댓글 등록
                $(document).on("click","button[name='reply_reply_save']",function(){
                                         
                    var reply_reply_writer = $("input[name='reply_reply_writer']");
                    var reply_reply_password = $("input[name='reply_reply_password']");
                    var reply_reply_content = $("textarea[name='reply_reply_content']");
                    var reply_reply_content_val = reply_reply_content.val().replace("\n", "<br>"); //개행처리
                     
                    //널 검사
                    if(reply_reply_writer.val().trim() == ""){
                        alert("이름을 입력하세요.");
                        reply_reply_writer.focus();
                        return false;
                    }
                     
                    if(reply_reply_password.val().trim() == ""){
                        alert("패스워드를 입력하세요.");
                        reply_reply_password.focus();
                        return false;
                    }
                     
                    if(reply_reply_content.val().trim() == ""){
                        alert("내용을 입력하세요.");
                        reply_reply_content.focus();
                        return false;
                    }
                     
                    //값 셋팅
                    var objParams = {
                            board_id        : $("#board_id").val(),
                            parent_id       : $(this).attr("reply_id"), 
                            depth           : "1",
                            reply_writer    : reply_reply_writer.val(),
                            reply_password  : reply_reply_password.val(),
                            reply_content   : reply_reply_content_val
                    };
                     
                    var reply_id;
                     
                    //ajax 호출
                    /*
                    $.ajax({
                        url         :   "/board/reply/save",
                        dataType    :   "json",
                        contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
                        type        :   "post",
                        async       :   false, //동기: false, 비동기: ture
                        data        :   objParams,
                        success     :   function(retVal){
 
                            if(retVal.code != "OK") {
                                alert(retVal.message);
                            }else{
                                reply_id = retVal.reply_id;
                            }
                             
                        },
                        error       :   function(request, status, error){
                            console.log("AJAX_ERROR");
                        }
                    });
                    */
                    
                    reply_id = reply_count++;//DB에 저장했다 하고 순번을 생성
                     
                    var reply = 
                        '<tr reply_type="sub">'+
                        '   <td width="820px"> → '+
                        reply_reply_content_val+
                        '   </td>'+
                        '   <td width="100px">'+
                        reply_reply_writer.val()+
                        '   </td>'+
                        '   <td width="100px">'+
                        '       <input type="password" id="reply_password_'+reply_id+'" style="width:100px;" maxlength="10" placeholder="패스워드"/>'+
                        '   </td>'+
                        '   <td align="center">'+
                        '       <button name="reply_modify" r_type = "sub" reply_id = "'+reply_id+'">수정</button>'+
                        '       <button name="reply_del" reply_id = "'+reply_id+'">삭제</button>'+
                        '   </td>'+
                        '</tr>';
                         
                    var prevTr = $(this).parent().parent().prev();
                     
                    prevTr.after(reply);
                                         
                    $("#reply_add").remove();
                    
                    status = false;
                     
                });
                 
                //대댓글 입력창 취소
                $(document).on("click","button[name='reply_reply_cancel']",function(){
                    $("#reply_add").remove();
                    
                    status = false;
                });
 });
	
</script>
	
	
</body>
</html>