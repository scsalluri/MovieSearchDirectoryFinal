package com.moviesearch.controller;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.moviesearch.model.Movies;
import com.moviesearch.model.Person;
import com.moviesearch.model.User;
import com.moviesearch.model.UserPersonalization;
import com.moviesearch.model.UserRating;
import com.moviesearch.model.AllMovieDetailsPojo;
import com.moviesearch.model.Award;
import com.moviesearch.model.Category;
import com.moviesearch.model.Company;
import com.moviesearch.model.Display;
import com.moviesearch.model.Genre;
import com.moviesearch.model.Language;
import com.moviesearch.model.MovieAward;
import com.moviesearch.model.MovieCategoryPerson;
import com.moviesearch.model.MovieCompany;
import com.moviesearch.model.MovieGenre;
import com.moviesearch.model.MovieLanguage;
import com.moviesearch.service.AwardService;
import com.moviesearch.service.CategoryService;
import com.moviesearch.service.CompanyService;
import com.moviesearch.service.GenreService;
import com.moviesearch.service.LanguageService;
import com.moviesearch.service.MovieAwardService;
import com.moviesearch.service.MovieCategoryPersonService;
import com.moviesearch.service.MovieCompanyService;
import com.moviesearch.service.MovieGenreService;
import com.moviesearch.service.MovieLanguageService;
import com.moviesearch.service.MovieService;
import com.moviesearch.service.PersonService;
import com.moviesearch.service.UserPersonalizationService;
import com.moviesearch.service.UserRatingService;
import com.moviesearch.service.UserService;

@SuppressWarnings("deprecation")
@Controller
@MultipartConfig
public class maincontroller {

	@Value("${upoadDir}")
	private String uploadFolder;




	@Autowired
	public maincontroller() {

	}
	@Autowired
	private UserService userService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private LanguageService languageService;
	@Autowired
	private AwardService awardService;
	@Autowired
	private GenreService genreService;

	@Autowired
	private CompanyService companyService;
	@Autowired
	private MovieCompanyService moviecompanyService;
	@Autowired
	private MovieAwardService movieAwardService;

	@Autowired
	private MovieLanguageService movieLanguageService;
	@Autowired
	private MovieGenreService movieGenreService;
	@Autowired
	private UserRatingService userRatingService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PersonService personService;
	@Autowired
	private MovieCategoryPersonService movieCategoryPersonService;
	@Autowired
	private UserPersonalizationService userPersonalizationService;


	@Autowired
	private User user;


	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/imagedata";

	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		session= new HttpSession() {

			@Override
			public void setMaxInactiveInterval(int interval) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setAttribute(String name, Object value) {
				// TODO Auto-generated method stub

			}

			@Override
			public void removeValue(String name) {
				// TODO Auto-generated method stub

			}

			@Override
			public void removeAttribute(String name) {
				// TODO Auto-generated method stub

			}

			@Override
			public void putValue(String name, Object value) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean isNew() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void invalidate() {
				// TODO Auto-generated method stub

			}

			@Override
			public String[] getValueNames() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object getValue(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public HttpSessionContext getSessionContext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ServletContext getServletContext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getMaxInactiveInterval() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public long getLastAccessedTime() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getCreationTime() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Enumeration<String> getAttributeNames() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object getAttribute(String name) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		session.setAttribute("loggedout", "loggedout");
		return "logout";
	}



/*
	@RequestMapping(value = "/login")
	public String loginPage() {
		return "loginPage";
	}*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handleGet(HttpServletResponse response) {
	  return "testReact";
	}
	
	
	@RequestMapping(value = "/reports")
	public String reportsForm(HttpSession session) {
		if(session.getAttribute("username")==null)
		{

			return "logout";
		}
		return "report";
	}
	@RequestMapping(value = "/registeredUser")
	public ModelAndView registerUser(HttpSession session) {
		if(session.getAttribute("loggedout").toString().equals("Home"))
		{
			return  new ModelAndView("logout");
		}
		ModelAndView modelAndView=new ModelAndView("registeredUser");

		return modelAndView;
	}
	@RequestMapping(value = "/register")
	public String regisgterPage(Model model) {
		model.addAttribute("user", user);
		return "signup";
	}
	@RequestMapping("/ratingPage")
	public ModelAndView viewRatings(@RequestParam("mname") String mname,HttpSession session){
		if(session.getAttribute("username")==null)
		{

			return  new ModelAndView("logout");
		}
		ModelAndView mav =new ModelAndView("userRating");
		mav.addObject("mname",mname);
		return mav;

	}


	@RequestMapping("/")
	public ModelAndView home(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("mainPage");
		session.setAttribute("loggedout", "Home");
		List<Language> langs= languageService.getAllLanguages();
		session.setAttribute("langs", langs);
		List<Genre> gen= genreService.getAllGenres();
		session.setAttribute("gen",gen);
		List<MovieCategoryPerson> MCP = movieCategoryPersonService.findall();
		List<String>pnames=new ArrayList<String>();
		for(MovieCategoryPerson mcp : MCP)
		{
			int cid= mcp.getCategoryId();
			Category cat = categoryService.findByCategoryId(cid);
			if(cat.getCategoryName().equalsIgnoreCase("Director"))
			{
				int pid=mcp.getPersonId();
				Person per= personService.findByPersonId(pid);
				String personName=per.getPersonName();
				if(!pnames.contains(personName))
				pnames.add(personName);
			}
			
		}
		Collections.sort(pnames);
		session.setAttribute("director",pnames);	

		List<MovieCategoryPerson> MCP2 = movieCategoryPersonService.findall();
		List<String>pnames2=new ArrayList<String>();
		for(MovieCategoryPerson mcp : MCP2)
		{
			int cid= mcp.getCategoryId();
			Category cat = categoryService.findByCategoryId(cid);
			if(cat.getCategoryName().equalsIgnoreCase("Actor"))
			{
				int pid=mcp.getPersonId();
				Person per= personService.findByPersonId(pid);
				String personName=per.getPersonName();
				if(!pnames2.contains(personName))
				pnames2.add(personName);
			}

		}
		Collections.sort(pnames2);
		session.setAttribute("actor",pnames2);	
		List<MovieCategoryPerson> MCP3 = movieCategoryPersonService.findall();
		List<String>pnames3=new ArrayList<String>();
		for(MovieCategoryPerson mcp : MCP3)
		{
			int cid= mcp.getCategoryId();
			Category cat = categoryService.findByCategoryId(cid);
			if(cat.getCategoryName().equalsIgnoreCase("Actress"))
			{
				int pid=mcp.getPersonId();
				Person per= personService.findByPersonId(pid);
				String personName=per.getPersonName();
				if(!pnames3.contains(personName))
				pnames3.add(personName);
			}

		}
		Collections.sort(pnames3);
		session.setAttribute("actress",pnames3);	

		return modelAndView;
	}



	@RequestMapping("/specializedSearch")
	public ModelAndView specailedSearch(@RequestParam("language") String language,@RequestParam("genre") String genre,
			@RequestParam("director") String director,@RequestParam("actor") String actor,@RequestParam("actress") String actress,
			@RequestParam("rating") String rating,@RequestParam("regUser") String user ,HttpSession session)
	{


		Display d=null;
		List<Movies>slist=new ArrayList<Movies>();
		ModelAndView modelAndView =null;
		if(user.equalsIgnoreCase("mainPage"))
		{
			modelAndView = new ModelAndView("showresult");
		}
		else
		{
			if(session.getAttribute("username")==null)
			{

				return  new ModelAndView("logout");
			}
			modelAndView = new ModelAndView("showresultregistereduser");
		}

		for(Movies movie : movieService.getAllMovies() )
		{

			AllMovieDetailsPojo amdp=  reportMethod(movie.getMovie_id());
			String gen=amdp.getGenre();
			String dir=amdp.getDirector();
			String cast=amdp.getCast();
			String lang=amdp.getLanguage();
			int rate=amdp.getUser_rating();
			if((gen.contains(genre)||genre.contains("Select Genre")) &&(dir.contains(director)||director.contains("Select Director"))
					&&(cast.contains(actor)||actor.contains("Select Actor"))&&(cast.contains(actress)||actress.contains("Select Actress"))
					&&(language.contains(language)||lang.contains("Select Language"))&&(rating.contains(rate+"")||rating.contains("Select Rating")))
			{			
				slist.add(movie);
			}


		}
		List <String> imgList=new ArrayList<String>();
		for(Movies m:slist){

			try {
				String picname=m.getmovieName().replaceAll("\\s", "");
				Files.write(Paths.get("src/main/webapp/resources/retrieve-dir/" + picname+ "." + "png"), m.getPoster());
				String img="/resources/retrieve-dir/" + picname+ "." + "png";

				imgList.add(img);
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			d= new Display(slist,imgList);
			modelAndView.addObject("moviesList",d );
			System.out.print("test done");

		}
		if(d==null)
		{
			modelAndView= new ModelAndView("error");
			modelAndView.addObject("msg","Sorry No Movies Found Of These Criteria!!");
			if(user.equalsIgnoreCase("mainPage"))
			{
				modelAndView.addObject("back","/");
			}
			else
			{
				modelAndView.addObject("back","registeredUser");
			}
			return modelAndView;
		}
		return modelAndView;
	}



	//working

	@RequestMapping("/viewComments")
	public ModelAndView viewComments(@RequestParam("movieName") String mname,HttpSession session){
		ModelAndView mav =new ModelAndView("commentspage");
		if(session.getAttribute("username")==null)
		{

			return  new ModelAndView("logout");
		}
		mav.addObject("moviename",mname);
		Movies movie=movieService.findByMovieName(mname);
		int mid=movie.getMovie_id();
		AllMovieDetailsPojo mdetails=reportMethod(mid);
		String img="";
		try {
			String picname=mdetails.getMovieName().replaceAll("\\s", "");
			Files.write(Paths.get("src/main/webapp/resources/retrieve-dir/" + picname+ "." + "png"), mdetails.getPoster());
			img="/resources/retrieve-dir/" + picname+ "." + "png";
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("img",img);
		List <String> comments=new ArrayList<String>();
		List <Integer> rating=new ArrayList<Integer>();
		List <Integer> uid=new ArrayList<Integer>();
		for(UserRating UR:userRatingService.getAllUserRatings())
		{
			if(UR.getMovieId()==mid)
			{
				comments.add(UR.getComment());
				rating.add(UR.getRating());
				uid.add(UR.getUserId());
			}

		}


		List <String> users=new ArrayList<String>();
		for(int uids:uid)
		{
			for(User u:userService.getAllUsers())
			{
				if(uids==u.getId())
				{
					users.add(u.getFullname());
				}
			}
		}
		mav.addObject("Rating",rating);
		mav.addObject("Comment",comments);
		mav.addObject("user",users);

		if(users.isEmpty())
		{
			ModelAndView modelAndView= new ModelAndView("error");
			modelAndView.addObject("msg", "Sorry No Reviews Availble For This Movie Yet!!");
			modelAndView.addObject("back", "registeredUser");
			return modelAndView;
		}



		return mav;
	}




	// ADDED TO VIEW THE RATINGS PAGE
	@RequestMapping("/save_Rating") 
	public ModelAndView userRating(@RequestParam("mname") String mname,@RequestParam("rating") int rating,@RequestParam("comment") String comment
			,HttpSession session){
		if(session.getAttribute("username")==null)
		{

			return  new ModelAndView("logout");
		}
		ModelAndView mav =new ModelAndView("error");
		mav.addObject("back","registeredUser");

		System.out.print("mname is:"+mname); 
		List<UserRating> list= userRatingService.getAllUserRatings();
		int movieid=movieService.findByMovieName(mname).getMovie_id();
		int userid=userService.findByUsername(session.getAttribute("username").toString()).getId();
		for(UserRating ur: list)
		{
			int mid= ur.getMovieId();
			int uid= ur.getUserId();
			if((mid==movieid)&& uid==userid)
			{
				mav.addObject("msg","You Have Already Rated This Movie.."); 
				mav.addObject("back","registeredUser");
				return mav;
			}
		}
		int sno=userRatingService.getAllUserRatings().size()+1;
		UserRating ua= new UserRating(sno,userid,movieid,rating,comment);
		userRatingService.saveUserRating(ua);
		Movies m= movieService.findByMovieName(mname);
		m.setNo_of_user(m.getNo_of_user()+1);
		m.setUser_rating((m.getUser_rating()+rating)/m.getNo_of_user());
		movieService.saveMovie(m);
		mav.addObject("msg","Thanks For Reviewing This Movie.."); 
		mav.addObject("back","registeredUser");
		return mav;

	}
	// tHIS METHOD ADDED

	@RequestMapping("/movieDetailsRegisteredUser")
	public ModelAndView showDetails2(@RequestParam("movieName") String  movieName,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{

			return  new ModelAndView("logout");
		}
		ModelAndView mav =new ModelAndView("movie_details_registered_user");
		Movies movie=movieService.findByMovieName(movieName);
		AllMovieDetailsPojo mdetails=reportMethod(movie.getMovie_id());
		String img="";
		try {
			String picname=mdetails.getMovieName().replaceAll("\\s", "");
			Files.write(Paths.get("src/main/webapp/resources/retrieve-dir/" + picname+ "." + "png"), mdetails.getPoster());
			img="/resources/retrieve-dir/" + picname+ "." + "png";
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("img",img);
		mav.addObject("mdetails",mdetails);
		mav.addObject("movieName",movie.getmovieName());

		String casts[]=mdetails.getCast().split(",");
		List<String> imgList= new ArrayList<String>();
		List<String> nameList= new ArrayList<String>();

		for(String cnames:casts)
		{

			Person p=null;
			for(Person s: personService.getAllpersons())
			{
				if(s.getPersonName().equalsIgnoreCase(cnames))
				{
					p=s;
					break;
				}
			}


			try {
				String picname=p.getPersonName().replaceAll("\\s", "");
				Files.write(Paths.get("src/main/webapp/resources/retrieve-dir/" + picname+ "." + "png"), p.getPersonImage());
				String imgs="/resources/retrieve-dir/" + picname+ "." + "png";
				imgList.add(imgs);
				nameList.add(p.getPersonName()); 
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mav.addObject("nameList",nameList);
		mav.addObject("imgList",imgList);

		return mav;
	}


	@RequestMapping("/movieDetails")
	public ModelAndView showDetails(@RequestParam("movieName") String  movieName)
	{
		ModelAndView mav =new ModelAndView("movie_details");
		Movies movie=movieService.findByMovieName(movieName);
		AllMovieDetailsPojo mdetails=reportMethod(movie.getMovie_id());
		String img="";
		try {
			String picname=mdetails.getMovieName().replaceAll("\\s", "");
			Files.write(Paths.get("src/main/webapp/resources/retrieve-dir/" + picname+ "." + "png"), mdetails.getPoster());
			img="/resources/retrieve-dir/" + picname+ "." + "png";
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("img",img);
		mav.addObject("mdetails",mdetails);
		mav.addObject("movieName",movie.getmovieName());
		System.out.println("cast names:"+mdetails.getCast() );
		String casts[]=mdetails.getCast().split(",");
		List<String> imgList= new ArrayList<String>();
		List<String> nameList= new ArrayList<String>();

		for(String cnames:casts)
		{
			System.out.println("cnames"+cnames);
			Person p=null;
			for(Person s: personService.getAllpersons())
			{
				if(s.getPersonName().equalsIgnoreCase(cnames))
				{
					p=s;
					break;
				}
			}


			try {
				String picname=p.getPersonName().replaceAll("\\s", "");
				System.out.println("inner"+picname);

				Files.write(Paths.get("src/main/webapp/resources/retrieve-dir/" + picname+ "." + "png"), p.getPersonImage());
				String imgs="/resources/retrieve-dir/" + picname+ "." + "png";
				imgList.add(imgs);
				nameList.add(p.getPersonName()); 
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mav.addObject("nameList",nameList);
		mav.addObject("imgList",imgList);

		return mav;
	}

	//edit form


	@RequestMapping(value = "/personalized")
	public ModelAndView PersonalizedPage(HttpSession session) {
		if(session.getAttribute("username")==null)
		{

			return  new ModelAndView("logout");
		}
		ModelAndView modelAndView= new ModelAndView("user_personalisation");
		List<UserPersonalization> UP=userPersonalizationService.getAlluserPersonalizations();
		List<Integer>moviesList=new ArrayList<Integer>();
		for(UserPersonalization up : UP)
		{
			int gid= up.getGenreId();
			for(MovieGenre MG : movieGenreService.getAllMovieGenres())
			{
				if(MG.getGenreId()==gid)
				{
					if(!(moviesList.contains(MG.getMovieId())))
					{
						moviesList.add(MG.getMovieId());
					}
				}
			}
		}
		List<AllMovieDetailsPojo>movies=new ArrayList<AllMovieDetailsPojo>();
		List<String>imgList=new ArrayList<String>();
		for(int i : moviesList)
		{
			movies.add(reportMethod(i));
			try {
				String picname=(reportMethod(i).getMovieName().replaceAll("\\s", ""));
				Files.write(Paths.get("src/main/webapp/resources/retrieve-dir/" + picname+ "." + "png"), reportMethod(i).getPoster());
				String imgs="/resources/retrieve-dir/" + picname+ "." + "png";
				imgList.add(imgs);
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		modelAndView.addObject("img",imgList);
		modelAndView.addObject("mname",movies);

		return modelAndView;
	}




	@RequestMapping("/registerdUsernameSearch")
	public ModelAndView nameSearchRegisterUser(@RequestParam("movname") String movieName,Model model,HttpSession session) {
		if(session.getAttribute("username")==null)
		{

			return  new ModelAndView("logout");
		}
		List<Movies> mlist=movieService.getAllMovies();
		List<Movies> slist=new ArrayList<Movies>();
		int q=0;
		// adding picture code
		int count=0;
		for(Movies m:mlist)
		{
			System.out.println(m.getmovieName());
			String mname=m.getmovieName().toLowerCase();

			if(mname.contains(movieName.toLowerCase()))
			{

				slist.add(m);
				q=1;
				//trail code for personalization

				String genre=reportMethod(m.getMovie_id()).getGenre();

				String genList[]=genre.split(",");



				for(int i=0;i<genList.length;i++)
				{

					int gid=genreService.findByGenreName(genList[i]).getGenreId();

					int uid=userService.findByUsername(session.getAttribute("username").toString()).getId();

					List<UserPersonalization> UP = userPersonalizationService.getAlluserPersonalizations();
					if(UP.isEmpty())
					{
						System.out.print("block 1");
						int sno=userPersonalizationService.getAlluserPersonalizations().size()+1;
						userPersonalizationService.saveuserPersonalization(new UserPersonalization(sno,uid,m.getMovie_id(),gid));
					}

					else
					{
						for(UserPersonalization up: UP)
						{

							if(!(up.getUserId()==uid && up.getMovieId()==m.getMovie_id()))
							{

								for(UserPersonalization up2: UP)
								{

									if(up2.getUserId()==uid)
									{
										count++;

									}
								}
								if(count<=2)
								{

									int sno=userPersonalizationService.getAlluserPersonalizations().size()+1;
									System.out.print("block 2");
									userPersonalizationService.saveuserPersonalization(new UserPersonalization(sno,uid,m.getMovie_id(),gid));
								}
								else
								{
									for(UserPersonalization up2: UP)
									{
										if(up2.getUserId()==uid)
										{
											int sno=up2.getSno();
											UserPersonalization personalise= new UserPersonalization(sno,uid,m.getMovie_id(),gid);
											userPersonalizationService.saveuserPersonalization(personalise);
											System.out.print("block 3");
											break;
										}
									}
									break;
								}
								break;
							}
						}
					}
				}

				//

			}
		}
		if(q==0)
		{
			ModelAndView mav2 = new ModelAndView("error");
			mav2.addObject("msg","Sorry! No results Found For Your Search");
			mav2.addObject("back","registeredUser");
			return mav2;
		}
		else{
			ModelAndView mav = new ModelAndView("showresultregistereduser");  
			List <String> imgList=new ArrayList<String>();
			for(Movies m:slist){
				//showing image	 
				try {
					String picname=m.getmovieName().replaceAll("\\s", "");
					Files.write(Paths.get("src/main/webapp/resources/retrieve-dir/" + picname+ "." + "png"), m.getPoster());
					String img="/resources/retrieve-dir/" + picname+ "." + "png";

					imgList.add(img);

				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Display d= new Display(slist,imgList);
				model.addAttribute("moviesList",d );
			}
			return mav;	

		}
	}

	@RequestMapping("/nameSearch")
	public ModelAndView nameSearch(@RequestParam("movname") String movieName,Model model) {
		List<Movies> mlist=movieService.getAllMovies();
		List<Movies> slist=new ArrayList<Movies>();
		int q=0;
		// adding picture code
		for(Movies m:mlist)
		{
			String mname=m.getmovieName().toLowerCase();
			if(mname.contains(movieName.toLowerCase()))
			{

				slist.add(m);
				q=1;
			}
		}
		if(q==0)
		{
			ModelAndView mav2 = new ModelAndView("error");
			mav2.addObject("msg","Sorry! No results Found For Your Search");
			mav2.addObject("back","/");
			return mav2;
		}
		else{
			ModelAndView mav = new ModelAndView("showresult");  
			List <String> imgList=new ArrayList<String>();
			for(Movies m:slist){
				//showing image	 
				try {
					String picname=m.getmovieName().replaceAll("\\s", "");
					Files.write(Paths.get("src/main/webapp/resources/retrieve-dir/" + picname+ "." + "png"), m.getPoster());
					String img="/resources/retrieve-dir/" + picname+ "." + "png";

					imgList.add(img);
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Display d= new Display(slist,imgList);
				model.addAttribute("moviesList",d );
			}
			return mav;	

		}
	}





	public AllMovieDetailsPojo reportMethod(int mid)
	{
		List <Movies> allmovies= movieService.getAllMovies();
		Movies m=null;
		for(Movies m0: allmovies)
		{
			if(m0.getMovie_id()==mid)
			{
				m=m0;
				break;
			}
		}


		AllMovieDetailsPojo amdp= new AllMovieDetailsPojo();
		amdp.setMovieName(m.getmovieName());
		amdp.setPlot(m.getPlot());
		amdp.setPoster(m.getPoster());
		amdp.setNo_of_user(m.getNo_of_user());
		amdp.setRuntime(m.getRuntime());
		amdp.setRelease_date(m.getRelease_date());
		amdp.setTagline(m.getTagline());
		amdp.setTrailer(m.getTrailer());
		amdp.setUser_rating(m.getUser_rating());

		List <Integer> gids= new ArrayList<Integer>();
		List<MovieGenre> genlist= movieGenreService.getAllMovieGenres();
		for(MovieGenre gen : genlist )
		{
			if(gen.getMovieId()==mid)
			{
				gids.add(gen.getGenreId());
			}

		}
		String genre="";
		List <Genre> allgens= genreService.getAllGenres();
		for(Genre gen : allgens )
		{
			for(int  gid : gids )
			{
				if(gen.getGenreId()==gid)
				{
					genre=genre+gen.getGenreName()+",";
				}
			}

		}
		//genre done
		if(genre.contains(","))
		{
			genre=genre.substring(0,(genre.length())-1);
		}

		amdp.setGenre(genre);
		List<MovieCategoryPerson>  MCP= movieCategoryPersonService.findall();
		List<Integer> pid=new ArrayList<Integer>();
		List<Integer> cid=new ArrayList<Integer>();
		for(MovieCategoryPerson mcp: MCP)
		{
			if(mcp.getMovieId()==mid)
			{
				pid.add(mcp.getPersonId());
				cid.add(mcp.getCategoryId());

			}

		}
		String cast[];
		String person[];
		cast= new String[cid.size()];
		person=new String[cid.size()];
		for(int i=0;i<cid.size();i++)
		{
			int cid_cid=cid.get(i);
			Category cat=categoryService.findByCategoryId(cid_cid);
			cast[i]=cat.getCategoryName();
			int perid=pid.get(i);
			Person p=personService.findByPersonId(perid);
			person[i]=p.getPersonName();

		}
		String Director="";
		String Producer="";
		String Cast="";
		for(int i=0;i<cid.size();i++)
		{
			if(cast[i].equalsIgnoreCase("Director")||cast[i].equalsIgnoreCase("Writer"))
			{
				Director=Director+person[i]+",";
			}
			else if(cast[i].equalsIgnoreCase("Producer"))
			{
				Producer=Producer+person[i]+",";
			}
			else if(cast[i].equalsIgnoreCase("Actor")||cast[i].equalsIgnoreCase("Actress"))
			{
				Cast= Cast+ person[i] + "," ;
			}

		}


		if(Cast.contains(","))
		{
			Cast=Cast.substring(0,(Cast.length())-1);
		}
		if(Director.contains(","))
		{
			Director=Director.substring(0,(Director.length())-1);
		}
		if(Producer.contains(","))
		{
			Producer=Producer.substring(0,(Producer.length())-1);
		}


		amdp.setDirector(Director);
		amdp.setCast(Cast);
		amdp.setProducer(Producer);
		////

		List <Integer> lids= new ArrayList<Integer>();
		List<MovieLanguage> langList= movieLanguageService.getAllMovieLanguage();
		for(MovieLanguage lan : langList )
		{
			if(lan.getMovieId()==mid)
			{
				lids.add(lan.getLanguageId());
			}

		}
		String language="";
		List <Language> alllangs= languageService.getAllLanguages();
		for(Language lang : alllangs )
		{
			for(int  gid : lids )
			{
				if(lang.getlanguageId()==gid)
				{
					language=language+lang.getlanguageName()+",";
				}
			}

		}
		if(language.contains(","))
		{
			language=language.substring(0,(language.length())-1);
		}

		amdp.setLanguage(language);
		List <Integer> companyids= new ArrayList<Integer>();
		List<MovieCompany> companylist= moviecompanyService.getAllMovieCompany();
		for(MovieCompany moviecomp : companylist )
		{
			if(moviecomp.getMovieId()==mid)
			{
				companyids.add(moviecomp.getCompanyId());
			}

		}

		String company="";
		List <Company> allcompanies= companyService.getAllCompanys();
		for(Company comp : allcompanies )
		{
			for(int  companyid : companyids )
			{
				if(comp.getCompanyId()==companyid)
				{
					company=company+comp.getCompanyName()+",";
				}
			}

		}
		//genre done
		if(company.contains(","))
		{
			company=company.substring(0,(company.length())-1);
		}

		amdp.setCompany(company);

		String awards="";
		for(MovieAward award: movieAwardService.getAllMovieAwards())
		{
			if(award.getMovieId()==mid)
			{
				int aid=award.getAwardId();
				Award a=awardService.findByAwardId(aid);
				awards=awards+"\n"+a.getawardName()+":"+award.getCategory()+",";
			}

		}
		if(awards.contains(","))
		{
			awards=awards.substring(0,(awards.length())-1);
		}
		amdp.setAwards(awards);
		return amdp;

	}

	@RequestMapping("/reportChange")
	public ModelAndView reportChange(@RequestParam("category") String category,HttpSession session)
	{
		int flag=0;
		if(session.getAttribute("username")==null)
		{

			return  new ModelAndView("logout");
		}
		ModelAndView mav= new ModelAndView("reportdetails");
		
		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Movie Name Wise"))
		{
			flag=1;
			Movies movie= movieService.findByMovieName(category);
			int mid=movie.getMovie_id();
			List<AllMovieDetailsPojo> amdp= new ArrayList<AllMovieDetailsPojo>();
			amdp.add(reportMethod(mid));
			mav.addObject("moviedetails",amdp);		
		}

		//DIRECTOR WISE
		if (session.getAttribute("reportType").toString().equalsIgnoreCase("Director Wise")) {
			flag=1;
			List<MovieCategoryPerson> MCP = movieCategoryPersonService.findall();
			Person p = personService.findBypersonName(category);
			int pid = p.getPersonId();
			List<Integer> allmovies = new ArrayList<Integer>();
			for (MovieCategoryPerson mcp : MCP) {
				if (mcp.getPersonId() == pid) {
					allmovies.add(mcp.getMovieId());
				}
			}
			List<AllMovieDetailsPojo> returnLists = new ArrayList<AllMovieDetailsPojo>();
			for (int mids : allmovies) {
				int q=0;
				for(AllMovieDetailsPojo amdp:returnLists)
				{

					if(mids==movieService.findByMovieName(amdp.getMovieName()).getMovie_id())
					{
						q=1;
					}
				}
				if(q==0)
				{
					returnLists.add(reportMethod(mids));
				}
				
			}
			mav.addObject("moviedetails", returnLists);
		}


		//ACTOR/ACTRESS WISE
		if (session.getAttribute("reportType").toString().equalsIgnoreCase("Actor/Actress Wise")) {
			flag=1;
			List<MovieCategoryPerson> MCP = movieCategoryPersonService.findall();
			Person p = personService.findBypersonName(category);
			int pid = p.getPersonId();
			List<Integer> allmovies = new ArrayList<Integer>();
			for (MovieCategoryPerson mcp : MCP) {
				if (mcp.getPersonId() == pid) {
					allmovies.add(mcp.getMovieId());
				}
			}
			List<AllMovieDetailsPojo> returnLists = new ArrayList<AllMovieDetailsPojo>();
			for (int mids : allmovies) {
				int q=0;
				for(AllMovieDetailsPojo amdp:returnLists)
				{

					if(mids==movieService.findByMovieName(amdp.getMovieName()).getMovie_id())
					{
						q=1;
					}
				}
				if(q==0)
				{
					returnLists.add(reportMethod(mids));
				}
				

			}
			mav.addObject("moviedetails", returnLists);
		}





		//progress date 04-06-2021
		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Genre Wise"))
		{
			Genre g=genreService.findByGenreName(category);
			int gid=g.getGenreId();

			List<Integer>allmovies=new ArrayList<Integer>();
			List<MovieGenre> mg=movieGenreService.getAllMovieGenres();

			for(MovieGenre moviegenre:mg)
			{
				if(moviegenre.getGenreId()==gid)
				{
					allmovies.add(moviegenre.getMovieId());
				}
			}

			List<AllMovieDetailsPojo>returnLists=new ArrayList<AllMovieDetailsPojo>();

			for(int mids:allmovies)
			{
				returnLists.add(reportMethod(mids));

			}
			if(returnLists.size()>0)
				flag=1;
			mav.addObject("moviedetails",returnLists);
			



		}// end

		//PRODUCER WISE

		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Producer Wise"))
		{
			flag=1;
			List<MovieCategoryPerson> MCP = movieCategoryPersonService.findall();
			Person p = personService.findBypersonName(category);
			int pid = p.getPersonId();
			List<Integer> allmovies = new ArrayList<Integer>();
			for (MovieCategoryPerson mcp : MCP) {
				if (mcp.getPersonId() == pid) {
					allmovies.add(mcp.getMovieId());
				}
			}
			List<AllMovieDetailsPojo> returnLists = new ArrayList<AllMovieDetailsPojo>();
			for (int mids : allmovies) {
				int q=0;
				for(AllMovieDetailsPojo amdp:returnLists)
				{

					if(mids==movieService.findByMovieName(amdp.getMovieName()).getMovie_id())
					{
						q=1;
					}
				}
				if(q==0)
				{
					returnLists.add(reportMethod(mids));
				}
				
			}
			mav.addObject("moviedetails", returnLists);
		}

		//LANGUAGE WISE

		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Language Wise"))
		{
			Language l=languageService.findByLanguageName(category);
			int lid=l.getlanguageId();
			List<Integer>allmovies = new ArrayList<Integer>();
			List<MovieLanguage> ml=movieLanguageService.getAllMovieLanguage();
			for(MovieLanguage movielang:ml)
			{
				if(movielang.getLanguageId()==lid)
				{
					allmovies.add(movielang.getMovieId());
				}
			}

			List<AllMovieDetailsPojo>returnlists=new ArrayList<AllMovieDetailsPojo>();
			for(int mids:allmovies)
			{
				returnlists.add(reportMethod(mids));
			}
			if(returnlists.size()>0)
				flag=1;

			mav.addObject("moviedetails",returnlists);

		}
		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Release Year Wise"))
		{
			List<Movies>movies=	movieService.getAllMovies();
			List<AllMovieDetailsPojo>returnlists=new ArrayList<AllMovieDetailsPojo>();
			for(Movies movie: movies)
			{
				String Date1=movie.getRelease_date()+"";

				if(Date1.substring(0,4).equalsIgnoreCase(category))
				{
					returnlists.add(reportMethod(movie.getMovie_id()));
				}
			}
			flag=1;
			mav.addObject("moviedetails",returnlists);


		}

		//COMPANY WISE
		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Company Wise"))
		{
			List<Integer>allmovies=new ArrayList<Integer>();
			List<MovieCompany> mc = moviecompanyService.getAllMovieCompany();
			Company c=companyService.findByCompanyName(category);
			int companyid=c.getCompanyId();
			for(MovieCompany moviecompany:mc)
			{
				if(moviecompany.getCompanyId()==companyid)
				{
					allmovies.add(moviecompany.getMovieId());
				}
			}

			List<AllMovieDetailsPojo>returnLists=new ArrayList<AllMovieDetailsPojo>();

			for(int mids:allmovies)
			{
				returnLists.add(reportMethod(mids));

			}
			if(returnLists.size()>0)
				flag=1;
			mav.addObject("moviedetails",returnLists);




		}// end
		//
		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Current Movies Report"))
		{
			List<AllMovieDetailsPojo>returnLists=new ArrayList<AllMovieDetailsPojo>();

			Movies mo= movieService.findByMovieName(category);
			returnLists.add(reportMethod(mo.getMovie_id()));
			if(returnLists.size()>0)
				flag=1;
			mav.addObject("moviedetails",returnLists);

		}
		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Upcoming Movies"))
		{
			List<AllMovieDetailsPojo>returnLists=new ArrayList<AllMovieDetailsPojo>();
			Movies mo= movieService.findByMovieName(category);
			returnLists.add(reportMethod(mo.getMovie_id()));
			if(returnLists.size()>0)
				flag=1;
			mav.addObject("moviedetails",returnLists);



		}
		if(flag==1)
		{
		List<String> heading=new ArrayList<String>();
		mav.addObject("h2","");
		heading.add("Movie Name");
		heading.add("Tagline");
		heading.add("Release Date");
		heading.add("Runtime");
		heading.add("User Rating");
		heading.add("Genre");
		heading.add("Cast");
		heading.add("Producer");
		heading.add("Director & Writer");
		heading.add("Company");
		mav.addObject("heading",heading);
		}
		else
		{
			mav.addObject("h2","Sorry No Movies Found!!");
		}
		
		mav.addObject("type",(String)session.getAttribute("reportType"));
		
		return mav;
	}

	///////////////////////////////////////////////////////////////////////////

	@RequestMapping("/showReports")
	public ModelAndView showReports( @RequestParam("reportType") String reportType , HttpSession session) {
		System.out.println("reportTpe:"+reportType);

		if(session.getAttribute("username")==null)
		{

			return  new ModelAndView("logout");
		}
		session.setAttribute("reportType", reportType);

		ModelAndView mav= new ModelAndView("reportdetails");
		mav.addObject("h2","Please Select Category To View Reports");
		mav.addObject("type",reportType);
		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Movie Name Wise"))
		{
			List <Movies> allmovies= movieService.getAllMovies();
			List <String> movieNames= new ArrayList<String>();
			for(Movies m: allmovies)
			{
				movieNames.add(m.getmovieName());
			}
			session.setAttribute("category","Movie");
			Collections.sort(movieNames);
			session.setAttribute("item",movieNames);		

		}
		//added
		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Genre Wise"))
		{
			List <Genre> allgenres= genreService.getAllGenres();
			List <String> GenreNames= new ArrayList<String>();
			for(Genre g: allgenres)
			{
				GenreNames.add(g.getGenreName());
			}
			session.setAttribute("category","Genre");
			Collections.sort(GenreNames);
			session.setAttribute("item",GenreNames);
		}//working

		//added
		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Company Wise"))
		{
			List <Company> allcompanys= companyService.getAllCompanys();
			List <String> CompanyNames= new ArrayList<String>();
			for(Company c: allcompanys)
			{
				CompanyNames.add(c.getCompanyName());
			}
			session.setAttribute("category","Company");
			Collections.sort(CompanyNames);
			session.setAttribute("item",CompanyNames);	

		}//working
		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Director Wise"))
		{
			List<MovieCategoryPerson> MCP = movieCategoryPersonService.findall();
			List<String>pnames=new ArrayList<String>();
			for(MovieCategoryPerson mcp : MCP)
			{
				int cid= mcp.getCategoryId();
				Category cat = categoryService.findByCategoryId(cid);
				if(cat.getCategoryName().equalsIgnoreCase("Director"))
				{
					int pid=mcp.getPersonId();
					Person per= personService.findByPersonId(pid);
					String personName=per.getPersonName();
					if(!pnames.contains(personName))
					pnames.add(personName);
				}

			}
			session.setAttribute("category","Director");
			Collections.sort(pnames);
			session.setAttribute("item",pnames);	
		}
		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Producer Wise"))
		{
			List<MovieCategoryPerson> MCP = movieCategoryPersonService.findall();
			List<String>pnames=new ArrayList<String>();
			for(MovieCategoryPerson mcp : MCP)
			{
				int cid= mcp.getCategoryId();
				Category cat = categoryService.findByCategoryId(cid);
				if(cat.getCategoryName().equalsIgnoreCase("Producer"))
				{
					int pid=mcp.getPersonId();
					Person per= personService.findByPersonId(pid);
					String personName=per.getPersonName();
					if(!pnames.contains(personName))
					pnames.add(personName);
				}

			}
			session.setAttribute("category","Producer");
			Collections.sort(pnames);
			session.setAttribute("item",pnames);	
		}

		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Actor/Actress Wise"))
		{
			List<MovieCategoryPerson> MCP = movieCategoryPersonService.findall();
			List<String>pnames=new ArrayList<String>();
			for(MovieCategoryPerson mcp : MCP)
			{
				int cid= mcp.getCategoryId();
				Category cat = categoryService.findByCategoryId(cid);
				if(cat.getCategoryName().equalsIgnoreCase("Actor") || cat.getCategoryName().equalsIgnoreCase("Actress"))
				{
					int pid=mcp.getPersonId();
					Person per= personService.findByPersonId(pid);
					String personName=per.getPersonName();
					if(!pnames.contains(personName))
					{
					pnames.add(personName);
					}
				}

			}
			Collections.sort(pnames);
			session.setAttribute("category","Actor/Actress");
			session.setAttribute("item",pnames);	
		}

		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Release Year Wise"))
		{
			List<Movies>movies=	movieService.getAllMovies();
			List<String>dates=new ArrayList<String>();
			for(Movies movie: movies)
			{
				String Date1=movie.getRelease_date()+"";
				Date1=Date1.substring(0,4);
				if(!dates.contains(Date1))
				{
					dates.add(Date1);
				}
			}
			session.setAttribute("category","Release Year");
			Collections.sort(dates);
			session.setAttribute("item",dates);
		}

		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Language Wise"))
		{
			List<Language>langs=	languageService.getAllLanguages();
			List<String>dates=new ArrayList<String>();
			for(Language movie: langs)
			{

				dates.add(movie.getlanguageName() );
			}
			Collections.sort(dates);
			session.setAttribute("category","Language");
			session.setAttribute("item",dates);
		}

		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Current Movies Report"))
		{
			List<Movies>movies=	movieService.getAllMovies();

			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			Calendar c = Calendar.getInstance();
			c.setTime(sqlDate);
			c.add(Calendar.DATE, 30);
			c.setTime(sqlDate);
			c.add(Calendar.DATE,-30);
			java.sql.Date pastDate= new java.sql.Date (c.getTimeInMillis());

			List<String>dates=new ArrayList<String>();
			for(Movies m: movies)
			{
				java.sql.Date dt=m.getRelease_date();
				if(dt.after(pastDate) && ((dt.before(sqlDate))))
				{
					dates.add(m.getmovieName());
				}

			}
			session.setAttribute("category","Current Movies Report");
			Collections.sort(dates);
			session.setAttribute("item",dates);


		}


		if(session.getAttribute("reportType").toString().equalsIgnoreCase("Upcoming Movies"))
		{
			List<Movies>movies=	movieService.getAllMovies();
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());       
			List<String>dates=new ArrayList<String>();
			for(Movies m: movies)
			{
				java.sql.Date dt=m.getRelease_date();
				if(dt.after(sqlDate))
				{
					dates.add(m.getmovieName());
				}

			}
			session.setAttribute("category","Upcoming Movies");
			Collections.sort(dates);
			session.setAttribute("item",dates);


		}

		return mav;
	}

	//ended


}	


