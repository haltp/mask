package co.mask.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.cart.web.BootPay;
import co.mask.cart.web.CartDelete;
import co.mask.cart.web.CartView;
import co.mask.cart.web.NonMemberBootPay;
import co.mask.cart.web.NonMemberCart;
import co.mask.join.web.IdCheck;
import co.mask.join.web.Join;
import co.mask.join.web.JoinForm;
import co.mask.login.web.Login;
import co.mask.login.web.LoginForm;
import co.mask.main.MainPage;
import co.mask.main.Menu;
import co.mask.product.web.DeleteExec;
import co.mask.product.web.Insertexec;
import co.mask.product.web.ShowProduct;
import co.mask.product.web.ToInsertProduct;
import co.mask.product.web.ToUpdateProduct;
import co.mask.product.web.UpdateExec;
import co.mask.sell.web.SellInsert;
import co.mask.sell.web.BuyerView;
import co.mask.sell.web.SellerView;


@WebServlet("/FrontController2")
public class FrontController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontController2() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		//Main
		map.put("/main.do", new MainPage());
		//Member
		map.put("/joinForm.do", new JoinForm());	//회원가입 폼 호출
		map.put("/idCheck.do", new IdCheck());	//아이디 중복체크
		map.put("/join.do", new Join()); 	//회원가입
		map.put("/loginForm.do", new LoginForm());	//로그인 폼 호출
		map.put("/login.do", new Login()); 	//로그인
		map.put("/menu.do", new Menu()); //메뉴 확인하려고 index에서 바로 menu로 변경해보았습니다.
		//Cart
		map.put("/cartView.do", new CartView()); // 장바구니 리스트 페이지
		map.put("/bootPay.do", new BootPay()); // bootPay 결제
		map.put("/cartDelete.do", new CartDelete()); // 장바구니 삭제
		map.put("/nonMemberBootPay.do", new NonMemberBootPay()); // 비회원 결제
		map.put("/nonMemberCart.do", new NonMemberCart()); // 비회원 장바구니
		//Sell
		map.put("/buyerView.do", new BuyerView()); // 판매 내역 리스트 (구매자)
		map.put("/sellInsert.do", new SellInsert()); // 판매 내역 입력
		map.put("/sellerView.do", new SellerView()); // 판매 내역 리스트 (판매자) 
		//Product
		map.put("/showProduct.do", new ShowProduct()); //상품목록 조회
		map.put("/toInsertProduct.do", new ToInsertProduct()); //상품등록 화면 가기
		map.put("/insertExec.do", new Insertexec()); //상품등록
		map.put("/toUpdateProduct.do", new ToUpdateProduct()); //상품수정 화면 가기
		map.put("/updateExec.do", new UpdateExec()); //상품수정
		map.put("/deleteExec.do", new DeleteExec()); //상품삭제
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contexPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contexPath.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
