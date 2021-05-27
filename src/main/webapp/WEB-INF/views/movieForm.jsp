<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
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
function func()
{
	 var lang=document.getElementById('lang');
	var val= lang.options[lang.selectedIndex].value; 
	alert(val);
}
</script>
    
  <style>
       body {
    font-family: "Poppins", sans-serif;
    background-image: url('/resources/images/backdrop.png');
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
      margin: auto;
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
    margin-top: -10cm;
    padding-left: 70px;
    padding-right: 20px;

     background-color: #000000;
     margin-left:19cm;
	width: 400px;
	height: 200px;

 }
      #output_image{
          max-width: 120px;
          padding: 30px
      }
      #choose-file{
          margin-top: inherit;
          margin-right: 10px;
      }
      .table{
          margin-top: 30px;
          padding-top: 20px;
          padding-right: 20px;
          padding-top: 50px;
          margin-left:19cm;
          background-color: #000000;
          margin-left:19cm;
		  width: 400px;
		  text-align: center;

      }
      .btn1{
        background-color: #bd0000;
          border: 0 ; 
          color: #ffffff;
      }
  </style>
</head>
    
<body>
   <form  class="fields" onsubmit="return func()" action="save-movie" name="myform">
    <div class="main">
        <h1 >MOVIE FORM</h1>
            <img  src="https://findicons.com/files/icons/1261/sticker_system/256/movie.png" alt="movie icon" style="width: 100px;height: 100px;margin-left: 13cm;margin-top: -2cm;">
    </div>
    <div class="form">   
       <label style="margin-left: 10px;" >Movie Name</label>
       <input type="text"   id="moviename" name="movie_name" id="movie_name"  style="  margin-top: 20px;width: 12cm" /><br>

       
       <label style="margin-left: 10px;" path="tagline">Tagline</label>
       <input type="text" id="tagline" name="tagline"  style="  margin-top: 20px;width: 12cm" /><br>
      
       <label style="margin-left: 10px;" >Plot</label>
       <input type="textbox" id="plot" name="plot"  style="margin-top: 20px;width:12cm;height:2cm" /><br>
      
        <label style="margin-left: 10px;" >Release Date</label>
       <input type="date"  name="release_date" id="release_date" placeholder="dd-mm-yyyy" min="1970-01-01" max="2040-12-31" style="margin-top: 20px;" />
     
        <label style="margin-left: 20px;" >Runtime(in Min)</label>
       <input type="number" min=0  id="runtime" name="runtime" style="margin-top: 20px ; width: 108px;" /><br>

    

<label  style="margin-left: 10px;">Trailer Link</label>
<input  type="text" id="trailer" name="trailer" style="  margin-top: 20px;width: 12cm"/><br>

        <label style="margin-left: 10px;">Language</label><select id="lang" multiple   name="lang" style="width: 3cm;margin-top: 20px;">
         <option value="hindi">Hindi</option>
         <option value="english">English</option>
         <option value="spanish">Spanish</option>
         <option value="french">French</option>
         <option value="telugu">Telugu</option>
         <option value="marati">Marati</option>
         <option value="tamil">Tamil</option>
       </select>
     
        <label style="margin-left: 40px;">Genre</label>
       <select id="genre" name="genre" multiple  style="width: 3cm;margin-top: 20px;">
         <option value="action">Action</option>
         <option value="adventure">Adventure</option>
         <option value="drama">Drama</option>
         <option value="thriller">Thriller</option>
         <option value="fiction">Fiction</option>
         <option value="crime">Crime</option>
         <option value="horror">Horror</option>
         <option value="mystery">Mystery</option>
       </select> <br>
       
        <label style="margin-left: 10px;">Country Name</label>
       <select id="country" multiple  style="margin-top: 20px;width: 3cm">
         <option value="india">India</option>
         <option value="usa">U.S.A</option>
         <option value="france">France</option>
         <option value="spain">Spain</option>
         <option value="britain">Britain</option>
       </select>
        <label style="margin-left: 40px;">Company</label>
      <select id="company" name="company" multiple  style="margin-top: 20px;width: 3cm">
        <option value="Yash Raj Films">Yash Raj Films</option>
        <option value=" UTV Motion Pictures Ltd"> UTV Motion Pictures Ltd</option>
        <option value=" Dharma Productions"> Dharma Productions</option>
        <option value=" Vinod Chopra Productions Pvt Ltd"> Vinod Chopra Productions Pvt Ltd</option>
        <option value="Bhansali Productions">Bhansali Productions</option>
        <option value="Aamir Khan Productions">Aamir Khan Productions</option>
        <option value="Excel Entertainment">Excel Entertainment</option>
        <option value=" Anurag Kashyap Films Pvt Ltd"> Anurag Kashyap Films Pvt Ltd</option>
        <option value="Warner Bros. Pictures">Warner Bros. Pictures</option>
        <option value="Paramount Pictures">Paramount Pictures</option>
        <option value="Universal Pictures">Universal Pictures</option>
        <option value="Walt Disney Pictures">Walt Disney Pictures</option>
      </select> <br>
      
        </div >   
        <div class="uploadform" >
        <img id="output_image"/>
        <input id="choose-file" type="file" accept="image/png, image/jpeg" onchange="preview_image(event)" name="img" id="img"><br>
         
       </div>
      
        
        
        <div class="table">
 	<table id="cast" >
        <caption style="color: #bd0000; text-align: center"><strong>Cast and Crew</strong></caption>
		<tr>
			<th>Person</th>
			<th>Category</th> 
		</tr> 
		<tr> 
			<td id="col0"><input type="text" name="castnames" id="castnames" /></td> 
			 
			<td id="col1"> 
			<select name="category" id="category"> 
			<option value="0">Select Category</option> 
			<option value="1">Actor</option>
			<option value="2">Actress</option>
			<option value="3">Director</option>
            <option value="4">Producer</option>
			</select> 
		        </td> 
		        
		</tr>  
	</table> 
	<table> 
		<tr> 
			<td><input style="margin-top: 15px; margin-right: 3px; width: 1.5cm; margin-left: 30px;"  class="btn1" type="button" value=" Add " onclick="addRows()" /></td> 
			<td><input style="margin-top: 15px; margin-right: 3px; width: 1.5cm; margin-left: 30px;"   class="btn1" type="button" value=" Delete " onclick="deleteRows()" /></td> 
		</tr>  
	</table> 
        
    </div>
    </br>
     </br>
      </br>
       </br>
    <div align="center">
    <input type="submit" value="Add Movie"/>
    </div>
        </form>
</body>
</html>