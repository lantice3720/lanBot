package io.github.lantice3720;

import io.github.lantice3720.listener.ChatEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException, LoginException {
        BufferedReader tokenFileReader = new BufferedReader(new FileReader("token.txt"));
        JDABuilder botBuilder = JDABuilder.createDefault(tokenFileReader.readLine());

        botBuilder.disableCache(CacheFlag.ACTIVITY);
        botBuilder.disableIntents(GatewayIntent.GUILD_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGE_TYPING);
        botBuilder.setActivity(Activity.playing("OHHH YEAAA"));

        JDA bot = botBuilder.build();

        bot.getPresence().setStatus(OnlineStatus.ONLINE);

        System.out.println("작동중인 경로: "+System.getProperty("user.dir"));

        bot.addEventListener(new ChatEvent());


        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        while (true){
            if(inputString.equals("stop")) {
                bot.shutdown();
                System.exit(1);
                break;
            }
            inputString = scanner.nextLine();
        }
//        bot.upsertCommand("dice", "Roll a dice! Usage: /dice <eyes> [<count>]").queue();
    }
}
