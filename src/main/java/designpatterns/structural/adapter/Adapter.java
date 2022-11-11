package designpatterns.structural.adapter;

/**
 * 将一个接口转换成客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作
 * */
public class Adapter {

    public static void main(String[] args) {
        LightningToMicro lightningToMicro = new LightningToMicro(new Iphone());
        lightningToMicro.useMicro();
    }

}

interface LightningPhone {
    void useLightning();
}

interface MicroUSB {
    void useMicro();
}

class Iphone implements LightningPhone {
    @Override
    public void useLightning() {
        System.out.println("lighting");
    }
}

class Android implements MicroUSB {
    @Override
    public void useMicro() {
        System.out.println("microUSB");
    }
}

class LightningToMicro implements MicroUSB {

    private LightningPhone lightningPhone;

    public LightningToMicro(LightningPhone lightningPhone) {
        this.lightningPhone =  lightningPhone;
    }

    @Override
    public void useMicro() {
        lightningPhone.useLightning();
    }
}

