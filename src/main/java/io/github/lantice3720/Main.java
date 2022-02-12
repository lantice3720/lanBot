package io.github.lantice3720;

import io.github.lantice3720.Listener.ChatEvent;
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
    public static void main(String args[]) throws IOException, LoginException { // 메인 함수
        File tokenFile = new File("resources\\token.txt"); // 작동모드 확인용
        BufferedReader tokenFileReader; // 토큰 읽기용

        if(tokenFile.exists()) {
            tokenFileReader = new BufferedReader(new FileReader("resources\\token.txt")); // 일반모드
            System.out.println("봇이 현재 일반모드에서 작동중입니다.");
        }else{
            tokenFileReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\build\\artifacts\\resources\\token.txt")); // 디버그모드
            System.out.println("봇이 현재 디버그모드에서 작동중입니다.");
        }

        JDABuilder botBuilder = JDABuilder.createDefault(tokenFileReader.readLine()); // 토큰 읽어서 봇 빌드준비

        botBuilder.disableCache(CacheFlag.ACTIVITY); // 활동 변하는 캐시 비활성화
        botBuilder.disableIntents(GatewayIntent.GUILD_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGE_TYPING); // 유저가 채팅 치는 중 이벤트 무시
        botBuilder.setActivity(Activity.playing("OHHH YEAAA")); // 상태메시지 표기

        JDA bot = botBuilder.build(); // 봇 빌드

        bot.getPresence().setStatus(OnlineStatus.ONLINE); // 상태 온라인으로 표시

        bot.addEventListener(new ChatEvent()); // 채팅 이벤트 불러오기



        Scanner scanner = new Scanner(System.in); // 콘솔 메시지 감지
        String inputString = scanner.nextLine(); // 콘솔 메시지 저장
        while (true){ // 봇 꺼질때까지 반복
            if(inputString.equals("stop")) { // stop 명령어 감지
                bot.shutdown(); // 봇 셧다운
                System.exit(1); // 콘솔 off
                break; // 무한반복 나오기
            }
            inputString = scanner.nextLine(); // 명령어 봇받을 시 다음 명령어 대기
        }
//        bot.upsertCommand("dice", "Roll a dice! Usage: /dice <eyes> [<count>]").queue();
    }
}
