<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>IDP Post Login</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Styles -->
    <link href="/plf/styles/bootstrap-1.1.1.css" rel="stylesheet">

    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="images/favicon.ico">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
    
    
    <!-- Scripts: inc. TableSorter -->
    <script src="http://code.jquery.com/jquery-1.5.2.min.js"></script>
    <script src="http://autobahn.tablesorter.com/jquery.tablesorter.min.js"></script>
    <script src="assets/js/google-code-prettify/prettify.js"></script>
    <script src="assets/js/application.js"></script>
  </head>

  <body>


    <!-- The top navigation menu -->
   	<div class="topbar">
	    <div class="fill">
	        <div class="container">
	            <h3><a href="#">IDP Post Login Flow</a></h3>
	        </div>
	    </div>
	</div>

    <div class="container">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
        <h1>Debug View State</h1>
        <p>Shows some data passed from IDP and includes 2 buttons to signal <strong>'unauthorized'</strong> and <strong>'continue'</strong> states</p>
      </div>
      
      		<h3>Return URL: <small>${idpData.returnUrl}</small></h3>
			<h3>Relying Party ID: <small>${idpData.relyingPartyId}</small></h3>
			<h3>Entitelments: <small>${idpData.attributes.eduPersonEntitlement}</small></h3>
			<h3>Calling Session ID: <small>${idpData.callingSessionId}</small></h3>
          						
		  	<form method="post">
		        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		        <div class="actions">
                    <input class="btn primary" type="submit" id="continue" name="_eventId_continue" value="Authorized" />
                    <input class="btn primary" type="submit" id="unauthorized" name="_eventId_unauthorized" value="Unauthorized" />
                </div>						        
			</form>
      

    <!-- Footer -->
      <footer>
        <p>&copy; Unicon 2011</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>