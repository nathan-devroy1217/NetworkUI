

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private NetworkDAO dao;
	
	private FileLister fileLister;

    public MainServlet() {
    		super();
        dao = new NetworkDAO();
        fileLister = new FileLister();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("listPackets")) {
			List<Packet> packetList = dao.getAllPacketData();
			if (packetList.isEmpty()) {
				System.out.println("List is empty....");
			} else {
				System.out.println(packetList.get(0));
			}
			request.setAttribute("packets", packetList);
			RequestDispatcher view = request.getRequestDispatcher("/Home.jsp");
			view.forward(request, response);
		} else if (action.equalsIgnoreCase("listFiles")) {
			ArrayList<File> fileList = fileLister.getFiles();
			if (fileList.size() == 0) {
				System.out.println("List is empty....");
			} else {
				System.out.println(fileList.size() + " files in " + fileList.get(0).getAbsolutePath());
			}
			request.setAttribute("files", fileList);
			RequestDispatcher view = request.getRequestDispatcher("/reporting.jsp");
			view.forward(request, response);
		} else if(action.equalsIgnoreCase("download")) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String fileName = request.getParameter("name").toString();
			response.setContentType("APPLICATION/OCTET-STREAM");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			FileInputStream fileInputStream = new FileInputStream(fileName); 
			int i;
			while ((i = fileInputStream.read()) != -1) {
				out.write(i);
			}
			fileInputStream.close();
			out.close();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dog Fart");
		String fromDate = request.getParameter("datepicker1").toString();
		String fromTime = request.getParameter("datepicker2").toString();
		String toDate = request.getParameter("timepicker1").toString();
		String toTime = request.getParameter("timepicker2").toString();

		//Need to check formatting and conform to 'YYYY-MM-DD HH:MM:SS'//
		System.out.println(fromDate + " " + fromTime + " " + toDate + " " + toTime);
		//Should call a class that takes the data in, formats, then calls CSV creator class
		//...From there, return CSV file and forward back to reporting.jsp.
		//DONT FORGET TO ROUTE TO 404 PAGE FOR BAD REQUESTS

		//Note: Wickedpicker format ==> 3:28 PM
		//Note: Calendar format ==> MM/DD/YYYY
			
	
		//Last line routes back to reporting.jsp
		RequestDispatcher view = request.getRequestDispatcher("/reporting.jsp");
	}

}
