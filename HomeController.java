package com.jt.Controller;


import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jt.Entity.Admin;
import com.jt.Entity.StudentInfo;
import com.jt.Repository.stdRepository;


@Controller

public class HomeController {

	@Autowired
	stdRepository stdRepo;
	
	@Autowired
	private JavaMailSender sender;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("/adminLogin")
	public String admin() {
		return "adminLogin";
	}
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String submit(Model m,@ModelAttribute("a")Admin a) {
		if(a!=null && a.getName() !=null & a.getPassword() !=null) {
			if(a.getName().equals("subhashree") && a.getPassword().equals("123")) {
				m.addAttribute("msg",a.getName());
				return "dashboard";
			}else {
				m.addAttribute("error","Invalid Details");
				return "adminLogin";
			}
			}else {
				m.addAttribute("error","Please Enter Details");
			return "adminLogin";
			}
	}
	
	
	@RequestMapping("/dashboard")
	public String template() {
		return "dashboard";
	}
	 
	@RequestMapping("/enquiryForm")
	public String enquiry() {
		return "enquiryForm";
	}
	
	@RequestMapping(value="/enroll",method=RequestMethod.POST) 
	public String  enquiry(@RequestParam("email") String mail,StudentInfo stud, Model m)throws MessagingException { 
		m.addAttribute("hii");
	    System.out.println("Data:"+stud.getStdName()+"\t"+stud.getStdProfession()+"\t"+stud.getfName()+"\t"+stud.getfProfession()+"\t"+stud.getPhoneNo()+"\t"+
		stud.getAlternativeNo()+"\t"+stud.getEmail()+"\t"+stud.getCollege()+"\t"+stud.getCourse()+"\t"+stud.getBranch()+"\t"+stud.getDate());
	    stdRepo.save(stud);
	    
	    boolean isEmail=stdRepo.existsByEmail(mail);
		if (isEmail != true)
		{
			m.addAttribute("msg"," Please Enter Valid Email !!");
			System.err.println("Invalid");
			return"enquiryForm";
			
	    }else
			m.addAttribute("msg","valid mailid");
			System.err.println("valid");
			 MimeMessage message = sender.createMimeMessage();
		        MimeMessageHelper helper= new MimeMessageHelper(message);
		      	  try {
		       		  helper.setTo(mail); 
		       		  helper.setText("<html>\r\n" + 
		       		  		"<head>\r\n" + 
		       		  		"<title></title>\r\n" + 
		       		  		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
		       		  		"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
		       		  		"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n" + 
		       		  		"<style type=\"text/css\">\r\n" + 
		       		  		"    @media screen {\r\n" + 
		       		  		"		@font-face {\r\n" + 
		       		  		"		  font-family: 'Lato';\r\n" + 
		       		  		"		  font-style: normal;\r\n" + 
		       		  		"		  font-weight: 400;\r\n" + 
		       		  		"		  src: url(jt.jpg);\r\n" + 
		       		  		"		}\r\n" + 
		       		  		"		\r\n" + 
		       		  		"		@font-face {\r\n" + 
		       		  		"		  font-family: 'Lato';\r\n" + 
		       		  		"		  font-style: normal;\r\n" + 
		       		  		"		  font-weight: 700;\r\n" + 
		       		  		"		  src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v11/qdgUG4U09HnJwhYI-uK18wLUuEpTyoUstqEm5AMlJo4.woff) format('woff');\r\n" + 
		       		  		"		}\r\n" + 
		       		  		"		\r\n" + 
		       		  		"		@font-face {\r\n" + 
		       		  		"		  font-family: 'Lato';\r\n" + 
		       		  		"		  font-style: italic;\r\n" + 
		       		  		"		  font-weight: 400;\r\n" + 
		       		  		"		  src: local('Lato Italic'), local('Lato-Italic'), url(https://fonts.gstatic.com/s/lato/v11/RYyZNoeFgb0l7W3Vu1aSWOvvDin1pK8aKteLpeZ5c0A.woff) format('woff');\r\n" + 
		       		  		"		}\r\n" + 
		       		  		"		\r\n" + 
		       		  		"		@font-face {\r\n" + 
		       		  		"		  font-family: 'Lato';\r\n" + 
		       		  		"		  font-style: italic;\r\n" + 
		       		  		"		  font-weight: 700;\r\n" + 
		       		  		"		  src: local('Lato Bold Italic'), local('Lato-BoldItalic'), url(https://fonts.gstatic.com/s/lato/v11/HkF_qI1x_noxlxhrhMQYELO3LdcAZYWl9Si6vvxL-qU.woff) format('woff');\r\n" + 
		       		  		"		}\r\n" + 
		       		  		"    }\r\n" + 
		       		  		"    \r\n" + 
		       		  		"    /* CLIENT-SPECIFIC STYLES */\r\n" + 
		       		  		"    body, table, td, a { -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; }\r\n" + 
		       		  		"    table, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; }\r\n" + 
		       		  		"    img { -ms-interpolation-mode: bicubic; }\r\n" + 
		       		  		"\r\n" + 
		       		  		"    /* RESET STYLES */\r\n" + 
		       		  		"    img { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; }\r\n" + 
		       		  		"    table { border-collapse: collapse !important; }\r\n" + 
		       		  		"    body { height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important; }\r\n" + 
		       		  		"\r\n" + 
		       		  		"    /* iOS BLUE LINKS */\r\n" + 
		       		  		"    a[x-apple-data-detectors] {\r\n" + 
		       		  		"        color: inherit !important;\r\n" + 
		       		  		"        text-decoration: none !important;\r\n" + 
		       		  		"        font-size: inherit !important;\r\n" + 
		       		  		"        font-family: inherit !important;\r\n" + 
		       		  		"        font-weight: inherit !important;\r\n" + 
		       		  		"        line-height: inherit !important;\r\n" + 
		       		  		"    }\r\n" + 
		       		  		"\r\n" + 
		       		  		"    /* ANDROID CENTER FIX */\r\n" + 
		       		  		"    div[style*=\"margin: 16px 0;\"] { margin: 0 !important; }\r\n" + 
		       		  		"</style>\r\n" + 
		       		  		"</head>\r\n" + 
		       		  		"<body style=\"background-color: #f4f4f4; margin: 0 !important; padding: 0 !important;\">\r\n" + 
		       		  		"\r\n" + 
		       		  		"<!-- HIDDEN PREHEADER TEXT -->\r\n" + 
		       		  		"<div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\r\n" + 
		       		  		"</div>\r\n" + 
		       		  		"\r\n" + 
		       		  		"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
		       		  		"    <!-- LOGO -->\r\n" + 
		       		  		"    <tr>\r\n" + 
		       		  		"        <td bgcolor=\"#7c72dc\" align=\"center\">\r\n" + 
		       		  		"            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"480\" >\r\n" + 
		       		  		"                <tr>\r\n" + 
		       		  		"                    <td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\">\r\n" + 
		       		  		"                        <a href=\"#\" target=\"_blank\">\r\n" + 
		       		  		"                            <img alt=\"Logo\" src=\"images\newdownload.jpgnewdownload.jpg\" width=\"100\" height=\"100\" style=\"display: block;  font-family: 'Lato', Helvetica, Arial, sans-serif; color: #ffffff; font-size: 18px;\" border=\"0\">\r\n" + 
		       		  		"                        </a>\r\n" + 
		       		  		"                    </td>\r\n" + 
		       		  		"                </tr>\r\n" + 
		       		  		"            </table>\r\n" + 
		       		  		"        </td>\r\n" + 
		       		  		"    </tr>\r\n" + 
		       		  		"    <!-- HERO -->\r\n" + 
		       		  		"    <tr>\r\n" + 
		       		  		"        <td bgcolor=\"#7c72dc\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\r\n" + 
		       		  		"            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"480\" >\r\n" + 
		       		  		"                <tr>\r\n" + 
		       		  		"                    <td bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" style=\"padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;\">\r\n" + 
		       		  		"                      <h1 style=\"font-size: 32px; font-weight: 400; margin: 0;\">Java Technocrat</h1>\r\n" + 
		       		  		"                    </td>\r\n" + 
		       		  		"                </tr>\r\n" + 
		       		  		"            </table>\r\n" + 
		       		  		"        </td>\r\n" + 
		       		  		"    </tr>\r\n" + 
		       		  		"    <!-- COPY BLOCK -->\r\n" + 
		       		  		"    <tr>\r\n" + 
		       		  		"        <td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\r\n" + 
		       		  		"            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"480\" >\r\n" + 
		       		  		"              <!-- COPY -->\r\n" + 
		       		  		"              <tr>\r\n" + 
		       		  		"                <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\r\n" + 
		       		  		"                  <p style=\"margin: 0; color:black;\">Dear Student,<p>\r\n" + 
		       		  		"                  <p style=\"margin: 0 ;color:maroon;font-family:verdana;font-size:60%;\">Thank you for your interest in Java Technocrat.</p>\r\n" + 
		       		  		"                  <p style=\"margin: 0 ;color:gray;font-family:verdana;font-size:60%;\">\r\n" + 
		       		  		"       We are an ace software testing/development training organization that imparts technical education specific to the IT industry. \r\n" + 
		       		  		"       Our faculty are the best the industry who have spent over a decade in their area of specialization.<br>\r\n" + 
		       		  		"\r\n" + 
		       		  		"       Our counsellors will contact you soon on your registered mobile number.</p>\r\n" + 
		       		  		"      <p style=\"margin: 0 ;color:black;font-family:verdana;font-size:65%;\">For more details,</p> \r\n" + 
		       		  		"      <p style=\"margin: 0 ;color:black;font-family:verdana;font-size:60%;\">please visit www.jt.com\r\n" + 
		       		  		"      </p>\r\n" + 
		       		  		"      <p style=\"margin: 0 ;color:black;font-family:verdana;font-size:65%;\">\r\n" + 
		       		  		"      <p style=\"margin: 0 ;color:black;font-family:verdana;font-size:65%;\">Best Regards,</p>\r\n" + 
		       		  		"      <p style=\"margin: 0 ;color:black;font-family:verdana;font-size:60%;\">Java Technocrat Team</p>\r\n" + 
		       		  		"      </p>\r\n" + 
		       		  		"                </td>\r\n" + 
		       		  		"              </tr>\r\n" + 
		       		  		"              <!-- BULLETPROOF BUTTON -->\r\n" + 
		       		  		"              <tr>\r\n" + 
		       		  		"                <td bgcolor=\"#ffffff\" align=\"left\">\r\n" + 
		       		  		"                  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
		       		  		"                    <tr>\r\n" + 
		       		  		"                      <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 20px 30px 60px 30px;\">\r\n" + 
		       		  		"                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
		       		  		"                          <tr>\r\n" + 
		       		  		"                              <td align=\"center\" style=\"border-radius: 3px;\" bgcolor=\"#7c72dc\"><a href=\"http://localhost:1207/registration\" target=\"_blank\" style=\"font-size: 20px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; color: #ffffff; text-decoration: none; padding: 15px 25px; border-radius: 2px; border: 1px solid #7c72dc; display: inline-block;\">Register Here</a></td>\r\n" + 
		       		  		"                          </tr>\r\n" + 
		       		  		"                        </table>\r\n" + 
		       		  		"                      </td>\r\n" + 
		       		  		"                    </tr>\r\n" + 
		       		  		"                  </table>\r\n" + 
		       		  		"                </td>\r\n" + 
		       		  		"              </tr>\r\n" + 
		       		  		"            </table>\r\n" + 
		       		  		"        </td>\r\n" + 
		       		  		"    </tr>\r\n" + 
		       		  		"    \r\n" + 
		       		  		"\r\n" + 
		       		  		"    <tr>\r\n" + 
		       		  		"        <td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 30px 10px 0px 10px;\">\r\n" + 
		       		  		"            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"480\" >\r\n" + 
		       		  		"                <!-- HEADLINE -->\r\n" + 
		       		  		"                <tr>\r\n" + 
		       		  		"                  <td bgcolor=\"#C6C2ED\" align=\"center\" style=\"padding: 30px 30px 30px 30px; border-radius: 4px 4px 4px 4px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\" >\r\n" + 
		       		  		"                    <h2 style=\"font-size: 20px; font-weight: 400; color: #111111; margin: 0;\">Need more help?</h2>\r\n" + 
		       		  		"                    <p style=\"margin: 0;\"><a href=\"contact\" target=\"_blank\" style=\"color: #7c72dc;\">We&rsquo;re here, ready to talk</a></p>\r\n" + 
		       		  		"                  </td>\r\n" + 
		       		  		"                </tr>\r\n" + 
		       		  		"            </table>\r\n" + 
		       		  		"        </td>\r\n" + 
		       		  		"    </tr>\r\n" + 
		       		  		"   \r\n" + 
		       		  		"    </table>\r\n" + 
		       		  		"\r\n" + 
		       		  		"</body>\r\n" + 
		       		  		"</html>",true);
			       		
		     helper.setSubject("spring boot demo");			
		      }catch (Exception e) {
			e.printStackTrace();
		}
		
       sender.send(message);
	   
	 return"success"; 
	}
	
	@RequestMapping(value ="/registration")
	public String registration() {
		
		return "registration";
	}
	@RequestMapping(value = "/dashboard_Enquiry", method = RequestMethod.GET)
	public String showall(Model model) 
	{
	List <StudentInfo> list = stdRepo.findAll();
	model.addAttribute("All", list);

		return "dashboard_Enquiry";
	}


	
	
}
