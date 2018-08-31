package com.geneticalgorithm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geneticalgorithm.dao.ClassDao;
import com.geneticalgorithm.dao.GroupDAO;
import com.geneticalgorithm.dao.TimeSlotDAO;
import com.geneticalgorithm.domain.Group;
import com.geneticalgorithm.domain.TimeClass;
import com.geneticalgorithm.domain.TimeSlot;
import com.timetable.TimetableGA;

/**
 * Servlet implementation class GroupServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] days = { "sunday", "monday", "tuesday", "wednesday", "thursday", "friday" };
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		List<Group> groupList = GroupDAO.getGroup();
		List<TimeSlot> timeSlotsList = TimeSlotDAO.getTimeSlot();

		HashMap<String, List<TimeClass>> timClassHasMap = new LinkedHashMap();
		for (Group group : groupList) {
			List<TimeClass> timeClassList = new ArrayList<>();
			for (TimeSlot timeSlot : timeSlotsList) {
				timeClassList.add(ClassDao.getTimeClass(group.getGroupId(), timeSlot.getTimeSlot()));
			}
			timClassHasMap.put(group.getGroupName(), timeClassList);
		}

		request.setAttribute("TIMECLASSHASHMAP", timClassHasMap);
		request.setAttribute("DAYS", days);
		request.setAttribute("TIMESLOT", timeSlotsList);

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassDao.TruncateTable();

		try {
			// generate routine
			TimetableGA.init();
		} catch (SQLException e) {
			// // TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("login", true);
		doGet(request, response);

	}

}
