class Solution(object):
    def maxProfit(self, prices):
        if not prices or len(prices) < 2:
            # Not enough prices to make a transaction
            return 0

        # Initialize variables
        min_price = prices[0]
        max_profit = 0

        # Iterate through the prices starting from the second day
        for price in prices[1:]:
            # Update the minimum price if a lower price is encountered
            min_price = min(min_price, price)
            
            # Update the maximum profit if a higher selling price is encountered
            max_profit = max(max_profit, price - min_price)

        return max_profit    