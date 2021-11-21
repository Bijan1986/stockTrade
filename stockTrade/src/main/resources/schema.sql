/***************************************************************************************
 *  USER this has the username and the id                                                                        *
 ***************************************************************************************/
DROP TABLE  IF EXISTS USER;

CREATE TABLE USER (
  USER_ID            INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  USER_NAME          VARCHAR(255) NOT NULL
);


/***************************************************************************************
 *  TRADE                                                                      
 *  this is the trades table which has below mentioned fields along with 
 * the user details                                        
 ***************************************************************************************/
DROP TABLE  IF EXISTS TRADE;

CREATE TABLE TRADE (
  TRADE_ID            			INTEGER IDENTITY PRIMARY KEY,
  TRADE_TYPE          			VARCHAR(10),
  USER_ID						        VARCHAR(4)   NOT NULL REFERENCES USER (USER_ID),
  TRADE_SYMBOL              VARCHAR(255) NOT NULL,
  TRADE_SHARES              INTEGER(100),
  TRADE_PRICE               REAL,
 TRADE_TIMESTAMP            TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

