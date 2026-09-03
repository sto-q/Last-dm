package com.cry.pokrmon.item;

import com.cry.pokrmon.DisplayItem;

/*
传送门
 */

public class portal extends Item {
/*
是否通往下一关的传送门
 */

    public portal(boolean next) {
        super("传送门");
        this.next = next;
    }

    public boolean isNext() {
        return  next;
    }

    private boolean next;
    @Override
    public String getItemInformation() {
        if(discory)
            return next ? "⇍" : "⇏";
        return "■";
    }
}
