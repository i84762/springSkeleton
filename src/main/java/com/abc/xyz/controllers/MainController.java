package com.abc.xyz.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.abc.xyz.config.Resource;
import com.abc.xyz.dto.BotView;
import com.abc.xyz.service.BotService;
import com.abc.xyz.service.PlatformService;

/**
 * @author amrit
 *
 */
@Controller
public class MainController
{
	@Autowired
	private BotService botService;
	
	@Autowired
	private Resource resource;
	
	@Autowired
	private PlatformService platformService;
	

	@RequestMapping(value = "*")
    public ModelAndView handleResourceNotFoundException()
	{
		ModelAndView view = new ModelAndView("failPage");
		view.addObject("title", "Oops!");
		view.addObject("msg", resource.get("A0027"));	
        return view;
    }
	
	@RequestMapping(value = { "/compare"}, method = RequestMethod.GET)
	public ModelAndView register(ModelAndView model)
	{
		model.addObject("botList", botService.getAllViews());
		model.addObject("bot", new BotView());
		model.setViewName("compare");
		return model;
	}
	
	
	@RequestMapping(value = { "/category/{id}"}, method = RequestMethod.GET)
	public ModelAndView category(@PathVariable(value = "id") String param, ModelAndView model)
	{
		String []p = param.split("-");
		Long id = new Long(p[0]);
		/*List<BotView> list = botService.getBots(1, new Long[]{id}, null);
	
		model.addObject("botList", getJSON(list));*/
		
		model.addObject("platID", "null");
		model.addObject("catID", id);
//		model.addObject("totalPages", botService.getBotPagesCount(null, null));
		model.setViewName("category");
		return model;
	}
	
	@RequestMapping(value = { "/platform/{id}"}, method = RequestMethod.GET)
	public ModelAndView platform(@PathVariable(value = "id") String param, ModelAndView model)
	{
		String []p = param.split("-");
		Long id = new Long(p[0]);
//		List<BotView> list = botService.getBots(1, null, new Long[]{id});
//		
//		model.addObject("botList", getJSON(list));
		
		model.addObject("platID", id);
		model.addObject("catID", "null");
//		model.addObject("totalPages", botService.getBotPagesCount(null, null));
		model.setViewName("category");
		return model;
	}
	
	@RequestMapping(value = { "/description/{id}"}, method = RequestMethod.GET)
	public ModelAndView description(@PathVariable(value = "id") String param, ModelAndView model)
	{		
		String []p = param.split("-");
		Long id = new Long(p[0]);
		model.addObject("id", id);
		model.setViewName("description");
		return model;
	}
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView defaultPage(
			@RequestParam(value="catID", required=false) Long catID,
			@RequestParam(value="platID", required=false) Long platID
			)
	{
//		System.out.println("\n\n\n\ndefaultPage\n\n\n\n");
		ModelAndView model = new ModelAndView();
		model.addObject("catID", catID);
		model.addObject("platID", platID);
		model.setViewName("home");
		return model;
	}	
	
	
	@RequestMapping(value = { "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPagep()
	{
//		System.out.println("\n\n\n\ndefaultPage\n\n\n\n");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "ValueFirst BotU");
		model.addObject("message", "Hi, Welcome to ValueFirst Bots Directory.");
		model.setViewName("hello");
		return model;
	}	
	

	@RequestMapping(value = { "/showBot"}, method = RequestMethod.GET)
    public ModelAndView showbot(@RequestParam(value="id", required=false) long id)
    {
        System.out.println("\n\n\n\nshowbot  " + id + "\n\n\n\n");
        ModelAndView model = new ModelAndView();
        model.setViewName("showbot");
        model.addObject("botInfo", botService.findByID(id));
        return model;
    }   
	
	@RequestMapping(value = { "/submit" }, 	method = RequestMethod.GET)
	public ModelAndView submit(ModelAndView model)
	{
		BotView botView = new BotView();
		botView.setCategoryViews(new ArrayList());
		botView.setPlatformViews(new ArrayList());		
		botView.setPlatformsNames(new ArrayList());		
		model.addObject("bot", botView);		
		model.addObject("platformsViewsList", platformService.getAllViews());		
		model.setViewName("submit");
		return model;
	}	
	
	
	@RequestMapping(value = { "/topOfTheLot" }, 	method = RequestMethod.GET)
	public ModelAndView topOfTheLot(ModelAndView model)
	{	
		model.addObject("bots", getJSON(botService.getTopOfTheLotBots(12, null, null)));		
		model.setViewName("topOfTheLot");
		return model;
	}	
	
	
	@RequestMapping(value = { "/freshArrivals" }, 	method = RequestMethod.GET)
	public ModelAndView freshArrivals(ModelAndView model)
	{	
		model.addObject("bots", getJSON(botService.getFreshArrivedBots(12, null, null)));		
		model.setViewName("freshArrivals");
		return model;
	}	
	
	
	@RequestMapping(value = { "/noteworthy" }, 	method = RequestMethod.GET)
	public ModelAndView noteworthy(ModelAndView model)
	{	
		model.addObject("bots", getJSON(botService.getNoteWorthyBots(12, null, null)));		
		model.setViewName("noteworthy");
		return model;
	}	
	
	@RequestMapping(value = { "/shoutouts" }, 	method = RequestMethod.GET)
	public ModelAndView shoutouts(ModelAndView model)
	{	
		model.addObject("bots", getJSON(botService.getNoteWorthyBots(12, null, null)));		
		model.setViewName("shoutouts");
		return model;
	}	
	

	@ExceptionHandler(Exception.class)
	public ModelAndView error(Exception ex)
	{
		System.out.println("\n\n\n\nerror\n\n\n\n");
		ex.printStackTrace();
		ModelAndView model = new ModelAndView("error");
		model.addObject("errCode", ex.getMessage());
//		model.addObject("errMsg", ex.getErrMsg());
		return model;
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied()
	{
		ModelAndView model = new ModelAndView();
		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken)) 
		{
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("403");
		return model;
	}
	
	private String getJSON(List list)
	{
	    final ObjectMapper mapper = new ObjectMapper();

	    String str="";
		    try 
		    {
		    	 str = mapper.writeValueAsString(list);
			} 
		    catch (Exception e) 
		    {
				e.printStackTrace();
			}
	    return str;
	}
}