package com.yoshitaka_yuriko.zexygacha;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZexyList {
    private String[] mZexies;

    private final Random RANDOM = new Random();
    ZexyList (String[] zexies) {
        mZexies = zexies;
    }

    public List<String> gacha(int amount) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= amount; i++) {
            int index = RANDOM.nextInt(mZexies.length);
            result.add(mZexies[index]);
        }
        return result;
    }
}
