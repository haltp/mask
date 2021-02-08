package co.mask.board.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBConnection {

	/*
	 * 커넥션 풀로부터 커넥션 객체를 가져와 리턴.
	 * @return Connection
	 * @throws SQLException
	 * @throws NamingException
	 *@throws ClassNotFoundException
	*/
	public static Connection getConnection() throws SQLException, NamingException, 
	ClassNotFoundException{
		Context initCtx = new InitialContext();
		 
		//initCtx의 lookup 메서드 이용 "java:comp/env" 객체 찾아 evnCtx에 입력
		Context envCtx = (Context) initCtx.lookup("java:com/env");
		
		//envCtx의 lookup 메서드 이용 "jdbc/orcl" 객체 찾아 ds에 입력
		DataSource ds = (DataSource) envCtx.lookup("jdbc/orcl");
		
		//getConnection 메서드 이용 커넥션 풀로부터 커넥션객체를 얻어 conn변수저장
		Connection conn = ds.getConnection();
		
		
		return conn;
		
	}
	
	
	
	
	
}
