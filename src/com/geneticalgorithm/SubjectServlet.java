package com.geneticalgorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geneticalgorithm.dao.GroupDAO;
import com.geneticalgorithm.dao.ProfessorDAO;
import com.geneticalgorithm.dao.SubjectDAO;
import com.geneticalgorithm.domain.Professor;
import com.geneticalgorithm.domain.Subject;
import com.geneticalgorithm.domain.Group;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubjectServlet() {
		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		List<Professor> professors = ProfessorDAO.getProfessor();
		request.setAttribute("PROFESSOR_LIST", professors);

		List<Group> groups = GroupDAO.getGroup();
		request.setAttribute("GROUP_LIST", groups);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subject.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * get profesor ids
		 */
		String[] professorIds = request.getParameterValues("professor");
		List<Professor> professorList = new ArrayList<>();
		for (String professorId : professorIds) {
			Professor professor = new Professor();
			professor.setId(Integer.parseInt(professorId));
			professorList.add(professor);
		}

		/**
		 * 
		 * get subect name and codes	
		 */
		String subjectName = request.getParameter("subjectName");
		String subjectCode = request.getParameter("subjectCode");

		int groupId = Integer.parseInt(request.getParameter("group"));
		Group group = new Group();
		group.setGroupId(groupId);

		Subject subject = new Subject();
		subject.setSubjectName(subjectName);
		subject.setSubjectCode(subjectCode);
		subject.setGroup(group);
		subject.setProfessor(professorList);

		SubjectDAO.addSubject(subject);
		doGet(request,response);

	}

}
