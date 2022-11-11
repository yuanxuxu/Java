package designpatterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Good example
 * 
 * In computer programming, the strategy pattern (also known as the policy
 * pattern) is a behavioral software design pattern that enables selecting an
 * algorithm at runtime. Instead of implementing a single algorithm directly,
 * code receives run-time instructions as to which in a family of algorithms to
 * use.
 */
public class FileStrategyDemo {

    public static void main(String[] args) {
        Files fileList = new Files(Strategys.create(StrategyType.ONE));
        fileList.add(new File(25, Type.PDF));
        fileList.add(new File(58, Type.XML));
        fileList.add(new File(1, Type.PDF));
        fileList.add(new File(9, Type.XML));
        fileList.add(new File(2, Type.PDF));
        fileList.add(new File(8, Type.XML));

        // fileList.setStrategy(Strategys.create(StrategyType.TWO));

        fileList.files = fileList.files.stream()
                .filter(a -> fileList.strategy.filter(a))
                .collect(Collectors.toList());

        for (File file : fileList.files) {
            System.out.println(file.toString());
        }
    }
}

class Files {
    List<File> files;
    Strategy strategy;

    public Files() {
        this.files = new ArrayList<>();
    }

    public Files(Strategy strategy) {
        this.files = new ArrayList<>();
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void add(File file) {
        this.files.add(file);
    }
}

interface Strategy {
    boolean filter(File file);
}

class StrategyOne implements Strategy {

    @Override
    public boolean filter(File file) {
        return file.size > 5 && file.type.equals(Type.XML);
    }

}

class StrategyTwo implements Strategy {

    @Override
    public boolean filter(File file) {
        return file.size > 10 && file.type.equals(Type.PDF);
    }

}

final class Strategys {
    public static Strategy create(StrategyType strategyType) {
        switch (strategyType) {
            case ONE:
                return new StrategyOne();
            case TWO:
                return new StrategyTwo();
            default:
                return new StrategyOne();
        }
    }
}

enum StrategyType {
    ONE, TWO;
}

class File {
    int size;
    Type type;

    public File(int size, Type type) {
        this.size = size;
        this.type = type;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                " size='" + getSize() + "'" +
                ", type='" + getType() + "'" +
                "}";
    }
}

enum Type {
    PDF,
    XML;
}