<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    
  <script type='text/javascript'>
function preview_image(event) 
{
 var reader = new FileReader();
 reader.onload = function()
 {
  var output = document.getElementById('output_image');
  output.src = reader.result;
 }
 reader.readAsDataURL(event.target.files[0]);
}
</script>
    
    <script type="text/javascript">
	function addRows(){ 
	var table = document.getElementById('cast');
	var rowCount = table.rows.length;
	var cellCount = table.rows[0].cells.length; 
	var row = table.insertRow(rowCount);
	for(var i =0; i <= cellCount; i++){
		var cell = 'cell'+i;
		cell = row.insertCell(i);
		var copycel = document.getElementById('col'+i).innerHTML;
		cell.innerHTML=copycel;	
	}
}
function deleteRows(){
	var table = document.getElementById('cast');
	var rowCount = table.rows.length;
	if(rowCount > '2'){
		var row = table.deleteRow(rowCount-1);
		rowCount--;
	}
	else{
		alert('There should be atleast one row');
	}


}

</script>
  
  <style>
       body {
    font-family: "Poppins", sans-serif;
    background-image: url('/resources/images/background3.png');
           opacity: 90%;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
  }
  .main{
      color: #ffffff;
      text-align: center;
  }
  .form{
      color: #ffffff;
      
      padding: 50px 20px 0 80px;
 }
 .fields label{
     display: inline-block;
     width: 140px;
     text-align: left;
      } 
      
 .btn{
          background-color: #bd0000;
          border: 0 ; 
          color: #ffffff;
      }
  .uploadform{
   
    padding:10px;

     background-color: #000000;
     
	width: 45%;
	height: 200px;

 }
      #output_image{
         width: 180px;
height: 180px;
background-position: center center;
background-size: cover;

display: inline-block;
        margin-left:50px;
      }
      #choose-file{
         
          
      }
      .table{
          margin-top: 30px;
          padding-top: 5px;
          padding-right: 20px;
          padding-top: 30px;
          padding-bottom: 30px;
          
         
          background-color: #000000;
          
		  width: 45%;
		  text-align: center;

      }
      #cast{
          padding: 10px;
          
      }
      #cast th{
      color:#fff
      }
      .btn1{
        background-color: #bd0000;
          border: 0 ; 
          color: #ffffff;
      }
      .col-2{
         float: left;
    width: 50%;
          
      }
      .col-2 label{
          color: #fff;
      }
      .col-2 input{
          padding: 5px;
          
      }
              .btn2{
          background-color: #bd0000;
          border: 0 ; 
          color: #ffffff;
          margin-top:30px;
          font-size: 16px;
          width:100px;
          cursor:pointer;
          margin-left:17%;
        }
         .btn2:hover
        {
        background-color: #4CAF50;
  color: white;
        }
      	.main-sec{
      	margin-left: 150px;
      	}
      .table{
      text-align: center;
      padding-left: 50px;
      }
        a:link {
            color: white;
            background-color: transparent;
            text-decoration: none;
        }
        a:visited {
             color: white;
             background-color: transparent;
             text-decoration: none;
        }
        a:hover {
          color: white;
          background-color: transparent;
          text-decoration: none;
        }
        a:active {
          color:white;
          background-color: transparent;
          text-decoration: none;
        }
  </style>
</head>
    
<body>
   <form  class="fields"   action="save-movie" name="myform" enctype="multipart/form-data" method="post">
    <div class="main">
        <h1 >MOVIE FORM</h1>
            <img  src="https://findicons.com/files/icons/1261/sticker_system/256/movie.png" alt="movie icon" style="width: 100px;height: 100px;margin-left: 13cm;margin-top: -2cm;">
    </div>
       
      
       
       <div class="main-sec">
    <div class="col-2">   
       <label style="margin-left: 20px;" >Movie Name</label>
       <input type="text"   id="moviename" name="movie_name" id="movie_name" required style="  margin-top: 20px;width: 12cm" /><br>

       
       <label style="margin-left: 20px;" path="tagline">Tagline</label>
       <input type="text" id="tagline" name="tagline"  style="  margin-top: 20px;width: 12cm;" /><br>
      
       <label style="margin-left: 20px;margin-top: 20px" for="plot">Plot</label>
        <textarea style="resize: none; height: 100px;
        width: 350px;margin-top: 20px;width: 12cm;vertical-align: middle;padding: 5px;" id="plot" name="plot" required ></textarea> <br>
        
        <label  style="margin-left: 20px;">Trailer Link</label>
<input  type="text" id="trailer" name="trailer" style="margin-top: 20px;width: 12cm"  required /><br>
      
        <label style="margin-left: 20px;" >Release Date</label>
       <input type="date"  name="release_date" id="release_date" required placeholder="dd-mm-yyyy" min="1970-01-01" max="2040-12-31" style="margin-top: 20px; width: 125px" />
     
        <label style="margin-left: 40px;" >Runtime(in Min)</label>
       <input type="number" min=0  id="runtime" name="runtime"  required style="margin-top: 20px ; width: 125px;" /><br>

    



        <label style="margin-left: 20px;">Language</label>
        <select id="lang"  required multiple   name="lang" style="width: 140px;margin-top: 20px;vertical-align: middle">
         <c:forEach var="langs" items="${langs}">
	         	 <option value="${langs}">${langs}</option>
	          	 </c:forEach>
       </select>
     
        <label style="margin-left: 40px;">Genre</label>
       <select id="genre" name="genre" multiple required style="width: 140px;margin-top: 20px;vertical-align: middle">
         <c:forEach var="gen" items="${gen}">
	         	 <option value="${gen}">${gen}</option>
	          	 </c:forEach>
       </select> <br>
    
        <label style="margin-left: 20px;">Company</label>
      <select id="company" name="company" multiple required style="margin-top: 20px;width: 140px;vertical-align: middle">
    
        <c:forEach var="comp" items="${comp}">
	         	 <option value="${comp}">${comp}</option>
	          	 </c:forEach>
   
      </select> <br>
      
      
 	 <div align="right">
 <input class="btn2" style=";color: white;padding: 10px;" type="submit" name="submit" value="Submit">
	   <button value="Back" class="btn2" style=";color: white;padding: 10px;"><a href="adminPage">Back</a></button>
</div>
	
        </div >  
           
           <div class="col-2">
         <div>      
        <div class="uploadform" >
            
        <img align="middle" id="output_image"/>
               
        
         
       </div>
               <div id="upload">
       
            
            <div style="padding-left: 110px;">
            <input id="choose-file" type="file" accept="image/png, image/jpeg, image/jpg" onchange="preview_image(event)" name="image"><br>
                 </div>
               </div>
             </div>
             
        
        
        <div class="table" align="center">
        
 	<table style="width:500x" id="cast" >
        <caption style="color: #bd0000; margin-left: 15px; text-align: center; font-size:25px;"><strong>Cast and Crew</strong></caption>
		<tr>
			<th>Person</th>
			<th>Category</th> 
		</tr> 
		<tr> 
			<td id="col0" align="center">
			<select style="padding: 5px;width:100px" name="castnames" id="castnames" > 
			<c:forEach var="castname" items="${castnames}">
	         	 <option value="${castname}">${castname}</option>
	          	 </c:forEach>
			</select> 
			 
			<td id="col1"  align="center"> 
			<select style="padding: 5px;width:100px" name="category" id="category" > 
			<c:forEach var="category" items="${category}">
	         	 <option value="${category}">${category}</option>
	          	 </c:forEach>
			</select> 
		        </td> 
		        
		</tr>  
	 
		</table>
			<table> 
		<tr> 
			<td><input style="margin-top: 15px; margin-right: 3px; width: 1.5cm; margin-left: 90px;"  class="btn1" type="button" value=" Add " onclick="addRows()" /></td> 
			<td><input style="margin-top: 15px; margin-right: 3px; width: 1.5cm; margin-left: 15px;"   class="btn1" type="button" value=" Delete " onclick="deleteRows()" /></td> 
		</tr>  
	</table> 
		 
	 
        
    </div>      
    
    
   </div>
   
           </div>
       
        </form>
</body>
</html>