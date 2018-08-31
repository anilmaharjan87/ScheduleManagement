package com.geneticalgorithm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geneticalgorithm.dao.TimeSlotDAO;
import com.geneticalgorithm.domain.TimeSlot;

/**
 * Servlet implementation class TimeSlotServlet
 */
@WebServlet("/TimeSlotServlet")
public class TimeSlotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeSlotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher("/timeslot.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String slot=request.getParameter("timeSlot");
		
		TimeSlot timeslot=new TimeSlot(slot);
		TimeSlotDAO.addTimeSlot(timeslot);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/timeslot.jsp");
		dispatcher.forward(request, response);
		
	}

}
