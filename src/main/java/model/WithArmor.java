package model;

public class WithArmor extends MilitaryUnits {
    private UnitsWithArmor unit;
    private WeaponWithArmor weapon;

    public WithArmor(TypeOfUnits type, Grade speed, Grade attackPower, Grade defensePower, UnitsWithArmor unit, WeaponWithArmor weapon) {
        super(type, speed, attackPower, defensePower);
        this.unit = unit;
        this.weapon = weapon;
    }
}
