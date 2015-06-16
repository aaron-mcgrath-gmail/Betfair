package amc.betfair.api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.betfair.aping.api.ApiNgJsonRpcOperations;
import com.betfair.aping.api.ApiNgOperations;
import com.betfair.aping.entities.EventTypeResult;
import com.betfair.aping.entities.MarketBook;
import com.betfair.aping.entities.MarketCatalogue;
import com.betfair.aping.entities.MarketFilter;
import com.betfair.aping.entities.PriceProjection;
import com.betfair.aping.entities.TimeRange;
import com.betfair.aping.enums.MarketProjection;
import com.betfair.aping.enums.MarketSort;
import com.betfair.aping.enums.MatchProjection;
import com.betfair.aping.enums.OrderProjection;
import com.betfair.aping.enums.PriceData;
import com.betfair.aping.exceptions.APINGException;

public class Api {
  
  private ApiNgOperations jsonOperations = ApiNgJsonRpcOperations.getInstance();
  
  private String applicationKey;
  
  private String sessionToken;

  public Api(String applicationKey, String sessionToken) {
    this.setApplicationKey(applicationKey);
    this.setSessionToken(sessionToken);
  }
  
  /**
   * Get the full list of events from Betfair;
   * Football, horse racing etc
   * @return A list of events List<EventTypeResult>
   * @throws ApiException
   */
  public List<EventTypeResult> getAllEventTypes() throws ApiException {
    MarketFilter marketFilter;
    marketFilter = new MarketFilter();

    try {
      return jsonOperations.listEventTypes(marketFilter, this.getApplicationKey(), this.getSessionToken());
    } catch (APINGException e) {
      throw new ApiException(e);
    }
  }

  public List<MarketCatalogue> getMarketsToday(String eventTypeID) throws ApiException {
    GregorianCalendar startToday = new GregorianCalendar();
    startToday.set(Calendar.HOUR_OF_DAY, 0);
    GregorianCalendar endToday = new GregorianCalendar();
    endToday.set(Calendar.HOUR_OF_DAY, 23);
    
    return this.getMarketsWithinDateRange(eventTypeID, startToday.getTime(), endToday.getTime());
  }
  
  public List<MarketCatalogue> getMarketsWithinDateRange(String eventTypeID, Date startDate, Date endDate) throws ApiException {
    TimeRange time = new TimeRange();
    time.setFrom(startDate);
    time.setTo(endDate);

    Set<String> countries = new HashSet<String>();
    countries.add("GB");

    Set<String> typesCode = new HashSet<String>();
    typesCode.add("WIN");
    
    Set<String> eventTypeIds = new HashSet<String>();
    eventTypeIds.add(eventTypeID);

    MarketFilter marketFilter = new MarketFilter();
    marketFilter.setEventTypeIds(eventTypeIds);
    marketFilter.setMarketStartTime(time);
    marketFilter.setMarketCountries(countries);
    marketFilter.setMarketTypeCodes(typesCode);

    Set<MarketProjection> marketProjection = new HashSet<MarketProjection>();
    marketProjection.add(MarketProjection.RUNNER_DESCRIPTION);

    try {
      return jsonOperations.listMarketCatalogue(marketFilter, marketProjection, MarketSort.FIRST_TO_START, "0", this.getApplicationKey(), this.getSessionToken());
    } catch (APINGException e) {
      throw new ApiException(e);
    }
  }
  
  public List<MarketBook> getMarketData(String marketId) throws ApiException {
    PriceProjection priceProjection = new PriceProjection();
    Set<PriceData> priceData = new HashSet<PriceData>();
    priceData.add(PriceData.EX_BEST_OFFERS);

    //In this case we don't need these objects so they are declared null
    OrderProjection orderProjection = null;
    MatchProjection matchProjection = null;
    String currencyCode = null;

    List<String> marketIds = new ArrayList<String>();
    marketIds.add(marketId);

    try {
      return jsonOperations.listMarketBook(marketIds, priceProjection, orderProjection, matchProjection, currencyCode, applicationKey, sessionToken);
    } catch (APINGException ex) {
      throw new ApiException(ex);
    }
  }
  
  public String getApplicationKey() {
    return applicationKey;
  }

  public void setApplicationKey(String applicationKey) {
    this.applicationKey = applicationKey;
  }

  public String getSessionToken() {
    return sessionToken;
  }

  public void setSessionToken(String sessionToken) {
    this.sessionToken = sessionToken;
  }
  
}
