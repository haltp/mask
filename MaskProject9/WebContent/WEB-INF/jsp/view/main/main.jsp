<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>메인 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script type="text/javascript">


 $(function () {

   $.ajax({
     url: 'http://localhost:8940/MaskProject/getProductServletTest',
     type: 'get',
     dataType: 'json',
     success: showContents,
     error: showErrors
   });

 })

 function showErrors(result) {
   console.log(result)
  
 }

 function showContents(result) { // [{},{},{}]

   //console.log(result)

   let list = result;
   for (val of list) {
     //console.log(val.productNum, val.productName, val.productPrice);
     //console.log(val);
     
     let div1, div2;
     let elem_1, elem_2;
     div1 = $('<div />').addClass("col-md-4 mb-5");
     
     div2 = $('<div />').addClass("card h-100");
     
	elem_1 = $('<div />').addClass("card-body");
	
	let e1_h2 = $('<h2 />').addClass("card-title").html(val.productNum);
    
    elem_2 = $('<div />').addClass("card-footer");
	
	let e2_p = $('<p />').addClass("card-text").html(val.productName);
	
	 let krw_price = new Intl.NumberFormat('ko-KR',
		      { style: 'currency', currency: 'KRW' }).format(val.productPrice);
	
	let e2_h5 = $('<h5 />').html(krw_price);
	
	let e2_h5_2 = $('<h5 />').html(val.productQunt);
	
    
    
    elem_1.append(e1_h2);
    elem_2.append(e2_p);
    elem_2.append(e2_h5);
    elem_2.append(e2_h5_2);
    
    
     
   	 $(div2).append(elem_1);
   	 $(div2).append(elem_2);
     $(div1).append(div2);   
     $('.row').append(div1);
     
   }






 } //end of showContents

 </script>


 <!-- <link rel="stylesheet" type="text/css" href="main.css"> -->
 <style type="text/css">
 cboth {
    /* clear: both; */
    *zoom: 1;
}
.main_section03 {
    width: 100%;
    background-color: #f7f7f7;
    margin: 70px 0px 0px;
    padding-bottom: 30px;
}

.main_section03 .main_title {
    font-size: 26px;
    color: #191e21;
    font-family: 'Roboto Condensed','Nanum Gothic',sans-serif;
    font-weight: 700;
    letter-spacing: 5px;
    height: 100px;
    line-height: 100px;
    padding: 20px 0px;
    text-align: center;
}

div{
padding: 0;
margin: 0;
display: block;

}

body{
font-size: 12px;
    color: #1c1c1c;
    line-height: 1.25;
}

.cboth:after {
    content: " ";
    display: block;
    clear: both;
}

.main_section03 .prd-list {
    
}

.col-md-4 {

margin: 0 auto;
    padding: 0;
    text-align: center;
    position: relative;

}


 </style>



<jsp:include page="menu.jsp"></jsp:include>

</head>
<body>



<div id="wrap">

<!-- Page Content -->
  <div class="container">

    <!--   Heading Row-->
    <div class="row1 align-items-center my-5">
     <div class="col-lg-12">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="img/well001.JPG"  alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="img/well002.JPG"  alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="img/well003.JPG"  alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
        </div>
        </div> 
        


    <!-- Content Row -->
    <div class="cboth main_section03">
    	<div class="cboth main_title">
    	"마스크 BEST"
    	 </div>
    	 <!-- main_title -->
    	 
    	 <div class="cboth prd-list">
    	 <div class="row ">
    
      
    </div>
    <!-- /.row -->
    	 </div>
    
    
    
   
</div>
<!-- main_section03 -->
  </div>
  <!-- /.container -->
 
 </div>
 
   <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  


		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->


	<div>
		<img src="img/네이버톡.png"
			onclick="javascript:window.open('#', 'lunachat', 'width=1024, height=800');"
			style="cursor: pointer; position: fixed; right: 11px; bottom: 11px; z-index: 9999;">
	</div>


	<!-- Bootstrap core JavaScript ! -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<div class="jumbotron text-center" style="margin-bottom:0">
		<p>
			COMPANY : 주식회사 YD / OWNER : 김예담<br> 📞CALL CENTER : 053-421-2460<br>
		</p>
		<p>대구광역시 중구 상서동 22-2 BANK ACCOUNT 💳예담은행 100-010100-01-011 예금주 :
			주식회사 예담</p>
		<a href="#" target="_black" title="인스타그램으로 이동"><img
			src="img/insta.jpg"></a> <a href="#" target="_blank" title="페이스북으로 이동"><img
			src="img/fb.jpg"></a> <a href="#" target="_blank"><img
			src="img/ka.jpg"></a>
	</div>
</body>
</html>