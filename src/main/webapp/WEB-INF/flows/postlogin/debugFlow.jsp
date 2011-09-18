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
    <link href="/plf/styles/bootstrap-1.3.0.css" rel="stylesheet">
	<style type="text/css">
      /* Override some defaults */ 
      body {
        padding-top: 60px; /* 40px to make the container go all the way to the bottom of the topbar */
      }
      .container > footer p {
        text-align: center; /* center align it with the container */
      }
	</style>
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