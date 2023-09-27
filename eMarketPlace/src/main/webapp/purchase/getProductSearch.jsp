<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<title>상품 상세조회</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/admin.css" type="text/css">
<script language="javascript" src="/javascript/CommonScript.js"></script>
<script language="JavaScript">

<!--
function fncAddPurchaseView() { 
   	document.detailForm.action='/addPurchaseView.do';
   	document.detailForm.submit();		
}
-->
</script>


</head>

<body bgcolor="#ffffff" text="#000000">

<form name="detailForm"  method="post" enctype="multipart/form-data">
<input type="hidden" name="prodNo" value="${productVO.prodNo }" />
<!--************************** 컨텐츠 S *****************************-->

<!-- 타이틀 시작 -->
<table width="100%" height="37" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif" width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="93%" class="ct_ttl01">상품 상세조회</td>
				<td width="20%" align="right">&nbsp;</td>
			</tr>
		</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif" width="12" height="37"></td>
	</tr>
</table>
<!-- 타이틀 끝 -->

<!-- 상세 테이블시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:13px;">
	<tr>
		<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"> 
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">상품번호 </td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">${productVO.prodNo }</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">상품명 </td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">${productVO.prodName }</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">상품분류</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">${productVO.categoryNo }</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>	
				<tr>
					<td width="104" class="ct_write">제조일자</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">${productVO.manufactureDay }</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">상세정보</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">${productVO.prodDetail }</td>
				</tr>					
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>	
				<tr>
					<td width="104" class="ct_write">판매수량</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">${productVO.sellQuantity }</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>		
				<tr>
					<td width="104" class="ct_write">판매금액</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">${productVO.sellAmount }</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>	
				<tr>
					<td width="104" class="ct_write">A/S 가능여부</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">${productVO.asYn }</td>
				</tr> 
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
			</table>
		</td>
		
		<td width="300" valign="high">
			<div style="width:300px;overflow:hidden">
				<img src="images/upload_files/productImage/${productVO.imageFile }" alt="상품 이미지" border="0" width="300" height="200"/>
			</div>
		</td>
	</tr>				
</table>
<!-- 등록테이블 끝 -->

<!-- 기존 목록조회 화면의 검색조건 유지 -->
<%--  
<input type="hidden" name="searchCondition" value="<%= EmpUtil.null2str(searchVO.getSearchCondition()) %>">
<input type="hidden" name="searchKeyword" value="<%= EmpUtil.null2str(searchVO.getSearchKeyword()) %>">
<input type="hidden" name="pageIndex" value="<%= searchVO.getPageIndex() %>">
<input type="hidden" name="searchAsYn" value="<%= searchVO.getSearchAsYn() %>">
--%>

<!-- 버튼 시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="margin-top:10px;">
	<tr>
		<td width="53%">
		
		</td>
		<td align="right">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23"><img src="/images/ct_btnbg01.gif" width="17" height="23"></td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;"><a href="getProductSearchList.do">목록</a></td>
					<td width="14" height="23"><img src="/images/ct_btnbg03.gif" width="14" height="23"></td>

					<td width="30"></td>
										
					<td width="17" height="23"><img src="/images/ct_btnbg01.gif" width="17" height="23"></td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;"><a href="javascript:fncAddPurchaseView();">구매</a></td>
					<td width="14" height="23"><img src="/images/ct_btnbg03.gif" width="14" height="23"></td>
					
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- 버튼 끝 -->

</form>

</body>
</html>
