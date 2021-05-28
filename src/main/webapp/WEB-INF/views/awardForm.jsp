<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 

<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    
    <script>
        function addRow()
            {
                // get input values
                var MovieName = document.getElementById('Movie Name').value;
                var AwardName = document.getElementById('Award Name').value;
                var AwardYear = document.getElementById('Award Year').value;
                 var Category = document.getElementById('Category').value;
                
                // get the html table
                  // 0 = the first table
                  var table = document.getElementsByTagName('table')[1];
                  
                  // add new empty row to the table
                  // 0 = in the top 
                  // table.rows.length = the end
                  var newRow = table.insertRow(table.rows.length);
                  
                  // add cells to the row
                  var cel1 = newRow.insertCell(0);
                  var cel2 = newRow.insertCell(1);
                var cel3 = newRow.insertCell(2);
                  var cel4 = newRow.insertCell(3);
                  
                  
                  // add values to the cells
                cel1.innerHTML = MovieName;
                 cel2.innerHTML = AwardName ;
                cel3.innerHTML = AwardYear;
                cel4.innerHTML = Category;
            }
        
    </script>
    
    <style>
        body {
            
           background-image: url('/resources/images/backdrop.png');
            

  background-attachment: fixed;
  background-size: 100% 100%;
    font-family: "Poppins", sans-serif;
}
        
        label{
                display: inline-block;
                width: 120px;
                text-align: left;
            color: #bd0000;
      } 
        .main-input{
            background-color: #000000;
            padding: 100px;
            opacity: 90%;
        }
        .table-2{
            background: #000;
            width: 70%;
            text-align: center;
        }
    </style>
    
</head>
<body>
    <h1 style="text-align: center; color: #ffffff" >Award Details</h1>
    <table align="center" class="main-input" >
        <tr>
          <td>
            
            <label for="movie-name">Movie Name</label>
            <input name="Movie Name" id="Movie Name" type="text"/>
            <br>
            </td>
        </tr>
        
        <tr>
          <td style="padding:inherit">
            <label for="award-name">Award Name</label>
            <input name="Award Name" id="Award Name" type="text"/>
            <br>
              
              <td class="btns">&nbsp;&nbsp;&nbsp;&nbsp;
                  
                <input type="submit" style="height:40px; width:100px; " value="Add"  onclick="addRow();"></td>
            
            <td class="btns">&nbsp;&nbsp;&nbsp;&nbsp;
                  
                <input type="submit" style="height:40px; width:100px; " value="Save"></td>
            </tr>
        <tr>
          <td style="padding:inherit">
            <label for="award-year">Award Year</label>
            <input name="Award Year" id="Award Year" type="text"/>
            <br>
              
              <td class="btns">&nbsp;&nbsp;&nbsp;&nbsp;
                  
                <input type="submit" style="height:40px; width:100px; " value="Edit"></td>
            
            <td class="btns">&nbsp;&nbsp;&nbsp;&nbsp;
                  
                <input type="submit" style="height:40px; width:100px; " value="Cancel"></td>
            </tr>
         <tr>
          <td>
            
            <label for="category">Category</label>
            <input name="Category" id="Category" type="text"/>
            <br>
            </td>
        </tr>

    </table>
    
     <table align="center" style="margin-top: 50px; color: #ffffff" class="table-2">
            
            <tr style="color: #bd0000;">
                <th>Movie Name</th>
                <th>Award Name</th>
                <th>Award Year</th>
                <th>Category</th>
            </tr>

            
        </table>

</body>
</html>