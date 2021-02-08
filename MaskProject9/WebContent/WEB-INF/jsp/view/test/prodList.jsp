<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>메인 페이지</title>
<style>
* {
  transition: all 0.3s ease-out;
}

html,
body {
  height: 100%;
  font-family: "Nunito", sans-serif;
  font-size: 16px;
}

.container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
}

h3 {
  color: #262626;
  font-size: 17px;
  line-height: 24px;
  font-weight: 700;
  margin-bottom: 4px;
}

p {
  font-size: 17px;
  font-weight: 400;
  line-height: 20px;
  color: #666666;

  &.small {
    font-size: 14px;
  }
}



.card {
  display: block;
  top: 0px;
  position: relative;
  max-width: 262px;
  background-color: #f2f8f9;
  border-radius: 4px;
  padding: 32px 24px;
  margin: 12px;
  text-decoration: none;
  z-index: 0;
  overflow: hidden;
  border: 1px solid #f2f8f9;

  &:hover {
    transition: all 0.2s ease-out;
    box-shadow: 0px 4px 8px rgba(38, 38, 38, 0.2);
    top: -4px;
    border: 1px solid #cccccc;
    background-color: white;
  }

  &:before {
    content: "";
    position: absolute;
    z-index: -1;
    top: -16px;
    right: -16px;
    background: #00838d;
    height: 32px;
    width: 32px;
    border-radius: 32px;
    transform: scale(2);
    transform-origin: 50% 50%;
    transition: transform 0.15s ease-out;
  }

  &:hover:before {
    transform: scale(2.15);
  }
}

}
</style>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script type="text/javascript">


 $(function () {

   $.ajax({
     url: '/MaskProject/getProductServletTest',
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
	
	let e1_h2 = $('<h2 />').addClass("card-title");
	let e1_img = $('<img />').attr('src','/MaskProject/img/'+val.image);
	e1_img.addClass("card-img-top");
    
    elem_2 = $('<div />').addClass("card-footer");
	
	let e2_p = $('<p />').addClass("card-text").html(val.productName);
	
	 let krw_price = new Intl.NumberFormat('ko-KR',
		      { style: 'currency', currency: 'KRW' }).format(val.productPrice);
	
	let e2_h5 = $('<h5 />').html(krw_price);
	
	let e2_h5_2 = $('<h5 />').html(val.productQunt);
	
    
    elem_1.append(e1_img);
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
 
 <jsp:include page="../main/menu.jsp"></jsp:include>
 
</head>
<body>


 
 
 
  
  <div class="container">
  
      <!-- Heading Row -->
    <div class="row align-items-center my-5">
      <div class="col-lg-7">
        <img class="img-fluid rounded mb-4 mb-lg-0" src="img/mask1.jpg" alt="">
              
        <br>
      <br>
      <br>
      <br>
      </div>

      <!-- /.col-lg-8 -->
      <div class="col-lg-5">
        <h1 class="font-weight-light">당신이 원하는 마스크</h1>
        <p>이 마스크야 말로 가격과 디자인을 모두 챙긴..</p>
        <a class="btn btn-primary" href="#">구매하세요!</a>
              <br>
      <br>
      <br>
      <br>
      </div>

      
      <!-- /.col-md-4 -->
    </div>
    
    <!-- /.row -->

    <!-- <div class="card text-white bg-secondary my-5 py-4 text-center"> -->
    <!-- Call to Action Well -->
  <!--     <div class="card-body">
        <p class="text-white m-0"> 코로나 바이러스를 효과적으료 예방할수있는 마스크 저희와 함께 하세요. 
      </div>
    </div> -->
  
   <!-- Content Row -->
<!--    <div class="row1">
  	
  </div>  -->
     <!-- /.row -->

  </div>
  <!-- /.container -->
  
  
  
  
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>