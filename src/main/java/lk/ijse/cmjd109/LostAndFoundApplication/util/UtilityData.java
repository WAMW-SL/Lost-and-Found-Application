package lk.ijse.cmjd109.LostAndFoundApplication.util;

import java.util.UUID;

public class UtilityData {
    public static String generateReportId(){
        return "Rep-"+UUID.randomUUID();
    }
    public static String generateUserId(){
        return "U-"+UUID.randomUUID();
    }
    public static String generateRequestId(){
        return "Req-"+UUID.randomUUID();
    }
}
