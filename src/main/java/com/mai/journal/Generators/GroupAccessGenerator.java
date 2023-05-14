package com.mai.journal.Generators;

import org.springframework.stereotype.Component;

import java.util.Random;
/** Класс для генерации массива строк типа "логин пароль".
 * Логин представляет собой строку типа "sj______", где на место пропусков вставляется id последнего студента
 * и дополняется нулями слева до шести символов.
 * В startIndex должен передаваться id последнего студента в базе данных.
 * Count - количество студентов, для которых нужно создать запись.
 * Пароль - случайная последовательность из 4 цифр.
 */
@Component
public class GroupAccessGenerator {

    public String[] generateAccess(long startIndex, int count){
        StringBuilder stringBuilder = new StringBuilder();
        for(long i = startIndex; i < startIndex + count; ++i){
            stringBuilder.append("sj").append(String.format("%06d", i)).append(" ").append(generatePassword()).append('\n');
        }
        return stringBuilder.toString().split("\n");
    }


    private String generatePassword(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }
}
