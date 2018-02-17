package com.sridhana.controller.faculty;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.sridhana.bean.ClassBean;
import com.sridhana.model.Exam_Details;
import com.sridhana.model.Exam_Grades;
import com.sridhana.model.Mcq;
import com.sridhana.model.User;
import com.sridhana.service.faculty.FacultyService;
import com.sridhana.service.faculty.ManageMCQService;


@Controller
public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;

 	@Autowired
	@Qualifier(value = "facultyService")
	public void setFacultyService(FacultyService facultyService) {
		this.facultyService = facultyService;
	}
	
	@Autowired
	private ManageMCQService manageMCQService;

 	@Autowired
	@Qualifier(value = "manageMCQService")
	public void setmanageMCQService(ManageMCQService manageMCQService) {
		this.manageMCQService = manageMCQService;
	}

	@Autowired
	@Qualifier(value = "manageMCQService")
	public void setManageMCQService(ManageMCQService manageMCQService) {
		this.manageMCQService = manageMCQService;
	}

	@RequestMapping(value = "/facultyclasslinks",method=RequestMethod.GET)
	public ModelAndView setClasslinkspage( HttpServletRequest request,  ModelAndView model)
	{
		User user = (User) request.getSession().getAttribute("User");
		System.out.println("User value: " + user);
		System.out.println("Username value: " + user.getUsername());
		List<ClassBean> classbeanlist = facultyService.getClassbyFacultyUsername(user);
			
		model.addObject("ClassBeanlist",classbeanlist);
		model.addObject("user", user );
		model.setViewName("Faculty/ClassLinks");
		return model;

	}		
	
//	@RequestMapping("/QuestionBank")
//	public ModelAndView FillQuestionBank( HttpServletRequest request,ModelAndView model) {
//        return 
//	}
	
	@RequestMapping("/CreateExam")
	public ModelAndView CreateExam( HttpServletRequest request,ModelAndView model) {
       String examid =  request.getParameter("examId");
//    String action = StringUtils.defaultIfBlank(request.getParameter("action"), "");
//    if ("CREATE_FORM".equals(action)) { //Upload Question file
//			}
	   model.setViewName("Faculty/QuestionBank");
     	return model;
	}
	
	//set remove method to delete question on screen
	@RequestMapping("/classidlinks/{classid}")
	public ModelAndView listExam_DetailsbyClassid(@PathVariable("classid") String classid, ModelAndView model) {

		List<Exam_Details> exam_Details_list= facultyService.listExam_DetailsbyClassid(classid);
		model.addObject("exam_Details_list",exam_Details_list);
	//	model.addObject("user", user );
		model.setViewName("Faculty/FacultyExamLinks");
		return model;
	}

	@RequestMapping("/examidlinks/{examid}")
	public List<Exam_Grades> listExam_GradesbyExamid(@PathVariable("examid") String examid, ModelAndView model ) {
		return facultyService.listExam_GradesbyExamid(examid);
	}
	

	public List<Exam_Details> listExam_DetailsbyClassid(String examid) {
		return facultyService.listExam_DetailsbyClassid(examid);		
	}	
	
	

	@RequestMapping(value = "/manageMCQ")
	@ResponseBody
	public void manageMCQ(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = (String) request.getParameter("action");
		response.setContentType("application/json");
		Gson gson = new Gson();
		Mcq mcq;

		if (action.equals("list")) {
			try {
				List<Mcq> mcqlist = manageMCQService.listMcq();
				// Convert Java Object to Json
				JsonElement element = gson.toJsonTree(mcqlist, new TypeToken<List<Mcq>>() {
				}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData = jsonArray.toString();
				// Return Json in the format required by jTable plugin
				listData = "{\"Result\":\"OK\",\"Records\":" + listData + "}";
				response.getWriter().print(listData);

			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getMessage() + "}";
				response.getWriter().print(error);
				ex.printStackTrace();
			}
		} else if (action.equals("create") || action.equals("update")) {
			
			mcq = new Mcq();
			String examid = request.getParameter("examid");
			String question = request.getParameter("question");
			String optiona = request.getParameter("optiona");
			String optionb = request.getParameter("optionb");
			String optionc = request.getParameter("optionc");
			String optiond = request.getParameter("optiond");
			String optione = request.getParameter("optione");
			String optionf = request.getParameter("optiof");
			String answer = request.getParameter("answer");
			int marks_alloted = Integer.parseInt(request.getParameter("marks_alloted"));
           
			mcq.setExamid(examid);			
			mcq.setQuestion(question);
			mcq.setOptiona(optiona);
			mcq.setOptionb(optionb);
			mcq.setOptionc(optionc);
			mcq.setOptiond(optiond);
			mcq.setOptione(optione);
			mcq.setOptionf(optionf);
			mcq.setAnswer(answer);
            mcq.setMarks_alloted(marks_alloted);
			try {
				if (action.equals("create")) {// Create new record
					manageMCQService.addMcq(mcq);
					// Convert Java Object to Json
					String json = gson.toJson(mcq);
					// Return Json in the format required by jTable plugin
					String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
					response.getWriter().print(listData);
				} else if (action.equals("update")) {// Update existing record
					int mcqquestionid = Integer.parseInt(request.getParameter("mcqquestionid"));
					mcq.setMcqquestionid(mcqquestionid);
					manageMCQService.updateMcq(mcq);
					String listData = "{\"Result\":\"OK\"}";
					response.getWriter().print(listData);
				}
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		} else if (action.equals("delete")) {// Delete record
			try {
				mcq = new Mcq();
				
				int mcqquestionid = Integer.parseInt(request.getParameter("mcqquestionid"));
				String examid = request.getParameter("examid");
				String question = request.getParameter("question");
				String optiona = request.getParameter("optiona");
				String optionb = request.getParameter("optionb");
				String optionc = request.getParameter("optionc");
				String optiond = request.getParameter("optiond");
				String optione = request.getParameter("optione");
				String optionf = request.getParameter("optiof");
				String answer = request.getParameter("answer");
				int marks_alloted = Integer.parseInt(request.getParameter("marks_alloted"));

				mcq.setMcqquestionid(mcqquestionid);
				mcq.setExamid(examid);			
				mcq.setQuestion(question);
				mcq.setOptiona(optiona);
				mcq.setOptionb(optionb);
				mcq.setOptionc(optionc);
				mcq.setOptiond(optiond);
				mcq.setOptione(optione);
				mcq.setOptionf(optionf);
				mcq.setAnswer(answer);
	            mcq.setMarks_alloted(marks_alloted);

				manageMCQService.deleteMcq(mcq);
				String listData = "{\"Result\":\"OK\"}";
				response.getWriter().print(listData);
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		}

	}

}
