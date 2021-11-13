# Stock Trade API

## JSON Object
   
  <ol>
  <li>id: The unique id of the trade</li>
  <li>type: trade type either buy or sell</li>
  <li>user: the user responsible for the trade 
  	<ol>
  		<li>id: the user's unique id</li>
  		<li>name: the user's unique name</li>
  	</ol>
  </li>

  <li>symbol: the stock symbol</li>
  <li>shares : total number of shares traded <br>  
     the trade share value is 10 to 30 in between     
  </li>
  <li>price: the price of one share of stock at the time of the trade (up to two places of decimal)<br>  		
  		   the stock price is between 130.42 and 195.65  		
  </li>
  <li>
  	timestamp: the timestamp of the trade creation given in the format yyyy-MM-dd HH:mm:ss <br>
  	the timezone is EST(UTC -4)
  </li>
</ol>

