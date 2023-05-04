<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>게시글 등록 폼</title>

   <!-- ckeditor 설정 -->
   <script type="text/javascript" 
      src='<c:url value="/ckeditor/ckeditor.js" />'>
   </script>
   
   <script type="text/javascript" 
      src='<c:url value="/ckeditor/config.js" />'>
   </script>

   <style type="text/css">
      * {
         font-size: 12px;
      }
      p {
         width: 600px; 
         text-align: right;
      }
      table{
         border-collapse: collapse; 
      }
      table tbody tr th {
         background-color: #05bcac;
      }
   </style>   
      
   <script type="text/javascript">
      // url을 받아서 해당 url로 이동하는 함수
      function goUrl(url) {
         // location.href : 자바스크립트 페이지 이동
         location.href = url;
      }
      // 등록 폼 체크
      function boardWriteCheck() {
         var form = document.boardWriteForm;
         if (form.subject.value == '') {
            alert('제목을 입력하세요.');
            form.subject.focus();
            return false;
         }
         if (form.writer.value == '') {
            alert('작성자를 입력하세요');
            form.writer.focus();
            return false;
         }
         return true;
      }
   </script>   
   
</head>

<body>
<h3>게시글 등록 화면</h3>
<hr>

   <form name="boardWriteForm" 
      action='<c:url value='/boardWrite' ></c:url>'  
      method="post" 
      onsubmit="return boardWriteCheck();">
   
   <table border="1" summary="게시판 등록 폼">
      <caption>게시글 등록 폼</caption>
      
      <colgroup>
         <col width="100" />
         <col width="500" />
      </colgroup>
      
      <tbody>
         <tr>
            <th align="center">제목</th>
            <td><input type="text" name="subject" size="80" maxlength="100" required /></td>
         </tr>
         <tr>
            <th align="center">작성자</th>
            <td><input type="text" name="writer" maxlength="20" required /></td>
         </tr>
         <tr>
            <td colspan="2">
               <textarea name="contents" cols="80" rows="10">
               </textarea>
               <script>CKEDITOR.replace('contents');</script>
            </td>
         </tr>
      </tbody>
   </table>
   <p>
      <input type="submit" value="저장" onclick="goUrl('<c:url value="/boardWrite"></c:url>')" />
      <input type="button" value="목록" onclick="goUrl('<c:url value="/boardList"></c:url>')" />
   </p>
   </form>
</body>
</html>


