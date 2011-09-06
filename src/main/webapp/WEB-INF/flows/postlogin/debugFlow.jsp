
<body>
	<p><b>Debug</b></p>
    <p><b>Return URL: ${returnUrl}</b></p>
    <p><b>Authenticated principal name: ${idpPrincipal}</b></p>
    <p><b>Authentication method: ${idpAuthenticationMethod}</b></p>
    <p><b>Relying Party ID: ${idpRelyingPartyId}</b></p>
    <p><b>IDP Attributes: ${idpAttributes.eduPersonEntitlement}</b></p>

    <form method="post">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
        <input type="submit" id="continue" name="_eventId_continue" value="Authorized" />
        <input type="submit" id="unauthorized" name="_eventId_unauthorized" value="Unauthorized" />
	</form>
</body>

</html>