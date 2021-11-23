

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		String adminStatus = getServletContext().getInitParameter("admin");
		
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		
		
		
		PrintWriter out = response.getWriter();
		out.write("admin absent");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String param = URLDecoder.decode(request.getParameter("text1"),"utf8");
		int result = 0;
		try {
			int n = Integer.parseInt(param);
			for(int i = 1;i<=n;i++) {
				result +=i;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println(result);
	}

}
