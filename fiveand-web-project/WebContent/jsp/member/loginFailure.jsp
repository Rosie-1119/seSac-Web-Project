<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
alert('로그인에 실패했습니다. 다시 시도해주세요.')
location.href = '${pageContext.request.contextPath }/login.do'
</script>