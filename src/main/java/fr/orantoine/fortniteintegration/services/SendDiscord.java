package fr.orantoine.fortniteintegration.services;

import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

public class SendDiscord {

    public SendDiscord(){

    }

    public void sendMessage(String message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content",message);
        Unirest.post("https://discordapp.com/api/webhooks/577827099159560204/e1gWoggIQtZKSyBy5zQ1Vxcw85uqg3btrPU18-oLRwV6eu4kOddT8jmM7b7Lg9YEvqyu").body(jsonObject);
    }
}
