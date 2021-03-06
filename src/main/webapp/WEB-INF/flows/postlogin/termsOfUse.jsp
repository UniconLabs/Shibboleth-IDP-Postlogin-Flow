<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Terms of use</title>
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

    <div class="page-header">
        <h2>
            Terms of use
        </h2>
    </div>
    <div class="alert-message block-message info">
        <p>
            Please review the Terms of Use Agreement and either accept or reject it.
        </p>

        <div class="alert-actions">
            <form method="post">
                <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
                <input class="btn primary" type="submit" id="acceptTermsOfUse" name="_eventId_acceptTermsOfUse"
                       value="Agree"/>
                <input class="btn" type="submit" id="rejectTermsOfUse" name="_eventId_rejectTermsOfUse"
                       value="Disagree"/>
            </form>
        </div>
    </div>

</div>
<!-- /container -->

</body>
</html>