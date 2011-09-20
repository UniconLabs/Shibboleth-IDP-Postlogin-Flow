package edu.internet2.middleware.shibboleth.idp.postlogin;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Stores user's terms of use agreement acceptance data in RDBMS
 */
public class JdbcTermsOfUseAgreementService extends AbstractTermsOfUseAgreementService {

    SimpleJdbcTemplate jdbcTemplate;

    public JdbcTermsOfUseAgreementService(TermsOfUseAcceptanceExpirationStrategy expirationStrategy, DataSource dataSource) {
        super(expirationStrategy);
        this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    protected AuthenticatedPrincipal findUser(String principalName) throws NoSuchPrincipalException {
        return this.jdbcTemplate.queryForObject("select * from users_tou where user_name = ?",
                new RowMapper<AuthenticatedPrincipal>() {
                    @Override
                    public AuthenticatedPrincipal mapRow(ResultSet rs, int i) throws SQLException {
                        TermsOfUseAgreement tou =
                                new TermsOfUseAgreement(rs.getString("acceptance_action"), rs.getLong("acceptance_timestamp"));
                        return new AuthenticatedPrincipal(rs.getString("user_name"), tou);
                    }
                },
                principalName);
    }

    @Override
    protected void saveUser(AuthenticatedPrincipal user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
