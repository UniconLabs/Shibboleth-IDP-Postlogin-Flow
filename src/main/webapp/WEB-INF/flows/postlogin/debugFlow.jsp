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

        <p>Shows some data passed from IDP and includes 2 buttons to signal <strong>'unauthorized'</strong> and <strong>'continue'</strong>
            states</p>
    </div>


    <table id="idpData">
        <tbody>
        <tr>
            <td>
                <h3>Return URL:</h3>
            </td>
            <td>
                <strong>${idp.returnUrl}</strong>
            </td>
        </tr>
        <tr>
            <td>
                <h3>Relying Party ID:</h3>
            </td>
            <td>
                <strong>${relyingParty.id}</strong>
            </td>
        </tr>
        <tr>
            <td>
                <h3>Attributes:</h3>
            </td>
            <td>
                <strong>${user.attributes}</strong>
            </td>
        </tr>
        <tr>
            <td>
                <h3>Calling Session ID:</h3>
            </td>
            <td>
                <strong>${idp.callingSessionId}</strong>
            </td>
        </tr>
        </tbody>
    </table>

    <form method="post">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

        <div class="actions">
            <input class="btn primary" type="submit" id="continue" name="_eventId_continue" value="Authorized"/>
            <input class="btn" type="submit" id="unauthorized" name="_eventId_unauthorized" value="Unauthorized"/>
        </div>
    </form>

    <div class="page-header">
        <h2>
            Additional Post Login Steps
        </h2>
    </div>

    <form method="post">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

        <div class="actions">
            <input class="btn" type="submit" id="termsOfUse" name="_eventId_termsOfUse" value="Terms of Use"/>
            <input class="btn" type="submit" id="attributesRelease" name="_eventId_attributesRelease" value="Attributes Release"/>
        </div>
    </form>


    <!-- Footer -->
    <footer>
        <p>&copy; Unicon 2011</p>
    </footer>

</div>
<!-- /container -->

</body>
</html>