package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Util.ExcelAcces;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowExcel
 */
@WebServlet("/ShowExcel")
public class ShowExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowExcel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = getServletContext().getRequestDispatcher("/jsp/Nombre.jsp");
		
		request.setAttribute("array", ExcelAcces.list());
		request.setAttribute("arraytable", ExcelAcces.getExcelTable());
		request.setAttribute("numHojas", ExcelAcces.getNumHojas());
		request.setAttribute("arrayhojas", ExcelAcces.getHojasName());
		ExcelAcces.read();
		
		view.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
