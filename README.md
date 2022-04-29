1. The third validation which is for expiry I have created an event which makes the change in Database after every 10 seconds.
Query : create event expiryevent
        on schedule every 10 seconds
        starts CURRENT_TIMESTAMP
        do
        update trade set expiry=1 where maturity_date<CURRENT_TIMESTAMP.

2. Before running application create one databse in mysql named 'tradestore'.