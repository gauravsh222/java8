package com.designpatterns.strategy;

//This is strategy which will have different strategies implementation
interface Trading {
    String buy(Double price);
    String sell(Double price);
}

class CommodityTrading implements Trading {

    @Override
    public String buy(Double price) {
        return null;
    }

    @Override
    public String sell(Double price) {
        return null;
    }
}

class CashTrading implements Trading {

    @Override
    public String buy(Double price) {
        return null;
    }

    @Override
    public String sell(Double price) {
        return null;
    }
}

class OptionsTrading implements Trading {

    @Override
    public String buy(Double price) {
        return null;
    }

    @Override
    public String sell(Double price) {
        return null;
    }
}

class FuturesTrading implements Trading {

    @Override
    public String buy(Double price) {
        return null;
    }

    @Override
    public String sell(Double price) {
        return null;
    }
}


//This class is the client which is using strategy
class Trader {
    private Trading trading;
    public void trade(Trading trading){
        // Buy stock
        // Sell stock
        trading.buy(10.00d);
        trading.sell(20.00d);
    }
}


public class StrategyDesignPattern {

    public static void main(String[] args) {
        Trader trader = new Trader();

        // Below we are passing different strategies
        trader.trade(new OptionsTrading());
        trader.trade(new FuturesTrading());
        trader.trade(new CashTrading());
        trader.trade(new CommodityTrading());
    }
}
