package in.co.rays.ctl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.dto.ProgressDTO;
import in.co.rays.model.ProgressModel;
@WebServlet("/ProgressCtl")
public class ProgressCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProgressDTO dto = new ProgressDTO();
		ProgressModel model = new ProgressModel();
		
		
		String id = req.getParameter("id");
		if (id != null) {
			dto = model.findByPK(Integer.parseInt(id));
			req.setAttribute("dto", dto);

		}
		RequestDispatcher rd = req.getRequestDispatcher("ProgressView.jsp");
		rd.forward(req, resp);

		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		ProgressDTO dto = new ProgressDTO();
		ProgressModel model = new ProgressModel();
		
		dto.setDeveloperName(req.getParameter("developername"));
		dto.setWork(req.getParameter("work"));
		dto.setReportingDate(new Date());
		dto.setTarget(req.getParameter("target"));
		dto.setLastWeek(req.getParameter("lastweek"));
		dto.setCurrentWeek(req.getParameter("currentweek"));
		String op = req.getParameter("operation");
		if (op.equalsIgnoreCase("update")) {
			dto.setId(Integer.parseInt(id));
			model.update(dto);
			req.setAttribute("msg", "successfully update");
			req.setAttribute("dto", dto);
		 RequestDispatcher rd = 	req.getRequestDispatcher("ProgressView.jsp");
			rd.forward(req, resp);
		}else if (op.equalsIgnoreCase("add")) {
			resp.sendRedirect("ProgressView.jsp");
		}
		else if (op.equalsIgnoreCase("cancel")) {
			resp.sendRedirect("ProgressListCtl");
			
		}else if (op.equalsIgnoreCase("save")) {
			model.add(dto);
			req.setAttribute("msg", "successfully added");
			RequestDispatcher rd = 	req.getRequestDispatcher("ProgressView.jsp");
			rd.forward(req, resp);
		
			
		}
		
		
	
	
	
	}
	

}
