package com.hackerrank.stocktrade.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @author Bijan Nayak TradesController this class takes care of most CRUs
 *         related to trade
 *
 */
@RestController
@RequestMapping(value = "/")
@OpenAPIDefinition(info = @Info(
        title = "Trade api",
        version = "1.0.0",
        contact = @Contact(
        name = "Bijan Nayak",
        email = "nayak.bijan@gmail.com")
    ))
@Tag(name="Trade API", description="All operations related to trades and stock")
public class TradesController {

	@Autowired
	private TradeService tradeService;

	/**
	 * Add new trades Post call /trades if the trade with same id exists then the
	 * error code is 400 else its 201
	 */
	@PostMapping("/trades")
	public ResponseEntity<Object> addNewTradePost(@RequestBody Trade trade) {
		if (tradeService.findById(trade.getId()).isPresent()) {
			tradeService.addNewTrade(trade);
			return ResponseEntity.status(HttpStatus.CREATED).body(trade);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("unable to save the trade object");
		}

	}

	/**
	 * Return a trade filtered by the ID GET call /trades/{id} if the trade with
	 * given id does not exist then the response code should be 404 else 200
	 * 
	 */
	@Operation(summary = "Get trade by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Trade created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Trade.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Trade not found with selected id", content = @Content) })
	@GetMapping("/trades/{id}")
	public ResponseEntity<Object> getTradeById(@PathVariable(value = "id") Long id) {
		if (tradeService.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(tradeService.findById(id).get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("unable to find trade with id :" + id);
		}
	}

	/**
	 * Return all trades GET /trades JSON array should be stored in ascending order
	 * of Trade id
	 */
	@GetMapping("/trades")
	public List<Trade> getAllTrades() {
		List<Trade> trades = tradeService.getAllTradeList();
		return trades;
	}

	/**
	 * Return all trade records filtered by user id /trades/users/{userid} 404/200
	 */

	@GetMapping("/trades/users/{userid}")
	public List<Trade> getAllTradesByUserId(@PathVariable(value = "userid") Long userid) {
		List<Trade> trades = tradeService.getTradesByUserId(userid);
		return trades;
	}

	/**
	 * Return trade records filtered by stock symbol and the trade Type by the given
	 * data range GET
	 * /trades/stocks/{stocksymbol}?type={tradetype}&start={startDate}&end={endDate}
	 * 404/200
	 * 
	 * @throws ParseException
	 * 
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Trade found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Trade.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid date range supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Trade not found with selected date range", content = @Content) })
	@GetMapping("/trades/stocks/{stocksymbol}")
	public ResponseEntity<Object> getAllTradeByStockSymbolAndTradeTypeAndDateRange(@PathVariable String stocksymbol,
			@RequestParam("type") String type, @RequestParam("start") String start, @RequestParam("end") String end)
			throws ParseException {
		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
		List<Trade> trades = tradeService.getTradesByStockSymbolAndTradeTypeFilterdByDate(stocksymbol, type, startDate,
				endDate);
		if (!trades.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(trades);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trades available in selected date range");
		}
	}

	/**
	 * return the highest and the lowest price of the stock symbol in the given date
	 * range GET /stocks/{stockSymbol}/price?start={startdate}&end={endDate} 404/200
	 * 
	 * the response should have the below Symbol: The symbol of the requested
	 * product Highest: the highest price of the requested stock symbol Lowest: the
	 * lowest price of the requested stock symbol for 404: {"mesage": "there are no
	 * trades in the given data range" }
	 * 
	 */

}
