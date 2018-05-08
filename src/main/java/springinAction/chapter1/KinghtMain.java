/**
 * Created by lijie on 2017/7/24.
 */
package springinAction.chapter1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * auther lijie  2017/7/24.
 */
public class KinghtMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}