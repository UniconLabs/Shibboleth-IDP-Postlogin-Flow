
<body>
	<p><b>Debug</b></p>
    <p><b>Return URL: ${idpData.returnUrl}</b></p>
    <p><b>Relying Party ID: ${idpData.relyingPartyId}</b></p>
    <p><b>IDP Attributes: ${idpData.attributes.eduPersonEntitlement}</b></p>
    <p><b>Calling Session ID: ${idpData.callingSessionId}</b></p>

    <form method="post">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
        <input type="submit" id="continue" name="_eventId_continue" value="Authorized" />
        <input type="submit" id="unauthorized" name="_eventId_unauthorized" value="Unauthorized" />
	</form>
</body>

</html>