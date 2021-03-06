package com.xeiam.xchange.examples.mercadobitcoin.marketdata.ltc;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.currency.Currencies;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.mercadobitcoin.MercadoBitcoinExchange;
import com.xeiam.xchange.mercadobitcoin.dto.marketdata.MercadoBitcoinTicker;
import com.xeiam.xchange.mercadobitcoin.service.polling.marketdata.MercadoBitcoinMarketDataServiceRaw;
import com.xeiam.xchange.service.polling.PollingMarketDataService;

import java.io.IOException;


/**
 * Demonstrate requesting Ticker at Mercado Bitcoin. You can access both the raw data from Mercado Bitcoin or the XChange generic DTO data format.
 * @author Copied from Bitstamp and adapted by Felipe Micaroni Lalli
 */
public class TickerDemo {

  public static void main(String[] args) throws IOException {

    // Use the factory to get Mercado Bitcoin exchange API using default settings
    Exchange mercadoBitcoin = ExchangeFactory.INSTANCE.createExchange(MercadoBitcoinExchange.class.getName());

    // Interested in the public polling market data feed (no authentication)
    PollingMarketDataService marketDataService = mercadoBitcoin.getPollingMarketDataService();

    generic(marketDataService);
    raw((MercadoBitcoinMarketDataServiceRaw) marketDataService);
  }

  private static void generic(PollingMarketDataService marketDataService) throws IOException {

    Ticker ticker = marketDataService.getTicker(new CurrencyPair(Currencies.LTC, Currencies.BRL));

    System.out.println(ticker.toString());
  }

  private static void raw(MercadoBitcoinMarketDataServiceRaw marketDataService) throws IOException {

    MercadoBitcoinTicker mercadoBitcoinTicker = marketDataService.getMercadoBitcoinTicker(new CurrencyPair(Currencies.LTC, Currencies.BRL));

    System.out.println(mercadoBitcoinTicker.toString());
  }

}
