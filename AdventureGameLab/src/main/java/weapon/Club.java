package weapon;

import behaviours.IWeapon;

public class Club implements IWeapon{

        private int damageValue;

        public Club(int damageValue) {
            this.damageValue = 25;
        }


        public int damageValue() {
            return this.damageValue;
        }
    }


