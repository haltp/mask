<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootpay.co.kr/js/bootpay-3.3.1.min.js" type="application/javascript"></script>
</head>
<body>
	<script>
		//실제 복사하여 사용시에는 모든 주석을 지운 후 사용하세요
		BootPay.request({
			price : '${vo.productPrice * vo.cartSelect}', //실제 결제되는 가격

			// 관리자로그인 -> 결제설치 -> 인증키 및 보안 -> WEB Application ID
			application_id : "601bb3475b2948002e51f972",

			name : '${vo.productName }', //결제창에서 보여질 이름
			pg : 'nicepay',
			method : '', //결제수단, 입력하지 않으면 결제수단 선택부터 화면이 시작합니다.
			show_agree_window : 0, // 부트페이 정보 동의 창 보이기 여부
			order_id : 'yMask', //고유 주문번호로, 생성하신 값을 보내주셔야 합니다.
		}).error(function(data) {
			//결제 진행시 에러가 발생하면 수행됩니다.
			console.log(data);
		}).cancel(function(data) {
			//결제가 취소되면 수행됩니다.
			alert('결제가 취소되었습니다.');
			window.close();
			console.log(data);
		}).close(function(data) {
			// 결제창이 닫힐때 수행됩니다. (성공,실패,취소에 상관없이 모두 수행됨)
			console.log(data);
		}).done(function(data) {
			//결제가 정상적으로 완료되면 수행됩니다
			frm.submit();
			alert('결제가 정상적으로 완료되었습니다.');
			window.close();
			console.log(data);
		});
	</script>
	<form action="sellInsert.do" name="frm" id="frm">
		<input type="hidden" name="productNum" id="productNum" value="${vo.productNum}">
		<input type="hidden" name="sellQunt" id="sellQunt" value="${vo.cartSelect}">
	</form>
</body>
</html>