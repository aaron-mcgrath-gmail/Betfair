package amc.betfair.api;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.betfair.aping.api.ApiNgJsonRpcOperations;
import com.betfair.aping.api.ApiNgOperations;
import com.betfair.aping.entities.EventTypeResult;
import com.betfair.aping.entities.MarketCatalogue;
import com.betfair.aping.entities.MarketFilter;
import com.betfair.aping.entities.TimeRange;
import com.betfair.aping.enums.MarketProjection;
import com.betfair.aping.enums.MarketSort;
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

  public MarketCatalogue getNextMarket(String eventTypeID) throws ApiException {
    TimeRange time = new TimeRange();
    time.setFrom(new Date());

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

    String maxResults = "1";

    try {
      List<MarketCatalogue> marketCatalogueResult = jsonOperations
          .listMarketCatalogue(marketFilter, marketProjection, MarketSort.FIRST_TO_START, maxResults, applicationKey, sessionToken);
      
      if(marketCatalogueResult != null) {
        if(marketCatalogueResult.size() == 1)
          return marketCatalogueResult.get(0);
        else
          return null;
      } else
        return null;
      
    } catch (APINGException e) {
      throw new ApiException(e);
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
