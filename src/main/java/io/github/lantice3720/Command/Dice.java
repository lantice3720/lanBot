package io.github.lantice3720.Command;

import io.github.lantice3720.Fx;

import java.util.Random;

public class Dice {
    public static StringBuilder dice(String command[]){
        Random random = new Random(); // 주사위 굴리기 위한 객체 생성
        StringBuilder replyMessage = new StringBuilder(); // 문자열을 보낼 시 사용
        if (command.length <= 1) { // !dice 만 입력
            replyMessage.append("d6을 굴립니다.\r\n결과는 **")
                    .append(random.nextInt(6) + 1)
                    .append("**!");
        } else if (command.length == 2 && Fx.isNumeric(command[1]) && !command[1].equals("0")) { // !dice <eye> 입력
            replyMessage.append("d")
                    .append(command[1])
                    .append("을 굴립니다.\r\n결과는 **")
                    .append(random.nextInt(Integer.parseInt(command[1])) + 1)
                    .append("**!");
        } else if (command.length == 3 && Fx.isNumeric(command[1]) && Fx.isNumeric(command[2]) && !command[1].equals("0") && !command[2].equals("0")) { // !dice <eye> <roll> 입력
            replyMessage.append(command[2])
                    .append("d").append(command[1])
                    .append("을 굴립니다.\r\n결과는 **");
            for (int i = 0; i < Integer.parseInt(command[2]); i++) { // roll 횟수만큼 결과 출력
                replyMessage.append(random.nextInt(Integer.parseInt(command[1])) + 1)
                        .append(" ");
            }
            replyMessage.deleteCharAt(replyMessage.length() - 1);
            replyMessage.append("**!");
        } else { // 예외처리
            replyMessage.append("에러 발생: Command length invalid or parameters not numeric."); // 에러 발생
        }
        return replyMessage; // 완성된 답장 송신
    }
}
