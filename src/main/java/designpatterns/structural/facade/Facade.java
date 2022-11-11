package designpatterns.structural.facade;

/**
 * 外观模式(Facade Pattern)：外部与一个子系统的通信必须通过
 * 一个统一的外观对象进行，为子系统中的一组接口提供一个一致的界面，
 * 外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 *
 */
public class Facade {

    public static void main(String[] args) {

    }

}

/*
 * class CPU {
 * public void freeze() { ... }
 * public void jump(long position) { ... }
 * public void execute() { ... }
 * }
 * 
 * class HardDrive {
 * public byte[] read(long lba, int size) { ... }
 * }
 * 
 * class Memory {
 * public void load(long position, byte[] data) { ... }
 * }
 * 
 * class ComputerFacade {
 * private final CPU processor;
 * private final Memory ram;
 * private final HardDrive hd;
 * 
 * public ComputerFacade() {
 * this.processor = new CPU();
 * this.ram = new Memory();
 * this.hd = new HardDrive();
 * }
 * 
 * public void start() {
 * processor.freeze();
 * ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
 * processor.jump(BOOT_ADDRESS);
 * processor.execute();
 * }
 * }
 */
