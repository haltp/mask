package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.member.dao.AdminDao;
import co.mask.member.vo.MemberVo;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;


@WebServlet("/AdminUserGetTest")
public class AdminUserGetTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminUserGetTest() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		
		
		
		AdminDao dao = new AdminDao();
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		list = dao.selectUserList();
		
		request.setAttribute("list", list);
		System.out.println(list);
				
				String json = "[";
				int cnt =1;
				for(MemberVo prd : list) {
					json += "{";
					
					json += "\"memberId\":\""+ prd.getMemberId()+"\"";
					json += ",\"memberName\":\""+ prd.getMemberName()+"\"";
					json += ",\"memberPhone\":\""+ prd.getMemberPhone()+"\"";
					json += ",\"memberAddress\":\""+ prd.getMemberAddress()+"\"";
					json += ",\"memberEmail\":\""+ prd.getMemberEmail()+"\"";
					json += ",\"memberAuth\":\""+ prd.getMemberAuth()+"\"";

					
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
