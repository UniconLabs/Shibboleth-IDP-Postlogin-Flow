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
            Attributes Release Consent
        </h2>
    </div>
    <div class="alert-message block-message info">
        <p>
            Please either accept or reject to release the following attributes
        </p>

        <table id="idpData">
        <tbody>
        <tr>
            <td>
                <h3>Attributes:</h3>
            </td>
            <td>
                <strong>${user.attributes}</strong>
            </td>
        </tr>
        </tbody>
    </table>

        <div class="alert-actions">
            <form method="post">
                <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
                <input class="btn primary" type="submit" id="acceptAttributesRelease" name="_eventId_acceptAttributesRelease"
                       value="Accept"/>
                <input class="btn" type="submit" id="rejectAttributesRelease" name="_eventId_rejectAttributesRelease"
                       value="Reject"/>
            </form>
        </div>
    </div>

</div>
<!-- /container -->

</body>
</html>