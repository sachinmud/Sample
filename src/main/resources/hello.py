from datetime import date
from nsepy import get_history

stock_fut = get_history(symbol='TATASTEEL',
                        start=date(2023,4,10),
                        end=date(2023,4,10),
                        futures=True,
                        expiry_date=date(2023,4,27))