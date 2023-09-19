package com.springmvc.hotelReservation3;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.hotelReservation3.dto.MemberDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "top";
//	}
	
	@GetMapping("/about")
	public String requestAboutPage() {
		
		return"about";
	}
	
	@GetMapping("/royalsweet")
	public String requestRoyalsweetPage() {
		
		return"royalsweet";
	}
	
	@GetMapping("/deluxe")
	public String requestDeluxePage() {
		
		return"deluxe";
	}
	
	@GetMapping("/standard")
	public String requestStandardPage() {
		
		return"standard";
	}
	
	@GetMapping("/index")
	public String requestIndexPage() {

		return"index";
	}

	@GetMapping("/admin/adminPage")
	public String requestAdminPage(HttpServletRequest request, Model model) {

		// 현재 로그인된 세션 정보
		MemberDTO memberdto = (MemberDTO) request.getSession().getAttribute("LoginDTO");

		if (memberdto != null && memberdto.getM_id().equals("admin")) {

			return "admin/adminPage";
		} else {
			String alertScript = "alert('관리자만 접근 할 수 있습니다.');";
			model.addAttribute("alertScript", alertScript);
			return "redirect:/index";
		}
	}
}
