package model;

public class WithoutArmor extends MilitaryUnits {
    private UnitsWithoutArmor unit;
    private WeaponWithoutArmor weapon;

    public WithoutArmor(TypeOfUnits type, Grade speed, Grade attackPower, Grade defensePower, UnitsWithoutArmor unit, WeaponWithoutArmor weapon) {
        super(type, speed, attackPower, defensePower);
        this.unit = unit;
        this.weapon = weapon;
    }
}
