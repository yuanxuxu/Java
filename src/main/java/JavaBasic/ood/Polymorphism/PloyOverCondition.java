package JavaBasic.ood.Polymorphism;

/**
 * Replace Conditional with Polymorphism
 */
public class PloyOverCondition {

}
/*
 * class Bird {
 * // ...
 * double getSpeed() {
 * switch (type) {
 * case EUROPEAN:
 * return getBaseSpeed();
 * case AFRICAN:
 * return getBaseSpeed() - getLoadFactor() * numberOfCoconuts;
 * case NORWEGIAN_BLUE:
 * return (isNailed) ? 0 : getBaseSpeed(voltage);
 * }
 * throw new RuntimeException("Should be unreachable");
 * }
 * }
 * 
 * abstract class Bird {
 * // ...
 * abstract double getSpeed();
 * }
 * 
 * class European extends Bird {
 * double getSpeed() {
 * return getBaseSpeed();
 * }
 * }
 * 
 * class African extends Bird {
 * double getSpeed() {
 * return getBaseSpeed() - getLoadFactor() * numberOfCoconuts;
 * }
 * }
 * 
 * class NorwegianBlue extends Bird {
 * double getSpeed() {
 * return (isNailed) ? 0 : getBaseSpeed(voltage);
 * }
 * }
 * 
 * // Somewhere in client code
 * speed=bird.getSpeed();
 */