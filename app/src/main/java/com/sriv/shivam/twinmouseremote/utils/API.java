package com.sriv.shivam.twinmouseremote.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

@RequiresApi(api = Build.VERSION_CODES.N)
public class API {
    public static DiscordApi api = new DiscordApiBuilder().setToken(CONSTANTS.BOT_TOKEN).login().join();
}
