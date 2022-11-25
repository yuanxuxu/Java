import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

public class Test {

    @Getter
    @Setter
    private static int age = 10;

    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("John", "Adam", "Jane");
        Set<Character> first = ImmutableSet.of('a', 'b', 'c');

        Test.setAge(5);
        System.out.println(age);
    }
}
