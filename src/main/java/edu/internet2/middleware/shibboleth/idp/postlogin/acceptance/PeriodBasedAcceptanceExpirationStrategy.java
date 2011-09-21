package edu.internet2.middleware.shibboleth.idp.postlogin.acceptance;

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
public class PeriodBasedAcceptanceExpirationStrategy implements AcceptanceExpirationStrategy {

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

    public PeriodBasedAcceptanceExpirationStrategy(PeriodType periodType, int expirationTreshold) {
        this.periodType = periodType;
        this.expirationTreshold = expirationTreshold;
    }

    @Override
    public boolean isExpired(Date acceptanceDate) throws IllegalArgumentException {
        if(acceptanceDate == null) {
            throw new IllegalArgumentException("The acceptanceDate cannot be null");
        }
        BaseSingleFieldPeriod period = null;
        switch (this.periodType) {
            case SECONDS:
                period = Seconds.secondsBetween(new DateTime(acceptanceDate), DateTime.now());
                break;
            case MINUTES:
                period = Minutes.minutesBetween(new DateTime(acceptanceDate), DateTime.now());
                break;
            case HOURS:
                period = Hours.hoursBetween(new DateTime(acceptanceDate), DateTime.now());
                break;
            case DAYS:
                period = Days.daysBetween(new DateTime(acceptanceDate), DateTime.now());
                break;
            case WEEKS:
                period = Weeks.weeksBetween(new DateTime(acceptanceDate), DateTime.now());
                break;
            case MONTHS:
                period = Months.monthsBetween(new DateTime(acceptanceDate), DateTime.now());
                break;
            case YEARS:
                period = Years.yearsBetween(new DateTime(acceptanceDate), DateTime.now());
                break;
        }
        return period.getValue(0) >= this.expirationTreshold;
    }
}
