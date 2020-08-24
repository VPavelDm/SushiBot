package com.vpaveldm.bot.constants;

public enum  MessageIDs {
    ALL_INGREDIENTS, RESET_INGREDIENTS, FIND, SORT_ORDER_SETTINGS;

    public String getID() {
        return String.valueOf(-1 * this.ordinal());
    }
}
