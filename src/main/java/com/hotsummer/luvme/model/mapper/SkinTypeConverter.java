package com.hotsummer.luvme.model.mapper;

import java.util.HashMap;
import java.util.Map;

public class SkinTypeConverter {
    private static final Map<String, String> RESULT_TO_SKIN_TYPE_MAP = new HashMap<>();

    static {
        RESULT_TO_SKIN_TYPE_MAP.put("khô", "DrySkin");
        RESULT_TO_SKIN_TYPE_MAP.put("hỗn hợp", "CombinationSkin");
        RESULT_TO_SKIN_TYPE_MAP.put("bình thường", "NormalSkin");
        RESULT_TO_SKIN_TYPE_MAP.put("dầu", "OilSkin");
        RESULT_TO_SKIN_TYPE_MAP.put("nhạy Cảm", "SensitiveSkin");
    }

    public static String fromResultToSkinType(String result) {
        for (Map.Entry<String, String> entry : RESULT_TO_SKIN_TYPE_MAP.entrySet()) {
            if (result.toLowerCase().contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return "All";
    }
}
