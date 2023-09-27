<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<title>판매 목록 조회</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script language="javascript" src="/javascript/CommonScript.js"></script>
<script language="JavaScript">

<!--
function fncGetSaleList(arg) {
	// Form 유효성 검증
	if(FormValidation(document.listForm) != false) {
		if(arg == "1")
			document.listForm.pageIndex.value = 1;
	   	document.listForm.action='/getSaleList.do';
	   	document.listForm.submit();	
	}	
}

function fncGetSale(prodNo) {
	document.listForm.prodNo.value = prodNo;
   	document.listForm.action='/getSale.do';
   	document.listForm.submit();		
}
-->
</script>

</head>

<body bgcolor="#ffffff" text="#000000">

<form name="listForm"  method="post">

<!--************************** 컨텐츠 S *****************************-->

<!-- 타이틀 시작 -->
<table width="100%" height="37" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif" width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">판매 목록조회</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif" width="12" height="37"></td>
	</tr>
</table>
<!-- 타이틀 끝 -->

<!-- 검색 시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="right">
			<select name="searchCondition"  style="width:100px">
				<option value="0" <c:if test="${searchVO.searchCondition == '0' }">selected</c:if>>상품번호</option>
				<option value="1" <c:if test="${searchVO.searchCondition == '1' }">selected</c:if>>상품명</option>
			</select>
			<input type="text" name="searchKeyword" value="${searchVO.searchKeyword }"  style="width:150px; height:19px" maxLength="50">
		</td>
		<td align="right" width="150">
			거래상태
			<select name="searchTranStatusCode"  style="width:80px">
				<option value="A">전체</option>
				
				<c:forEach var="tranStatusCode" items="${tranStatusCodeList }">
					<option value="${tranStatusCode.code }" <c:if test="${tranStatusCode.code == searchVO.searchTranStatusCode }">selected</c:if>>${tranStatusCode.codeName }</option>
				</c:forEach>
			</select>		
		</td>
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23"><img src="/images/ct_btnbg01.gif" width="17" height="23"></td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetSaleList();">검색</a>
					</td>
					<td width="14" height="23"><img src="/images/ct_btnbg03.gif" width="14" height="23"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- 검색 끝 -->

<!-- 리스트 시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td class="ct_list_b" width="50">No</td>
		<td class="ct_list_b" width="150">상품번호</td>
		<td class="ct_list_b" width="150">상품명</td>
		<td class="ct_list_b" width="100">판매금액</td>
		<td class="ct_list_b" width="100">거래상태</td>
		<td class="ct_list_b" width="150">등록일자</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
	<c:forEach var="saleVO" items="${saleList }" varStatus="status">
	<tr class="ct_list_pop">
		<td align="center">${status.count }</td>
		<td align="center"><a href="javascript:fncGetSale('${saleVO.prodNo }');">${saleVO.prodNo }</a></td>
		<td align="left">${saleVO.prodName }</td>
		<td align="right" style="padding-right:3px;">${saleVO.sellAmount }</td>
		<td align="center">${saleVO.tranStatusCodeName }</td> 
		<td align="center">${saleVO.regDate }</td> 
	</tr>
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>
	</c:forEach>
</table>
<!-- 선택된 prodNo 값 -->
<input type="hidden" name="prodNo" >
<!-- 리스트 끝 -->

</form>
<script language="JavaScript">
document.listForm.searchKeyword.focus();
</script>
</body>
</html>
