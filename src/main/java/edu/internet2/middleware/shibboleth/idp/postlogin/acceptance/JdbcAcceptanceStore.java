package edu.internet2.middleware.shibboleth.idp.postlogin.acceptance;

import edu.internet2.middleware.shibboleth.idp.postlogin.NoSuchPrincipalException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Stores/retrieves user's acceptance data in/from RDBMS
 * <p/>
 * <p>The data structure of acceptance is the same, but only varies on the RDBMS tables where it's stored</p>
 *
 * @author Dmitriy Kopylenko
 */
public class JdbcAcceptanceStore extends AbstractAcceptanceService {

    SimpleJdbcTemplate jdbcTemplate;

    String tableName;

    public JdbcAcceptanceStore(AcceptanceExpirationStrategy expirationStrategy, DataSource dataSource, String tableName) {
        super(expirationStrategy);
        this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
        this.tableName = tableName;
    }

    @Override
    protected AuthenticatedPrincipal findUserAcceptance(String principalName) throws NoSuchPrincipalException {
        return this.jdbcTemplate.queryForObject("select * from " + this.tableName + " where user_name = ?",
                new RowMapper<AuthenticatedPrincipal>() {
                    @Override
                    public AuthenticatedPrincipal mapRow(ResultSet rs, int i) throws SQLException {
                        Acceptance tou =
                                new Acceptance(rs.getString("acceptance_action"), rs.getLong("acceptance_timestamp"));
                        return new AuthenticatedPrincipal(rs.getString("user_name"), tou);
                    }
                },
                principalName);
    }

    @Override
    protected void saveUserAcceptance(AuthenticatedPrincipal user) {
        this.jdbcTemplate.update("update " + this.tableName + " set acceptance_action = ?, acceptance_timestamp = ? where user_name = ?",
                user.getAcceptance().getActionAsString(), user.getAcceptance().getAcceptanceTimestamp(), user.getName());
    }
}
