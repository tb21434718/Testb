<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
 <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="Cache" content="no-cache"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="./css/pagination.css"/>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="./js/pagination.min.js"></script>
    <style>
        .cib {
            padding: 5px 2px;
        }

        .cib input {
            vertical-align: bottom;
            height: 20px;
            color: #567e84;
            margin: 2px 0px;
        }

        .cib button {
            vertical-align: bottom;
            height: 26px;
            cursor: pointer;
            background-color: #cbefff;
            border: 1px solid #44a8d6;
            color: #567e84;
            margin: 2px 0px;
        }

        .desc {
            padding-left: 2px;
            color: #657e9a;
        }

        .code-con{
            font-size: 18px;
        }

        .hr-c{
            background-color: #2196F3;
            height: 5px;
            border: 0px;
        }
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
 <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="Cache" content="no-cache"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="./css/pagination.css"/>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="./js/pagination.min.js"></script>

    <!-- Basic Page Needs
  ================================================== -->
	<meta charset="utf-8">
	<title>zMovie</title>
	<meta name="description" content="Free Responsive Html5 Css3 Templates | zerotheme.com">
	<meta name="author" content="www.zerotheme.com">
	
    <!-- Mobile Specific Metas
  ================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    
    <!-- CSS
  ================================================== -->
  	<link rel="stylesheet" href="css/zerogrid.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/responsive.css">
	

	<script type="text/javascript">

	function switchclass(bb) {
	$(bb).siblings().removeClass().addClass("page gradient"); 
	$(bb).removeClass().addClass("page active");
	
}
 <%String id="cla"+(String)request.getAttribute("round1");
   System.out.println(id);%>
  
	
</script>
<meta http-equiv="Expires" content="0"/>
    <meta http-equiv="Cache" content="no-cache"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="./css/pagination.css"/>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="./js/pagination.min.js"></script>
    <style>
        .cib {
            padding: 5px 2px;
        }

        .cib input {
            vertical-align: bottom;
            height: 20px;
            color: #567e84;
            margin: 2px 0px;
        }

        .cib button {
            vertical-align: bottom;
            height: 26px;
            cursor: pointer;
            background-color: #cbefff;
            border: 1px solid #44a8d6;
            color: #567e84;
            margin: 2px 0px;
        }

        .desc {
            padding-left: 2px;
            color: #657e9a;
        }

        .code-con{
            font-size: 18px;
        }

        .hr-c{
            background-color: #2196F3;
            height: 5px;
            border: 0px;
        }
    </style>
    
</head>



<body>
<div class="wrap-body">

<!--////////////////////////////////////Header-->
<header>
	<div class="top-bar">
		<div class="wrap-top zerogrid">
			<div class="row">
				<div class="col-1-2">
					<div class="wrap-col">
						<ul>
						<c:choose>
						 <c:when test="${empty login }">
						    <li class="mail"><p><a href="http://localhost:8080/File/login.jsp">login</a></p></li>
							<li class="phone"><p>please login in</p></li>
						 </c:when>
						 <c:otherwise>
						  <li class="mail"><p><a href="localhost:8080/File/login.jsp">${username }</a></p></li>
							<li class="phone"><p><a href="http://localhost:8080/File/loginout">loginout</a></p></li>
						 
						 </c:otherwise>
						
						
						</c:choose>

						</ul>
					</div>
				</div>
				<div class="col-1-2">
					<div class="wrap-col f-right">
						<ul>
							<li><select>
								<option value="en" selected>English</option>
								<option value="fe">France</option>
								<option value="ge">Germany</option>
							</select></li>
							<li><p>Language</p></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="wrap-header zerogrid">
		<div class="row">
			<div class="col-1-2">
				<div class="wrap-col">
					<div class="logo"><a href="http://localhost:8080/File/index_servlet?round=1"><img src="images/logo.png"/></a></div>	
				</div>
			</div>
			<div class="col-1-2">
				<div class="wrap-col f-right">
					<form method="get" action="http://localhost:8080/File/searchFilm" id="search"  >
					  <input name="filmname" type="text" size="40" placeholder="Search..." />
					  <input type="submit" value="Submit">
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div id="menu">
				<nav>
					<div class="wrap-nav">
					   <ul>
						 <li class="active"><a href="index.jsp">Home</a></li>
						 <li><a href="single.html">GREATEST FILMS</a></li>
						 <li><a href="single.html">THE BEST</a></li>
						 <li><a href="single.html">OSCARS</a></li>
						 <li><a href="single.html">GENRES</a></li>
						 <li><a href="single.html">QUOTES</a></li>
						 <li><a href="single.html">POSTERS</a></li>
						 <li><a href="contact.html">CONTACT</a></li>
					   </ul>
					</div>
				</nav>
			</div>
		</div>
	</div>
</header>
<!--////////////////////////////////////Container-->

	<div class="wrap-container zerogrid">
		<div id="main-content" class="col-3-3">
			<div class="wrap-content">
				<div class="movie">
					<div class="row type">
						<div class="title">
							<center><h2>MOVIE</h2></center>
						</div>
						
					</div>
					<div class="row">
					<c:forEach items="${filmlist}" var="film">
						<div class="col-1-4">
							<div class="wrap-col">
								<div class="post">
									<div class="view effect">  
									 <img class="thumb" src="film_images/${film.imagename }"  />
									  <div class="mask">  
										<a href="http://localhost:8080/File/single?id=${film.id}" class="info" title="Full Image"><img src="images/play_button_64.png" /></a>  
									  </div>  
									</div>
									<a href="http://localhost:8080/File/single?id=${film.id}"><h3>${film.filename }</h3></a>
									<span>${film.filmtype }</span>
								</div>
							</div>
						</div>
						</c:forEach>
	               </div>
         <div class="row"> <center><div id="pagination_4"></div></center></div>
         <script type="text/javascript">
 $("#pagination_4").whjPaging({
            totalPage: ${filmnum},
            showPageNum: 5,
            isShowFL: true,
            isShowPageSizeOpt: false,
            isShowSkip: true,
            isShowRefresh: true,
            isShowTotalPage: true,
            isResetPage: true,
            callBack: function (currPage, pageSize) {
                window.location.href="http://localhost:8080/File/searchFilm?filmname=${filmname}&&round="+currPage;
            }
        });
        
        $(document).ready(function(){
	     $("#pagination_4").whjPaging("setPage", "${round}",${filmnum});
   });
  
</script>
              </div>
             </div>
            </div>
          </div>
<script src="js/css3-mediaqueries.js"></script>
<script src="js/jquery.min.js"></script>
</body>


</html>
