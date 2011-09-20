package edu.internet2.middleware.shibboleth.idp.postlogin;

import org.joda.time.*;
import org.joda.time.base.BaseSingleFieldPeriod;

import java.util.Date;

/**
 * Period based implementation i.e. expires in a period that has been configured
 * e.g. 'in 1 year', 'in 25 days', 'in 5 minutes', etc.
 * <p>This implementation uses joda-time library</p>
 * <p/>
 * <p><strong>Concurrency semantics: </strong>this implementation is thread-safe</p>
 *
 * @author Dmitriy Kopylenko
 */
public class PeriodBasedTermsOfUseAcceptanceExpirationStrategy implements TermsOfUseAcceptanceExpirationStrategy {

    public static enum PeriodType {
        SECONDS,
        MINUTES,
        HOURS,
        DAYS,
        WEEKS,
        MONTHS,
        YEARS
    }

    private PeriodType periodType;

    private int expirationTreshold;

    public PeriodBasedTermsOfUseAcceptanceExpirationStrategy(PeriodType periodType, int expirationTreshold) {
        this.periodType = periodType;
        this.expirationTreshold = expirationTreshold;
    }

    @Override
    public boolean isExpired(Date termsOfUseAcceptanceDate) throws IllegalArgumentException {
        BaseSingleFieldPeriod period = null;
        switch (this.periodType) {
            case SECONDS:
                period = Seconds.secondsBetween(new DateTime(termsOfUseAcceptanceDate), DateTime.now());
                break;
            case MINUTES:
                period = Minutes.minutesBetween(new DateTime(termsOfUseAcceptanceDate), DateTime.now());
                break;
            case HOURS:
                period = Hours.hoursBetween(new DateTime(termsOfUseAcceptanceDate), DateTime.now());
                break;
            case DAYS:
                period = Days.daysBetween(new DateTime(termsOfUseAcceptanceDate), DateTime.now());
                break;
            case WEEKS:
                period = Weeks.weeksBetween(new DateTime(termsOfUseAcceptanceDate), DateTime.now());
                break;
            case MONTHS:
                period = Months.monthsBetween(new DateTime(termsOfUseAcceptanceDate), DateTime.now());
                break;
            case YEARS:
                period = Years.yearsBetween(new DateTime(termsOfUseAcceptanceDate), DateTime.now());
                break;
        }
        return period.getValue(0) >= this.expirationTreshold;
    }
}
