package basic.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.beans.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 内省
 *
 * @author lijie
 * @date 2022/5/21 13:58
 */
@Slf4j
public class TestInstrospector {
    private static void getProperty(User1 point, String proName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(User1.class);
        //BeanInfo beanInfo = Introspector.getBeanInfo(point.getClass());
        PropertyDescriptor[] proDescriptors = beanInfo.getPropertyDescriptors();
        log.info("属性描述: ");
        Arrays.stream(proDescriptors).forEach(System.out::println);
        log.info("------------------------------");
        // 方法描述
        log.info("方法描述: ");
        for (MethodDescriptor methodDescriptor : beanInfo.getMethodDescriptors()) {
            log.info("{}", methodDescriptor);
        }
        log.info("------------------------------");
        // 事件描述
        log.info("事件描述: ");
        for (EventSetDescriptor eventSetDescriptor : beanInfo.getEventSetDescriptors()) {
            log.info("{}", eventSetDescriptor);
        }
        log.info("------------------------------");
        for(PropertyDescriptor prop: proDescriptors){
            if(prop.getName().equals(proName)){
                Method methodGetx = prop.getReadMethod();
                System.out.println(methodGetx.invoke(point));//8
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        User1 iris = new User1("iris", 18);
        // 打印出来属性 [name] 的值
        getProperty(iris, "name");
    }


}

@Data
@AllArgsConstructor
class User1{
    private String name;
    private int age;
}