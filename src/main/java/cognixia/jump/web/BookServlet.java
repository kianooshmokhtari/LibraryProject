package cognixia.jump.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			
//		case "/list":
//			listAllProducts(request, response);
//			break;
//		case "/new":
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
	
//
	private void getUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		
		Patron test = patronDAO.getPatronByUserName(username, password);
		
		if(test != null) {
			
			List<Book> getAllBooks = bookDao.getAllBooks();
			
			request.setAttribute("allBooks", getAllBooks);
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
		
		request.setAttribute("allBooks", allbooks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
	
}
