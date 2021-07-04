package cognixia.jump.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cognixia.jump.connection.ConnectionManager;
import cognixia.jump.dao.BookDAO;
import cognixia.jump.dao.PatronDao;
import cognixia.jump.model.Book;
import cognixia.jump.model.Patron;


/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PatronDao patronDAO;
	private BookDAO bookDao;
	
	private Patron userLogedin;
    /**
     * Default constructor. 
     */
    public BookServlet() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	patronDAO= new PatronDao();
    	bookDao = new BookDAO();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch (action) {
		case "/login":
			getUserName(request, response);
			break;
			
		case "/create-account-page":
			createAccount(request,response);
			break;
		case "/create-account-db":
			createAccountDB(request,response);
			break;
		case "/logout":
			Logout(request,response);
			break;
		case "/rent":
			rentBook(request,response);
			break;
			
			
			
//			goToProductForm(request, response);
//			break;
//		case "/insert":
//			addProduct(request, response);
//			break;
		default:
			response.sendRedirect("/");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	@Override
	public void destroy() {
		try {
			ConnectionManager.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void rentBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession(false);
		
		String id = "";
		
		if(session != null) {
			Patron user = (Patron) session.getAttribute("patron");
			
			id = user.getId();
		}
		
		
		
		
		String ISBN = request.getParameter("isbn");
		
		boolean rented = bookDao.rentABook(id, ISBN);
		
		if(rented) {
			
			List<Book> getAllBooks = bookDao.getAllBooks();
			
			request.setAttribute("allBooks", getAllBooks);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("main-page.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}
	
	private void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	private void createAccountDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("username");
		String password = request.getParameter("pass");
		
		
		boolean created = patronDAO.createdUserName(firstName, lastName, userName, password);
		
		if(created) {
			
			String error = "Account Sucessfully Created!";
			
			request.setAttribute("LoginError", error);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			String error = "pick a different username. Username existed.";
			request.setAttribute("AccountError", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("create-account.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}
	
	private void createAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("create-account.jsp");
		dispatcher.forward(request, response);
		
	}
	
//
	private void getUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		
		Patron user = patronDAO.getPatronByUserName(username, password);
		
		if(user != null) {
			
			List<Book> getAllBooks = bookDao.getAllBooks();
			
			request.setAttribute("allBooks", getAllBooks);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("patron", user);
			
			session.setMaxInactiveInterval(300);
			
			//Cookie c1 = new Cookie("id", user.getId());
			
			//c1.setMaxAge(30 * 60);
			
			
			//response.addCookie(c1);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("main-page.jsp");
			dispatcher.forward(request, response);
		}else {
			
			String error = "Wrong username or password entered";
			
			request.setAttribute("LoginError", error);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			}
		
		
		
		
		//response.sendRedirect(request.getContextPath());
	}
	
	private void getAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> allbooks = bookDao.getAllBooks();
		
		Cookie [] cookies = request.getCookies();
		
		String id = cookies[0].getValue();
		
		
		request.setAttribute("id", id);
		request.setAttribute("allBooks", allbooks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
	
}
