package zygmundfelt.dan.bitsetmicrolab;

import java.util.BitSet;

public class LightSwitcher {

    /**
     * Take a given input of switches, and the switches to turn on, and return the new state of the switches.
     * NOTE: If the initial state of a switch is already turned on, do not turn it off.
     */
    public static BitSet turnOnSwitches(BitSet switches, BitSet switchesToTurnOn) {
        switches.or(switchesToTurnOn);
        return switches;
    }

    /**
     * Take a given input of switches and turn them all to on.
     */
    public static BitSet turnOnAllSwitches(BitSet switches) {
        for(int i = 0; i < switches.size(); i++) {
            switches.set(i);
        }
        return switches;
    }

    /**
     * Take a given input of switches and the switches to turn off, and return the new state of the switches.
     * NOTE: If a switch is already off, do not turn it on.
     * And a '1' in a position in 'switchesToTurnOff' means to turn that switch to off.
     */
    public static BitSet turnOffSwitches(BitSet switches, BitSet switchesToTurnOff) {
        switches.andNot(switchesToTurnOff);
        return switches;
    }

    /**
     * Take a given input of switches and turn them all off.
     * Remember to use bit notation and a bit operator.
     */
    public static BitSet turnOffAllSwitches(BitSet switches) {
        switches.and(new BitSet());
        return switches;
    }

    /**
     * Take a given input of switches and the switches to flip, and return the new state of the switches.
     * NOTE: Wherever there is a '1' in switchesToFlip, flip the state of that switch in switches.
     * I.E switches = 1 0 1 and switchesToFlip = 1 1 0 should return 0 1 1.
     */
    public static BitSet flipSwitches(BitSet switches, BitSet switchesToFlip) {
        for(int i = 0; i < switchesToFlip.length(); i++) {
            if(switchesToFlip.get(i)) {
                switches.flip(i);
            }
        }
        return switches;
    }

    /**
     * Take a given input of switches and flip them all.
     * NOTE: An integer has more than 8 bits, so find a way to only return the rightmost 8 bits.
     */
    public static BitSet flipAllSwitches(BitSet switches) {
        for(int i = 0; i < switches.length(); i++) {
            switches.flip(i);
        }
        return switches;
    }

    /**
     * Return the state of a switch in a given position.
     * Count switches from 0, and from right to left.
     * So, a byte reads 76543210
     */
    public static boolean getSwitchPositionAt(BitSet switches, int position) {
        return switches.get(position);
    }

    /**
     * Move all the the bits to the right `count` places.
     */
    public static BitSet moveRightBy(BitSet switches, int count) {
        BitSet tempSet = new BitSet(switches.size() - count);
        for(int i = count; i < switches.size(); i++) {
            tempSet.set(i - count, switches.get(i));
        }
        return tempSet;
    }

    /**
     * Move all the the bits to the left `count` places.
     * NOTE: An integer has more than 8 bits, so find a way to only return the rightmost 8 bits.
     */
    public static BitSet moveLeftBy(BitSet switches, int count){
        BitSet tempSet = new BitSet(switches.size() + count);
        for(int i = 0; i < switches.size(); i++) {
            tempSet.set(count + i, switches.get(i));
        }
        return tempSet;
    }

//    /**
//     * This is written for you to help with debugging.  If you call System.out.println(viewSwitches(switches)),
//     * you can see the rightmost 8 bits of a given integer.
//     */
//    public static String viewSwitches(BitSet switches) {
//
//        return String.format("%8s", Integer.toBinaryString((switches & 0b11111111))).replace(' ', '0');
//    }

    static BitSet createFromString(String s) {
        BitSet t = new BitSet(s.length());
        int lastBitIndex = s.length() - 1;

        for (int i = lastBitIndex; i >= 0; i--) {
            if ( s.charAt(i) == '1'){
                t.set(lastBitIndex - i);
            }
        }

        return t;
    }
}