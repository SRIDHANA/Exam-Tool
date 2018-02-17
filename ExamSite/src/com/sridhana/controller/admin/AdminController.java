package com.sridhana.controller.admin;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.sridhana.bean.ClassBean;
import com.sridhana.model.Clas;
import com.sridhana.model.ClassMap;
//import com.google.gson.reflect.TypeToken;
//import com.sridhana.model.Clas;
import com.sridhana.model.Course;
import com.sridhana.model.User;

import com.google.gson.reflect.TypeToken;
import com.sridhana.service.admin.AssignClassService;
import com.sridhana.service.admin.ManageClassService;
import com.sridhana.service.admin.ManageCourseService;
import com.sridhana.service.admin.ManageFacultyService;
import com.sridhana.service.admin.ManageStudentService;

@Controller
public class AdminController {

	@Autowired
	private ManageStudentService manageStudentService;

	@Autowired
	@Qualifier(value = "manageStudentService")
	public void setManageStudentService(ManageStudentService manageStudentService) {
		this.manageStudentService = manageStudentService;
	}

	@Autowired
	private ManageFacultyService manageFacultyService;

	@Autowired
	@Qualifier(value = "manageFacultyService")
	public void setManageFacultyService(ManageFacultyService manageFacultyService) {
		this.manageFacultyService = manageFacultyService;
	}

	@Autowired
	private ManageCourseService manageCourseService;

	@Autowired
	@Qualifier(value = "manageCourseService")
	public void setManageCourseService(ManageCourseService manageCourseService) {
		this.manageCourseService = manageCourseService;
	}

	@Autowired
	private ManageClassService manageClassService;

	@Autowired
	@Qualifier(value = "manageClassService")
	public void setManageClassService(ManageClassService manageClassService) {
		this.manageClassService = manageClassService;
	}

	@Autowired
	private AssignClassService assignClassService;

	@Autowired
	@Qualifier(value = "assignClassService")
	public void setAssignClassService(AssignClassService assignClassService) {
		this.assignClassService = assignClassService;
	}

	@RequestMapping(value = "/manageCourse")
	@ResponseBody
	public void manageCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = (String) request.getParameter("action");
		response.setContentType("application/json");
		Gson gson = new Gson();
		Course course;

		if (action.equals("list")) {
			try {
				List<Course> courselist = manageCourseService.listCourse();
				// Convert Java Object to Json
				JsonElement element = gson.toJsonTree(courselist, new TypeToken<List<Course>>() {}.getType());
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
			course = new Course();
			if (request.getParameter("courseid") != null) {
				course.setCourseid(request.getParameter("courseid"));
			}
			if (request.getParameter("coursename") != null) {
				String coursename = (String) request.getParameter("coursename");
				course.setCoursename(coursename);
			}

			try {
				if (action.equals("create")) {// Create new record
					manageCourseService.addCourse(course);
					// Convert Java Object to Json
					String json = gson.toJson(course);
					// Return Json in the format required by jTable plugin
					String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
					response.getWriter().print(listData);
				} else if (action.equals("update")) {// Update existing record
					manageCourseService.updateCourse(course);
					String listData = "{\"Result\":\"OK\"}";
					response.getWriter().print(listData);
				}
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		} else if (action.equals("delete")) {// Delete record
			try {
				course = new Course();
				if (request.getParameter("courseid") != null) {
					course.setCourseid(request.getParameter("courseid"));
				}
				if (request.getParameter("coursename") != null) {
					String coursename = (String) request.getParameter("coursename");
					course.setCoursename(coursename);
				}
				manageCourseService.deleteCourse(course);
				String listData = "{\"Result\":\"OK\"}";
				response.getWriter().print(listData);
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		}

	}
	@RequestMapping(value = "/manageFaculty")
	@ResponseBody
	public void manageFaculty(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = (String) request.getParameter("action");
		response.setContentType("application/json");
		Gson gson = new Gson();
		User faculty;

		if (action.equals("list")) {
			try {
				List<User> facultylist = manageFacultyService.listFaculty();
				// Convert Java Object to Json
				JsonElement element = gson.toJsonTree(facultylist, new TypeToken<List<User>>() {}.getType());
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
			faculty = new User();
			
			faculty.setUsername(request.getParameter("username"));
			faculty.setPassword(request.getParameter("password"));
			faculty.setEmail(request.getParameter("email"));
			faculty.setFirstname(request.getParameter("firstname"));
			faculty.setLastname(request.getParameter("lastname"));
			
			try {
				if (action.equals("create")) {// Create new record
					manageFacultyService.addFaculty(faculty);
					// Convert Java Object to Json
					String json = gson.toJson(faculty);
					// Return Json in the format required by jTable plugin
					String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
					response.getWriter().print(listData);
				} else if (action.equals("update")) {// Update existing record
					manageFacultyService.updateFaculty(faculty);
					String listData = "{\"Result\":\"OK\"}";
					response.getWriter().print(listData);
				}
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		} 
		else if (action.equals("delete")) {// Delete record
			try {
				faculty = new User();
				faculty.setUsername(request.getParameter("username"));
				faculty.setPassword(request.getParameter("password"));
				faculty.setEmail(request.getParameter("email"));
				faculty.setFirstname(request.getParameter("firstname"));
				faculty.setLastname(request.getParameter("lastname"));
				manageFacultyService.deleteFaculty(faculty);
				String listData = "{\"Result\":\"OK\"}";
				response.getWriter().print(listData);
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		}

	}

	@RequestMapping(value = "/manageStudent")
	@ResponseBody
	public void manageStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = (String) request.getParameter("action");
		response.setContentType("application/json");
		Gson gson = new Gson();
		List<User> studentlist = manageStudentService.listStudent();
		User student;

		if (action.equals("list")) {
			try {
				// Convert Java Object to Json
				JsonElement element = gson.toJsonTree(studentlist, new TypeToken<List<User>>() {}.getType());
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
			student = new User();
			
			student.setUsername(request.getParameter("username"));
			student.setPassword(request.getParameter("password"));
			student.setEmail(request.getParameter("email"));
			student.setFirstname(request.getParameter("firstname"));
			student.setLastname(request.getParameter("lastname"));
			
			try {
				if (action.equals("create")) {// Create new record
					manageStudentService.addStudent(student);
					// Convert Java Object to Json
					String json = gson.toJson(student);
					// Return Json in the format required by jTable plugin
					String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
					response.getWriter().print(listData);
				} else if (action.equals("update")) {// Update existing record
					manageStudentService.updateStudent(student);
					String listData = "{\"Result\":\"OK\"}";
					response.getWriter().print(listData);
				}
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		} 
		else if (action.equals("delete")) {// Delete record
			try {
				student = new User();
				student.setUsername(request.getParameter("username"));
				student.setPassword(request.getParameter("password"));
				student.setEmail(request.getParameter("email"));
				student.setFirstname(request.getParameter("firstname"));
				student.setLastname(request.getParameter("lastname"));
				manageStudentService.deleteStudent(student);
				String listData = "{\"Result\":\"OK\"}";
				response.getWriter().print(listData);
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		}

	}

	@RequestMapping(value = "/manageClass")
	@ResponseBody
	public void manageClassBeans(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = (String) request.getParameter("action");
		response.setContentType("application/json");
		Gson gson = new Gson();


		ClassBean classBean;
           
		if (action.equals("list")) {
			try {
				// Convert Java Object to Json
				List<ClassBean> classBeanlist = manageClassService.listClass();
				JsonElement element = gson.toJsonTree(classBeanlist, new TypeToken<List<ClassBean>>() {}.getType());
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
			classBean = new ClassBean();
			String classBeansid = request.getParameter("classBeansid");
			String courseid = request.getParameter("courseid");
			String facultyusername = request.getParameter("facultyusername");

			if (classBeansid != null) {
				classBean.setClassid(request.getParameter("classBeansid"));
			}
			if (courseid != null) {
				classBean.setCourseid(courseid);
			}
			if (facultyusername != null) {
				classBean.setFacultyusername(facultyusername);
			}

			try {
				if (action.equals("create")) {// Create new record
					manageClassService.addClass(classBean);
					// Convert Java Object to Json
					String json = gson.toJson(classBean);
					// Return Json in the format required by jTable plugin
					String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
					response.getWriter().print(listData);
				} else if (action.equals("update")) {// Update existing record
					manageClassService.updateClass(classBean);
					String listData = "{\"Result\":\"OK\"}";
					response.getWriter().print(listData);
				}
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		} else if (action.equals("delete")) {// Delete record
			try {
				classBean = new ClassBean();
				String classBeansid = request.getParameter("classBeansid");
				String courseid = request.getParameter("courseid");
				String facultyusername = request.getParameter("facultyusername");

				if (classBeansid != null) {
					classBean.setClassid(request.getParameter("classBeansid"));
				}
				if (courseid != null) {
					classBean.setCourseid(courseid);
				}
				if (facultyusername != null) {
					classBean.setFacultyusername(facultyusername);
				}
				
				manageClassService.deleteClass(classBean);

				String listData = "{\"Result\":\"OK\"}";
				response.getWriter().print(listData);
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		}else if (action.equals("getfacultyoptions")) {
			List<String> listdata = manageClassService.listallFacultyUsernames();
			
			// Convert Java Object to Json
			JsonElement element = gson.toJsonTree(listdata, new TypeToken<List<String>>() {}.getType());
			JsonArray jsonArray = element.getAsJsonArray();
			String listData = jsonArray.toString();
			// Return Json in the format required by jTable plugin
			listData = "{\"Result\":\"OK\",\"Options\":" + listData + "}";
			response.getWriter().print(listData);		
		     
		}
		else if (action.equals("getcourseoptions")) {
			List<String> listdata = manageClassService.listAllCourseIds();
			
			// Convert Java Object to Json
			JsonElement element = gson.toJsonTree(listdata, new TypeToken<List<String>>() {}.getType());
			JsonArray jsonArray = element.getAsJsonArray();
			String listData = jsonArray.toString();
			// Return Json in the format required by jTable plugin
			listData = "{\"Result\":\"OK\",\"Options\":" + listData + "}";
			response.getWriter().print(listData);		
		     
		}
	}


	@RequestMapping(value = "/manageStudentAssignments")
	@ResponseBody
	public void manageStudentAssignments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = (String) request.getParameter("action");
		response.setContentType("application/json");
		Gson gson = new Gson();
		ClassMap classMap;
           
		if (action.equals("list")) {
			try {
				List<ClassMap> classMaplist = assignClassService.listClassMap();
				// Convert Java Object to Json
				JsonElement element = gson.toJsonTree(classMaplist, new TypeToken<List<ClassMap>>() {}.getType());
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
			classMap = new ClassMap();
			String classid = request.getParameter("classid");
			String username = request.getParameter("username");

			if (classid != null) {
				classMap.setClassid(request.getParameter("classid"));
			}
			if (username != null) {
				classMap.setUsername(username);
			}
			try {
				if (action.equals("create")) {// Create new record
					assignClassService.addClassMap(classMap);
					// Convert Java Object to Json
					String json = gson.toJson(classMap);
					// Return Json in the format required by jTable plugin
					String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
					response.getWriter().print(listData);
				} else if (action.equals("update")) {// Update existing record
					assignClassService.updateClassMap(classMap);
					String listData = "{\"Result\":\"OK\"}";
					response.getWriter().print(listData);
				}
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		} else if (action.equals("delete")) {// Delete record
			try {
				classMap = new ClassMap();
				String classid = request.getParameter("classid");
				String username = request.getParameter("username");

				if (classid != null) {
					classMap.setClassid(request.getParameter("classid"));
				}
				if (username != null) {
					classMap.setUsername(username);
				}
				assignClassService.deleteClassMap(classMap);

				String listData = "{\"Result\":\"OK\"}";
				response.getWriter().print(listData);
			} catch (Exception ex) {
				String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
				response.getWriter().print(error);
			}
		}
	}
}
