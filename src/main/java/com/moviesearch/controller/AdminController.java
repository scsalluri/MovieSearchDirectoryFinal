package com.moviesearch.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.moviesearch.model.Award;
import com.moviesearch.model.Category;
import com.moviesearch.model.Company;
import com.moviesearch.model.Genre;
import com.moviesearch.model.Language;
import com.moviesearch.model.MovieAward;
import com.moviesearch.model.MovieCategoryPerson;
import com.moviesearch.model.MovieCompany;
import com.moviesearch.model.MovieGenre;
import com.moviesearch.model.MovieLanguage;
import com.moviesearch.model.Movies;
import com.moviesearch.model.Person;
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




@Controller
public class AdminController {
	@Value("${upoadDir}")
	private String uploadFolder;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired


	public AdminController()
	{

	}

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
	private CategoryService categoryService;
	@Autowired
	private PersonService personService;
	@Autowired
	private MovieCategoryPersonService movieCategoryPersonService;


	@RequestMapping(value = "/adminPage")
	public String adminPage(HttpSession session) {
		if(session.getAttribute("username")==null)
		{
			return "logout";
		}
		return "adminPage";
	}
	@RequestMapping("/movieForm")
	public ModelAndView movieForm(Model model,HttpSession session) {
		
		ModelAndView mav = new ModelAndView("movieForm");
		if(session.getAttribute("username")==null)
		{
			mav = new ModelAndView("logout");
			return mav;
		}
		
		
		List<Language> lang= languageService.getAllLanguages();
		List<String> langs= new ArrayList<String>();
		for(Language l :lang )
		{
			langs.add(l.getlanguageName());
		}
		Collections.sort(langs);
		mav.addObject("langs",langs);


		List<Company> comp= companyService.getAllCompanys();
		List<String>comps= new ArrayList<String>();
		for(Company c :comp )
		{
			comps.add(c.getCompanyName());
		}
		Collections.sort(comps);
		mav.addObject("comp",comps);



		List<Genre> gen= genreService.getAllGenres();

		List<String>gens= new ArrayList<String>();
		for(Genre c :gen )
		{
			gens.add(c.getGenreName());
		}
		Collections.sort(gens);
		mav.addObject("gen",gens);


		List<Person> per= personService.getAllpersons();

		List<String>pers= new ArrayList<String>();
		for(Person c :per )
		{
			pers.add(c.getPersonName());
		}
		Collections.sort(pers);
		mav.addObject("castnames",pers);
		List<Category> cat= categoryService.getAllCategorys();
		pers= new ArrayList<String>();
		for(Category c :cat )
		{
			pers.add(c.getCategoryName());
		}
		Collections.sort(pers);
		mav.addObject("category",pers);


		return mav;
	}


	@RequestMapping("/castForm")
	public String castForm(HttpSession session) {
		if(session.getAttribute("username")==null)
		{
		
			return "logout";
		}
		
		return "cast_form";

	}
	@RequestMapping("/language")
	public String language(HttpSession session) {
		if(session.getAttribute("username")==null)
		{
		
			return "logout";
		}
		return "language";

	}
	@RequestMapping("/genre")
	public String genre(HttpSession session) {
		
		if(session.getAttribute("username")==null)
		{
		
			return "logout";
		}
		return "genre";

	}

	@RequestMapping("/comp")
	public String companyForm(HttpSession session) {
		if(session.getAttribute("username")==null)
		{
		
			return "logout";
		}
		return "company";
	}

	@RequestMapping(value = "/award")
	public String award(HttpSession session) {
		if(session.getAttribute("username")==null)
		{
		
			return "logout";
		}
		return "award";
	}

	@RequestMapping(value = "/awardForm")
	public ModelAndView awardForm(HttpSession session) {
		ModelAndView mav= new ModelAndView("awardForm");
		mav.addObject("movieNames",movieService.getAllMovies());
		mav.addObject("awardNames",awardService.getAllAwards());
		if(session.getAttribute("username")==null)
		{
		
			return  new ModelAndView("logout");
		}
		
		return mav;
	}

	@RequestMapping(value = "/saveAwardForm")
	public ModelAndView saveAwardForm(@RequestParam("movieNames") String mname,@RequestParam("awardNames") String aname,@RequestParam("Category") String cate,HttpSession session ){
		ModelAndView mav= new ModelAndView("error");
		if(session.getAttribute("username")==null)
		{
		
			return  new ModelAndView("logout");
		}
		
		int sno=movieAwardService.getAllMovieAwards().size()+1;
		int mid=movieService.findByMovieName(mname).getMovie_id();
		int aid=awardService.findByAwardName(aname).getawardId();
		for(MovieAward m: movieAwardService.getAllMovieAwards())
		{
			if(m.getMovieId()==mid && m.getAwardId()==aid && m.getCategory().equalsIgnoreCase(cate))
			{
				mav.addObject("msg","Award Already Given To Movie");
				mav.addObject("back","adminPage");
				return mav;
			}

		}

		MovieAward maward= new MovieAward(sno, mid, aid, cate);
		movieAwardService.saveMovieAward(maward);
		mav.addObject("msg","Award Given To Movie Successfully");
		mav.addObject("back","adminPage");
		return mav;
	}
	@PostMapping("/save_cast")
	public ModelAndView saveCast(@RequestParam("fname")String fname,@RequestParam("lname") String lname,final @RequestParam("image") MultipartFile file,HttpServletRequest request,HttpSession session) throws IOException
	{
		ModelAndView mav= new ModelAndView("error");
		
		if(session.getAttribute("username")==null)
		{
		
			return  new ModelAndView("logout");
		}
		
		
		String pname= fname+" "+lname;
		if(personService.findBypersonName(pname)!=null)
		{
			mav.addObject("msg","Person Already Exists");
			mav.addObject("back","adminPage");
			return mav;
		}
		else
		{
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			log.info("uploadDirectory:: " + uploadDirectory);
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			log.info("FileName: " + file.getOriginalFilename());
			if (fileName == null || fileName.contains("..")) {
				mav.addObject("msg","Sorry! Filename contains invalid path sequence \" + fileName");
			}
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					log.info("Folder Created");
					dir.mkdirs();
				}
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				log.info("in catch");
				e.printStackTrace();
			}
			byte[] imageData = file.getBytes();
			System.out.print(imageData);
			int s= personService.getAllpersons().size() + 1;
			Person p= new Person(s, pname, imageData);
			personService.SaveyPerson(p);
			mav.addObject("msg","Cast Added Successfully");
			mav.addObject("back","adminPage");
			return mav;	
		}




	}


	@RequestMapping("/movie_change")
	public ModelAndView showMovieDetails(@RequestParam("movie") String movie,HttpSession session)
	{

		ModelAndView mav =new ModelAndView("Edit_form");
		
		if(session.getAttribute("username")==null)
		{
		
			return  new ModelAndView("logout");
		}
		
		List <Movies> movies=movieService.getAllMovies();
		List<String> mo= new ArrayList<String>();
		for(Movies m :movies )
		{
			mo.add(m.getmovieName().toLowerCase());
		}
		Collections.sort(mo);

		mav.addObject("allMovies",mo);
		Movies selectedmovie=movieService.findByMovieName(movie);
		mav.addObject("movieName",selectedmovie.getmovieName());
		mav.addObject("tagline",selectedmovie.getTagline());
		mav.addObject("date",selectedmovie.getRelease_date());
		mav.addObject("runtime",selectedmovie.getRuntime());
		mav.addObject("plot",selectedmovie.getPlot());
		mav.addObject("trailer",selectedmovie.getTrailer());

		List<Language> lang= languageService.getAllLanguages();
		List<String> langs= new ArrayList<String>();
		for(Language l :lang )
		{
			langs.add(l.getlanguageName());
		}
		Collections.sort(langs);
		mav.addObject("langs",langs);


		List<Company> comp= companyService.getAllCompanys();
		List<String>comps= new ArrayList<String>();
		for(Company c :comp )
		{
			comps.add(c.getCompanyName());
		}
		Collections.sort(comps);
		mav.addObject("comp",comps);



		List<Genre> gen= genreService.getAllGenres();

		List<String>gens= new ArrayList<String>();
		for(Genre c :gen )
		{
			gens.add(c.getGenreName());
		}
		Collections.sort(gens);
		mav.addObject("gen",gens);


		List<Person> per= personService.getAllpersons();

		List<String>pers= new ArrayList<String>();
		for(Person c :per )
		{
			pers.add(c.getPersonName());
		}
		Collections.sort(pers);
		mav.addObject("castnames",pers);
		List<Category> cat= categoryService.getAllCategorys();
		pers= new ArrayList<String>();
		for(Category c :cat )
		{
			pers.add(c.getCategoryName());
		}
		Collections.sort(pers);
		mav.addObject("category",pers);
		String img="";
		try {
			String picname=selectedmovie.getmovieName().replaceAll("\\s", "");
			Files.write(Paths.get("src/main/webapp/resources/retrieve-dir/" + picname+ "." + "png"), selectedmovie.getPoster());
			img="/resources/retrieve-dir/" + picname+ "." + "png";

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("img",img );

		return mav;
	}
	@PostMapping("/save-movie")
	public ModelAndView addMovie(@RequestParam("movie_name") String movie_name,
			@RequestParam("release_date") String release_date, @RequestParam("runtime") int runtime,
			@RequestParam("tagline") String tagline, @RequestParam("plot") String plot,
			@RequestParam("trailer") String trailer, @RequestParam("lang") String language,
			@RequestParam("company") String company, @RequestParam("castnames") String castnames,
			@RequestParam("category") String category,@RequestParam("genre") String genre,
			Model model, HttpServletRequest request, final @RequestParam("image") MultipartFile file,HttpSession session) {
		ModelAndView mav= new ModelAndView("error");

		if(session.getAttribute("username")==null)
		{
		
			return  new ModelAndView("logout");
		}
		
		if(movieService.findByMovieName(movie_name)==null)
		{
			if(!((category.contains("Actor")||category.contains("Actress"))&&category.contains("Producer")&&category.contains("Director")))
			{
				mav.addObject("msg","Please Select Atleast One Actor/Actress,Director,Producer");
				return mav;
			}


			String cast1[]= castnames.split(",");
			for(int i=0;i<cast1.length;i++)
			{
				String nm=cast1[i];
				List<Person> allpers= personService.getAllpersons();
				int x=1;
				for(Person px : allpers){
					if(px.getPersonName().equalsIgnoreCase(nm)){
						x=0;
					}
				}
				if(x==1)
				{
					mav.addObject("msg","Invalid Person Name Or Person Not Found In Database..");
					return mav;	
				}
			}


			try {
				// String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
				String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
				log.info("uploadDirectory:: " + uploadDirectory);
				String fileName = file.getOriginalFilename();
				String filePath = Paths.get(uploadDirectory, fileName).toString();
				log.info("FileName: " + file.getOriginalFilename());
				if (fileName == null || fileName.contains("..")) {
					mav.addObject("msg", "Sorry! Filename contains invalid path sequence \" + fileName");
					return mav;
				}
				try {
					File dir = new File(uploadDirectory);
					if (!dir.exists()) {
						log.info("Folder Created");
						dir.mkdirs();
					}
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
					stream.write(file.getBytes());
					stream.close();
				} catch (Exception e) {
					log.info("in catch");
					e.printStackTrace();
				}
				byte[] imageData = file.getBytes();

				java.sql.Date date = java.sql.Date.valueOf(release_date);
				Movies m = new Movies(movie_name, tagline, plot, imageData, date, runtime, trailer);
				//saving movie("validation nnot done yet")
				movieService.saveMovie(m);
				m= movieService.findByMovieName(m.getmovieName());
				int mid=m.getMovie_id();


				if(language.contains(","))
				{
					String langarr[];
					langarr=language.split(",");
					for(String values: langarr)
					{
						values=Character.toUpperCase(values.charAt(0))+""+values.substring(1);

						Language lang=languageService.findByLanguageName(values);
						int lid=lang.getlanguageId();
						List <MovieLanguage>mcp= movieLanguageService.getAllMovieLanguage();
						int sno= mcp.size();
						MovieLanguage ml= new MovieLanguage(sno,mid,lid);
						movieLanguageService.saveMovieLanguage(ml);
					}
				}else
				{
					Language lang=languageService.findByLanguageName(language);
					int lid=lang.getlanguageId();
					List <MovieLanguage>mcp= movieLanguageService.getAllMovieLanguage();
					int sno= mcp.size();
					MovieLanguage ml= new MovieLanguage(sno,mid,lid);
					movieLanguageService.saveMovieLanguage(ml);
				}


				if(company.contains(","))
				{
					String comparr[];
					comparr=company.split(",");
					for(String values: comparr)
					{
						values=Character.toUpperCase(values.charAt(0))+""+values.substring(1);

						Company comp=companyService.findByCompanyName(values);
						int cid=comp.getCompanyId();

						List <MovieCompany>mcp= moviecompanyService.getAllMovieCompany();
						int sno= mcp.size();
						MovieCompany mc= new MovieCompany(sno,mid,cid);
						moviecompanyService.saveMovieCompany(mc);
					}
				}else
				{
					Company comp=companyService.findByCompanyName(company);
					int cid=comp.getCompanyId();
					List <MovieCompany>mcp= moviecompanyService.getAllMovieCompany();
					int sno= mcp.size();
					MovieCompany mc= new MovieCompany(sno,mid,cid);
					moviecompanyService.saveMovieCompany(mc);
				}
				if(genre.contains(","))
				{
					String genarr[];
					genarr=genre.split(",");
					for(String values: genarr)
					{
						values=Character.toUpperCase(values.charAt(0))+""+values.substring(1);

						Genre gen=genreService.findByGenreName(values);
						int gid=gen.getGenreId();

						List<MovieGenre>mcp= movieGenreService.getAllMovieGenres();
						int sno= mcp.size();
						MovieGenre mg= new MovieGenre(sno,mid,gid);
						movieGenreService.saveMovieGenre(mg);
					}
				}else
				{
					Genre gen=genreService.findByGenreName(genre);
					int gid=gen.getGenreId();
					List<MovieGenre>mcp= movieGenreService.getAllMovieGenres();
					int sno= mcp.size();
					MovieGenre mg= new MovieGenre(sno,mid,gid);
					movieGenreService.saveMovieGenre(mg);
				}


				//cast and category code goes here

				String cast[]= castnames.split(",");
				String categories[]=category.split(",");

				for(int i=0;i<cast.length;i++)
				{
					String nm=cast[i];
					Person person=personService.findBypersonName(nm);
					String cat=categories[i];
					Category cate=categoryService.findByCategoryName(cat);
					List <MovieCategoryPerson>mcp= movieCategoryPersonService.findall();
					int sno= mcp.size();
					movieCategoryPersonService.saveMovieCategoryPersonService(new MovieCategoryPerson(sno,mid,cate.getCategoryId(),person.getPersonId()));
					//end test
				}

				mav.addObject("msg","successfully added");
				mav.addObject("back","adminPage");


			} catch (Exception e) {
				e.printStackTrace();
				log.info("Exception: " + e);

			}
		}
		else
		{

			mav.addObject("msg","Movie Already Exists!!");
			mav.addObject("back","adminPage");

		}


		return mav;
	}
	@RequestMapping("/save_language")
	public ModelAndView saveLanguage(@RequestParam("language") String lang,HttpSession session)
	{
		ModelAndView model= new ModelAndView("error");
		
		if(session.getAttribute("username")==null)
		{
		
			return  new ModelAndView("logout");
		}
		
		if(languageService.findByLanguageName(lang)!=null)
		{
			model.addObject("msg","Language Already Exists!");
			model.addObject("back","adminPage");
		}
		else
		{
			int s= languageService.getAllLanguages().size()+1;
			Language langu= new Language(s,lang);
			languageService.saveLanguage(langu);
			model.addObject("msg","Language Saved Successfully!");
			model.addObject("back","adminPage");
		}
		return model;
	}


	@RequestMapping("/save_Company")
	public ModelAndView saveCompany(@RequestParam("company") String company,HttpSession session)
	{
		ModelAndView model= new ModelAndView("error");
		if(session.getAttribute("username")==null)
		{
		
			return  new ModelAndView("logout");
		}
		if(companyService.findByCompanyName(company)!=null)
		{
			model.addObject("msg","Company Already Exists!");
			model.addObject("back","adminPage");
		}
		else
		{
			int s= companyService.getAllCompanys().size()+1;
			Company comp= new Company(s,company);
			companyService.saveCompany(comp);
			model.addObject("msg","Company Saved Successfully!");
			model.addObject("back","adminPage");
		}
		return model;
	}


	@RequestMapping("/save_award")
	public ModelAndView saveAward(@RequestParam("award") String award,HttpSession session)
	{
		ModelAndView model= new ModelAndView("error");
		if(session.getAttribute("username")==null)
		{
		
			return  new ModelAndView("logout");
		}
		if(awardService.findByAwardName(award)!=null)
		{
			model.addObject("msg","Award Already Exists!");
			model.addObject("back","adminPage");
		}
		else
		{
			int s= awardService.getAllAwards().size()+1;
			Award awd= new Award(s,award);
			awardService.saveAward(awd);
			model.addObject("msg","Award Saved Successfully!");
			model.addObject("back","adminPage");
		}
		return model;
	}


	@RequestMapping("/save_Genre")
	public ModelAndView saveGenre(@RequestParam("genre") String gen,HttpSession session)
	{
		ModelAndView model= new ModelAndView("error");
		if(session.getAttribute("username")==null)
		{
		
			return  new ModelAndView("logout");
		}
		if(genreService.findByGenreName(gen)!=null)
		{
			model.addObject("msg","Genre Already Exists!");
			model.addObject("back","adminPage");
		}
		else
		{
			int s= genreService.getAllGenres().size()+1;
			Genre g= new Genre(s,gen);
			genreService.saveGenre(g);
			model.addObject("msg","Genre Saved Successfully!");
			model.addObject("back","adminPage");
		}
		return model;
	}

	@PostMapping("/save_edit")
	public ModelAndView saveEditform(@RequestParam("movie_name") String movie_name,
			@RequestParam("release_date") String release_date, @RequestParam("runtime") int runtime,
			@RequestParam("tagline") String tagline, @RequestParam("plot") String plot,
			@RequestParam("trailer") String trailer, @RequestParam("lang") String language,
			@RequestParam("company") String company, @RequestParam("castnames") String castnames,
			@RequestParam("category") String category,@RequestParam("genre") String genre,
			Model model, HttpServletRequest request, final @RequestParam("image") MultipartFile file,HttpSession session)
	{
		Movies m=null;
		System.out.print("save-edit-movie");
		ModelAndView mav= new ModelAndView("error");
		
		if(session.getAttribute("username")==null)
		{
		
			return  new ModelAndView("logout");
		}
		System.out.println("genres"+genre);
		if(movieService.findByMovieName(movie_name)!=null)
		{
			System.out.println(category);

			if(!((category.contains("Actor")||category.contains("Actress"))&&category.contains("Producer")&&category.contains("Director")))
			{
				mav.addObject("msg","Please Select Atleast One Actor/Actress,Director,Producer");
				return mav;
			}


			try {
				if((file.getSize()!=0))
				{
					System.out.print("file size:" +file.getSize());

					String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
					log.info("uploadDirectory:: " + uploadDirectory);
					String fileName = file.getOriginalFilename();
					System.out.print("filename:"+fileName);
					String filePath = Paths.get(uploadDirectory, fileName).toString();
					log.info("FileName: " + file.getOriginalFilename());
					if (fileName == null || fileName.contains("..")) {
						mav.addObject("msg", "Sorry! Filename contains invalid path sequence \" + fileName");
						return mav;
					}
					try {
						File dir = new File(uploadDirectory);
						if (!dir.exists()) {
							log.info("Folder Created");
							dir.mkdirs();
						}
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
						stream.write(file.getBytes());
						stream.close();
					} catch (Exception e) {
						log.info("in catch");
						e.printStackTrace();
					}
					byte[] imageData = file.getBytes();
					java.sql.Date date = java.sql.Date.valueOf(release_date);

					Movies mo=movieService.findByMovieName(movie_name);

					m = new Movies(mo.getMovie_id(),movie_name, tagline, plot,imageData, date, runtime, trailer);
				}

				else
				{
					java.sql.Date date = java.sql.Date.valueOf(release_date);

					Movies mo=movieService.findByMovieName(movie_name);

					m = new Movies(mo.getMovie_id(),movie_name, tagline, plot,mo.getPoster(), date, runtime, trailer);
				}

				//saving movie("validation nnot done yet")
				movieService.saveMovie(m);
				m= movieService.findByMovieName(m.getmovieName());
				int mid=m.getMovie_id();
				List <MovieLanguage>mcp1= movieLanguageService.getAllMovieLanguage();
				for(MovieLanguage values: mcp1)
				{
					if(values.getMovieId()==mid)
					{
						movieLanguageService.removeMovieLanguage(values);
					}
				}

				if(language.contains(","))
				{
					String langarr[];
					langarr=language.split(",");
					for(String values: langarr)
					{
						values=Character.toUpperCase(values.charAt(0))+""+values.substring(1);

						Language lang=languageService.findByLanguageName(values);
						int lid=lang.getlanguageId();
						List <MovieLanguage>mcp= movieLanguageService.getAllMovieLanguage();
						int sno=0;
						for(MovieLanguage co: mcp)
						{
							if(co.getSerialNo()>sno)
							{
								sno=co.getSerialNo();
							}

						}
						sno+=1;
						MovieLanguage ml= new MovieLanguage(sno,mid,lid);
						movieLanguageService.saveMovieLanguage(ml);
						System.out.print("language saved");				}
				}else
				{
					Language lang=languageService.findByLanguageName(language);
					int lid=lang.getlanguageId();
					List <MovieLanguage>mcp= movieLanguageService.getAllMovieLanguage();
					int sno=0;
					for(MovieLanguage co: mcp)
					{
						if(co.getSerialNo()>sno)
						{
							sno=co.getSerialNo();
						}

					}
					sno+=1;
					MovieLanguage ml= new MovieLanguage(sno,mid,lid);
					movieLanguageService.saveMovieLanguage(ml);
					System.out.print("language saved");	
				}
				List <MovieCompany>mcp2= moviecompanyService.getAllMovieCompany();
				for(MovieCompany values: mcp2)
				{
					if(values.getMovieId()==mid)
					{
						moviecompanyService.removeMovieCompany(values);
					}
				}

				if(company.contains(","))
				{
					String comparr[];
					comparr=company.split(",");
					for(String values: comparr)
					{
						values=Character.toUpperCase(values.charAt(0))+""+values.substring(1);

						Company comp=companyService.findByCompanyName(values);
						int cid=comp.getCompanyId();

						List<MovieCompany>mcp= moviecompanyService.getAllMovieCompany();
						int sno=0;
						for(MovieCompany co: mcp)
						{
							if(co.getSerialNo()>sno)
							{
								sno=co.getSerialNo();
							}
						}
						sno+=1;
						MovieCompany mc= new MovieCompany(sno,mid,cid);
						moviecompanyService.saveMovieCompany(mc);
						System.out.print("mcomapany saved");	
					}
				}else
				{
					Company comp=companyService.findByCompanyName(company);
					int cid=comp.getCompanyId();
					List<MovieCompany>mcp= moviecompanyService.getAllMovieCompany();
					int sno=0;
					for(MovieCompany co: mcp)
					{

						if(co.getSerialNo()>sno)
						{
							sno=co.getSerialNo();
						}

					}
					sno=sno+1;
					MovieCompany mc= new MovieCompany(sno,mid,cid);
					moviecompanyService.saveMovieCompany(mc);
					System.out.print("mcomapany saved");
				}

				List <MovieGenre>mcp3= movieGenreService.getAllMovieGenres();
				for(MovieGenre values: mcp3)
				{
					if(values.getMovieId()==mid)
					{
						movieGenreService.removeMovieGenre(values);
					}
				}

				if(genre.contains(","))
				{
					String genarr[];
					genarr=genre.split(",");
					for(String values: genarr)
					{
						values=Character.toUpperCase(values.charAt(0))+""+values.substring(1);

						Genre gen=genreService.findByGenreName(values);
						int gid=gen.getGenreId();

						List<MovieGenre>mcp= movieGenreService.getAllMovieGenres();
						int sno=0;
						for(MovieGenre genr: mcp)
						{
							if(genr.getSerialNo()>sno)
							{
								sno=genr.getSerialNo();
							}
						}
						sno=sno+1;
						MovieGenre mg= new MovieGenre(sno,mid,gid);
						movieGenreService.saveMovieGenre(mg);
						System.out.print("mgenre saved"+sno);
					}
				}else
				{
					Genre gen=genreService.findByGenreName(genre);
					int gid=gen.getGenreId();
					List<MovieGenre>mcp= movieGenreService.getAllMovieGenres();
					int sno=0;
					for(MovieGenre genr: mcp)
					{
						if(genr.getSerialNo()>sno)
						{
							sno=genr.getSerialNo();
						}
					}
					sno=sno+1;
					MovieGenre mg= new MovieGenre(sno,mid,gid);
					movieGenreService.saveMovieGenre(mg);
					System.out.print("mgenre saved"+sno);
				}


				//cast and category code goes here

				List <MovieCategoryPerson>mcp4= movieCategoryPersonService.findall();
				for(MovieCategoryPerson values: mcp4)
				{
					if(values.getMovieId()==mid)
					{
						movieCategoryPersonService.removeMovieCategoryPerson(values);
					}
				}
				String cast[]= castnames.split(",");
				String categories[]=category.split(",");
				mcp4= movieCategoryPersonService.findall();
				int sno=0;
				for(MovieCategoryPerson values: mcp4)
				{
					sno=values.getSerialNo();
				}
				for(int i=0;i<cast.length;i++)
				{
					String nm=cast[i];
					Person person=personService.findBypersonName(nm);
					String cat=categories[i];
					Category cate=categoryService.findByCategoryName(cat);
					sno=sno+1;
					movieCategoryPersonService.saveMovieCategoryPersonService(new MovieCategoryPerson(sno,mid,cate.getCategoryId(),person.getPersonId()));
					System.out.print("mcs saved"+sno);
					//end test
					mav.addObject("msg","Movie Edited Sucessfully");
					mav.addObject("back","adminPage");
				} 

			}catch (Exception e) {
				e.printStackTrace();
				log.info("Exception: " + e);

			}
		}
		else
		{

			mav.addObject("msg","Invalid Movie Name");

		}


		return mav;
	}

	@RequestMapping("/edit_form")
	public ModelAndView showeditform(HttpSession session)
	{
		ModelAndView mav =new ModelAndView("Edit_form");
		
		if(session.getAttribute("username")==null)
		{
		
			return  new ModelAndView("logout");
		}
		List <Movies> movie=movieService.getAllMovies();
		List<String> movies= new ArrayList<String>();
		for(Movies l :movie )
		{
			movies.add(l.getmovieName().toLowerCase());
		}
		Collections.sort(movies);

		mav.addObject("allMovies",movies);

		List<Language> lang= languageService.getAllLanguages();
		List<String> langs= new ArrayList<String>();
		for(Language l :lang )
		{
			langs.add(l.getlanguageName());
		}
		Collections.sort(langs);
		mav.addObject("langs",langs);


		List<Company> comp= companyService.getAllCompanys();
		List<String>comps= new ArrayList<String>();
		for(Company c :comp )
		{
			comps.add(c.getCompanyName());
		}
		Collections.sort(comps);
		mav.addObject("comp",comps);



		List<Genre> gen= genreService.getAllGenres();

		List<String>gens= new ArrayList<String>();
		for(Genre c :gen )
		{
			gens.add(c.getGenreName());
		}
		Collections.sort(gens);
		mav.addObject("gen",gens);


		List<Person> per= personService.getAllpersons();

		List<String>pers= new ArrayList<String>();
		for(Person c :per )
		{
			pers.add(c.getPersonName());
		}
		Collections.sort(pers);
		mav.addObject("castnames",pers);
		List<Category> cat= categoryService.getAllCategorys();
		pers= new ArrayList<String>();
		for(Category c :cat )
		{
			pers.add(c.getCategoryName());
		}
		Collections.sort(pers);
		mav.addObject("category",pers);

		return mav;
	}

}
