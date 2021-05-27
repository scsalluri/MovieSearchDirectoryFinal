<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>   

<!DOCTYPE html>
<html>
<style>
body {
  background-image: url('/resources/images/backdrop.png');
  
  background-attachment: fixed;
  background-size: 100% 100%;
    font-family: "Poppins", sans-serif;
}
    header {
    height: 50px;
    background-color: #ffffff;
}
#header-container {
    width: 100%;
    margin: auto;
}
.col-2 {
    width: 32%;
    float: left;
}
    .menu {
    margin-top: 32px;  
}
    .menu li {
    list-style-type: none;
    display: inline;
    font-size: .85em;
    color: #000000;
    padding-right: 30px;
}
    .logout-btn{
         display: inline-block;
    float: right;
        padding-right: 50px;
        margin-top: 32px;
    }



#adminchoice{
    font-family: "Poppins", sans-serif;
    position:relative;
    z-index: 1;
    background: #000000;
    max-width: 960px;
    
    top:50px;
    margin: 0 auto ;
    padding: 25px;
    text-align: center;
    opacity: 80%;
    padding-top: 40px;
    left:10px;
    
}
      a:link {
            color: red;
            background-color: transparent;
            text-decoration: none;
        }
        a:visited {
             color: red;
             background-color: transparent;
             text-decoration: none;
        }
        a:hover {
          color: red;
          background-color: transparent;
          text-decoration: underline;
        }
        a:active {
          color: red;
          background-color: transparent;
          text-decoration: underline;
        }
    h2{
            text-align: left;
            
            border-left: 5px solid red;
            padding-left: 10px;
    }
    #cars{
        width: 150px;
        height: 40px;
    }
    
        
    }
    form{
        font-size: large;
        font-weight: bold;
    }
    .sb-example-1 .search {
            width: 120%;
            position: relative;
            display: flex;
            left: 80%;
            bottom: 130px;
            }
            .sb-example-1 .searchTerm {
            width: 100%;
            border: 3px solid gray;
            border-right: none;
            padding: 5px;
            border-radius: 5px 0 0 5px;
            outline: none;
            color: #9DBFAF;
            }
            .sb-example-1 .searchTerm:focus{
            color: gray;
            }
            .sb-example-1 .searchButton {
            width: 40px;
            height: 50px;
            border: 1px solid gray;
            background: gray;
            text-align: center;
            color: #fff;
            border-radius: 0 5px 5px 0;
            cursor: pointer;
            font-size: 20px;
            }
            .sb-example-1 .searchButton i{
            color: white;
            }

</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <header>

        <div id="header-container">
            <div class="col-2">
                <nav>
                    <ul class="menu">
                        <li>Hi, Username</li>
                        <li><a href="#">Reports</a></li>
                        <li><a href="#">Personalized Page</a> </li>
                    </ul>  
                </nav>
            </div>
  
        <div class="col-3">
        <a href="#" class="logout-btn"><strong></strong>Logout</a>
    </div>
            
    </div>
    </header>

  

	
	<!-- <div id="arrow">
		<MARQUEE direction="down" ><img src="/resources/images/arrow.png" height="80px"></H1></MARQUEE>
	</div> -->
		

    <div id="adminchoice">
    
		
		<TABLE WIDTH=100% direction="left" style="color:red">
			<TR>
			<TD><MARQUEE><H1 style="color:#FFA500">Welcome to<img src="/resources/images/icon.png" height="80px"></H1></MARQUEE></TD>
			
			</TR>
		</TABLE>
		
    <h2 style="color: white">Search by Movie Name</h2>


    <table style="color:white">
        <tr>
            <td>

              <form action="/action_page.php">
              <h2>Specialised Search</h2>
              
              <br>
              </form>
      
            </td>
  
            <td>
                
              <form action="/action_page.php">&nbsp;&nbsp;&nbsp;
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                <div class="sb-example-1">
                    <div class="search">
                       <input type="text" class="searchTerm" placeholder="What are you looking for?">
                       <button type="submit" class="searchButton">
                         <i class="fa fa-search"></i>
                      </button>
                    </div>
                 </div>
              <br>
      
              </form>
  
  
              </td>
          </tr>
          <div>
		    <h3 style="color:red;">OR</h3>
		  </div>
          </table>
    

          


    <table style="color: red">
      <tr>
          <td>
            <form action="/action_page.php">
            <label for="cars">Genre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select name="cars" id="cars">
                <option value="Select..">Select...</option>
                <option value="Action">Action</option>
                <option value="Comedy">Comedy</option>
                <option value="Adventure">Adventure</option>
                <option value="Science Fiction">Science Fiction</option>
                <option value="Horror">Horror</option>
                <option value="Mystery">Mystery</option>
                <option value="Drama">Drama</option>
            </select>
            <br>
          
            </form>
    
          
          </td>

          <td>
            <form action="/action_page.php">&nbsp;&nbsp;&nbsp;
            <label for="cars">Director:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select name="cars" id="cars">
                <option value="Select....">Select...</option>
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
            </select>
            <br>
          
    
            </form>


            </td>
        </tr>
    
        <tr>
          <td>
            <form action="/action_page.php">
            <label for="cars">Actor:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select name="cars" id="cars">
                <option value="Select....">Select...</option>
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
            </select>
            <br>
         
            </form>
    
          
          </td>

          <td>
            <form action="/action_page.php">&nbsp;&nbsp;&nbsp;


            <label for="cars">Actress:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select name="cars" id="cars">
                <option value="Select....">Select...</option>
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
            </select>
            <br>
       
            </form>


            </td>
            <td class="btns">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" style="height:40px; width:150px; margin-top: 20px;" value="Specialised Search"></td>
            <td class="btns">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"  style="height:40px;width:150px; margin-top: 20px;" value="Watch Trailer"></td>
        </tr>
        <tr>
          <td>
            <form action="/action_page.php">
            <label for="cars">User rating:</label>
            <select name="cars" id="cars">
                <option value="Select....">Select...</option>
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
            </select>
        
            </form>
    
          
          </td>

          <td>
            <form action="/action_page.php">&nbsp;&nbsp;&nbsp;
            <label for="cars">Language:&nbsp;&nbsp;&nbsp;</label>
            <select name="cars" id="cars">
                <option value="Select....">Select...</option>
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
            </select>
           
            </form>


            </td>
            <td class="btns">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" style="height:40px; width:150px;" value="Rate this Movie"></td>
            <td class="btns">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"  style="height:40px;width:150px;" value="View Comments"></td>
        </tr>
        
         


    </table>
    
    
    </div>

</body>
</html>