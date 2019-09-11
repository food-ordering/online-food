<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html>
<head>
    <title>Reset Password</title>
      <style type="text/css">
        body
        {
            margin: 70pt !important;
          
        }
        
        
      .page{ 
 		     background-color:lightblue;
		     align:center; 
 		     margin:10px; 
 		     padding:10px; 
		     border-radius: 50px 15px;


           } 
           
      .page:hover{ 
 		     background-color:lightgreen; 
 		     align:center; 
		     margin:10px; 
		     padding:10px; 
		     border-radius: 50px 15px;
        } 
       .btn btn-primary{
             align:center;
       }
        
    </style>
    
    <script type="text/javascript">
    window.onload = function () {
        var txtPassword = document.getElementById("txtPassword");
        var txtConfirmPassword = document.getElementById("txtConfirmPassword");
        txtPassword.onchange = ConfirmPassword;
        txtConfirmPassword.onkeyup = ConfirmPassword;
        function ConfirmPassword() {
            txtConfirmPassword.setCustomValidity("");
            if (txtPassword.value != txtConfirmPassword.value) {
                txtConfirmPassword.setCustomValidity("Passwords do not match.");
            }
        }
    }

    
    function Captcha(){
        var alpha = new Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        var i;
        for (i=0;i<6;i++){
          var a = alpha[Math.floor(Math.random() * alpha.length)];
          var b = alpha[Math.floor(Math.random() * alpha.length)];
          var c = alpha[Math.floor(Math.random() * alpha.length)];
          var d = alpha[Math.floor(Math.random() * alpha.length)];
          var e = alpha[Math.floor(Math.random() * alpha.length)];
          var f = alpha[Math.floor(Math.random() * alpha.length)];
          var g = alpha[Math.floor(Math.random() * alpha.length)];
         }
       var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;
       document.getElementById("mainCaptcha").value = code
     }
     function ValidCaptcha(){
         var string1 = removeSpaces(document.getElementById('mainCaptcha').value);
         var string2 = removeSpaces(document.getElementById('txtInput').value);
         if (string1 == string2){
           return true;
         }
         else{        
           return false;
         }
     }
     function removeSpaces(string){
       return string.split(' ').join('');
     }
</script>    
    
</head>
<body onload="Captcha();">
<script type="text/javascript" src='https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.min.js'></script>
<script type="text/javascript" src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js'></script>
<link rel="stylesheet" href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/css/bootstrap.min.css'media="screen"/>
 
 <form method="post" action="reset" id="form1">
 <div class="page" style="max-width: 400px;"> 
   <div style="max-width: 370px;">
       <h2 class="form-signin-heading" align="center"> Reset Password</h2>
        <label for="txtPassword">Password<span style="color:#F00;font-size:20px">*</span></label>
              <input name="txtPassword" type="password" id="txtPassword" title="Password must contain: Minimum 8 characters atleast 1 Alphabet and 1 Number"
                      class="form-control" placeholder="Enter Password" required pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" />
    <br/>
        <label for="txtConfirmPassword">Confirm Password<span style="color:#F00;font-size:20px">*</span></label>
              <input name="txtConfirmPassword" type="password" id="txtConfirmPassword" class="form-control"
                 placeholder="Confirm Password" />
    <br/>
    
        <label>Captcha <span style="color:#F00;font-size:20px">*</span></label>
        <input type="text" id="mainCaptcha"/>
        <input type="button" id="refresh" value="Refresh" onclick="Captcha();"/><i class="fa fa-refresh" aria-hidden="true"></i>
       <input style="margin-top:10px;" type="text" class="form-control" placeholder="Enter captcha" name="captcha" id="txtInput" required><br/>
       <input id="Button1" type="button" value="Check" onclick="alert(ValidCaptcha());"/>
      <input type="submit" name="btnSubmit" value="Submit" id="btnSubmit" class="btn btn-primary" style="align: center;"/>
  </div>
</div>
</form>
</body>
</html>