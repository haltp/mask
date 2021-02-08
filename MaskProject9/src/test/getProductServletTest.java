package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;


@WebServlet("/getProductServletTest")
public class getProductServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public getProductServletTest() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		
		
		
		//showProduct.do 처리 메소드
				ProductDao dao = new ProductDao();
				ArrayList<ProductVo> list = new ArrayList<ProductVo>();
				list=dao.selectList();
				//request.setAttribute("list", list);
				
				String json = "[";
				int cnt =1;
				for(ProductVo prd : list) {
					json += "{";
					
					json += "\"productNum\":\""+ prd.getProductNum()+"\"";
					json += ",\"productName\":\""+ prd.getProductName()+"\"";
					json += ",\"productPrice\":\""+ prd.getProductPrice()+"\"";
					json += ",\"productQunt\":\""+ prd.getProductQunt()+"\"";
					json += ",\"productSeller\":\""+ prd.getProductSeller()+"\"";
					json += ",\"image\":\""+ prd.getImage()+"\"";
					
					
					json += "}";
					
					
					if(list.size() != cnt++) {
						json +=",";
					}
				}
				
				json += "]";
				
				System.out.println(json);
					response.getWriter().append(json);
				
				
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
