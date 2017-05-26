package zygmundfelt.dan.bitsetmicrolab;

import org.junit.*;

import java.util.BitSet;


public class LightSwitcherTest {
    private BitSet baseByte;
    private BitSet flippedBaseByte;
    private BitSet allOnes;
    private BitSet allZeroes;
    private BitSet leftHalfOnes;
    private BitSet rightHalfOnes;

    @Before
    public void initialize() {
        baseByte = LightSwitcher.createFromString("10101010");
        flippedBaseByte = LightSwitcher.createFromString("01010101");
        allOnes = LightSwitcher.createFromString("11111111");
        allZeroes = LightSwitcher.createFromString("11111111");
        leftHalfOnes = LightSwitcher.createFromString("11110000");
        rightHalfOnes = LightSwitcher.createFromString("00001111");
    }

    @Test
    public void testTurnOnSwitches() {
        BitSet result1 = LightSwitcher.turnOnSwitches(baseByte, leftHalfOnes);
        BitSet expected1 = LightSwitcher.createFromString("11111010");
        BitSet result2 = LightSwitcher.turnOnSwitches(flippedBaseByte, leftHalfOnes);
        BitSet expected2 = LightSwitcher.createFromString("10101111");
        BitSet result3 = LightSwitcher.turnOnSwitches(baseByte, rightHalfOnes);
        BitSet expected3 = LightSwitcher.createFromString("00001111");
        BitSet result4 = LightSwitcher.turnOnSwitches(flippedBaseByte, rightHalfOnes);
        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
        Assert.assertEquals(expected3, result3);
        Assert.assertEquals(expected3, result4);
    }

    @Test
    public void testTurnOnAllSwitches() {
        BitSet[] results = new BitSet[4];
        results[0] = LightSwitcher.turnOnAllSwitches(baseByte);
        results[1] = LightSwitcher.turnOnAllSwitches(flippedBaseByte);
        results[2] = LightSwitcher.turnOnAllSwitches(allOnes);
        results[3] = LightSwitcher.turnOnAllSwitches(allZeroes);

        for(BitSet result : results) {
            Assert.assertEquals(allOnes, result);
        }
    }

    @Test
    public void testTurnOffSwitches() {
        BitSet result1 = LightSwitcher.turnOffSwitches(baseByte, leftHalfOnes);
        BitSet expected1 = LightSwitcher.createFromString("00001010");
        BitSet result2 = LightSwitcher.turnOffSwitches(flippedBaseByte, leftHalfOnes);
        BitSet expected2 = LightSwitcher.createFromString("00000101");
        BitSet result3 = LightSwitcher.turnOffSwitches(baseByte, rightHalfOnes);
        BitSet expected3 = LightSwitcher.createFromString("10100000");
        BitSet result4 = LightSwitcher.turnOffSwitches(flippedBaseByte, rightHalfOnes);
        BitSet expected4 = LightSwitcher.createFromString("01010000");
        Assert.assertEquals(result1, expected1);
        Assert.assertEquals(result2, expected2);
        Assert.assertEquals(result3, expected3);
        Assert.assertEquals(result4, expected4);
    }

    @Test
    public void testTurnOffAllSwitches() {
        BitSet[] results = new BitSet[4];
        results[0] = LightSwitcher.turnOffAllSwitches(baseByte);
        results[1] = LightSwitcher.turnOffAllSwitches(flippedBaseByte);
        results[2] = LightSwitcher.turnOffAllSwitches(allOnes);
        results[3] = LightSwitcher.turnOffAllSwitches(allZeroes);

        for(BitSet result : results) {
            Assert.assertEquals(allZeroes, result);
        }
    }

    @Test
    public void testFlipSwitches() {
        BitSet result1 = LightSwitcher.flipSwitches(baseByte, leftHalfOnes);
        BitSet expected1 = LightSwitcher.createFromString("01011010");
        BitSet result2 = LightSwitcher.flipSwitches(flippedBaseByte, leftHalfOnes);
        BitSet expected2 = LightSwitcher.createFromString("10100101");
        BitSet result3 = LightSwitcher.flipSwitches(baseByte, rightHalfOnes);
        BitSet result4 = LightSwitcher.flipSwitches(flippedBaseByte, rightHalfOnes);
        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
        Assert.assertEquals(expected2, result3);
        Assert.assertEquals(expected1, result4);
    }

//    @Test
//    public void testFlipAllSwitches() {
//        int result1 = LightSwitcher.flipAllSwitches(baseByte);
//        int result2 = LightSwitcher.flipAllSwitches(flippedBaseByte);
//        int result3 = LightSwitcher.flipAllSwitches(0b11111111);
//        int result4 = LightSwitcher.flipAllSwitches(0b00000000);
//        Assert.assertEquals(result1, 0b01010101);
//        Assert.assertEquals(result2, 0b10101010);
//        Assert.assertEquals(result3, 0b00000000);
//        Assert.assertEquals(result4, 0b11111111);
//    }
//
//    @Test
//    public void testGetSwitchPositionAt() {
//        for(int i = 0; i < 8; i++) {
//            Assert.assertEquals(i%2, LightSwitcher.getSwitchPositionAt(baseByte, i));
//        }
//        for(int i = 0; i < 8; i++) {
//            Assert.assertEquals((i + 1) % 2, LightSwitcher.getSwitchPositionAt(flippedBaseByte, i));
//        }
//        Assert.assertEquals(0, LightSwitcher.getSwitchPositionAt(0b11111110, 0));
//        Assert.assertEquals(1, LightSwitcher.getSwitchPositionAt(0b11111110, 1));
//        Assert.assertEquals(1, LightSwitcher.getSwitchPositionAt(0b11111110, 7));
//    }
//
//    @Test
//    public void testMoveRightBy() {
//        int result1 = LightSwitcher.moveRightBy(baseByte, 1);
//        int result2 = LightSwitcher.moveRightBy(baseByte, 2);
//        int result3 = LightSwitcher.moveRightBy(baseByte, 3);
//        int result4 = LightSwitcher.moveRightBy(baseByte, 4);
//        int result5 = LightSwitcher.moveRightBy(baseByte, 5);
//        int result6 = LightSwitcher.moveRightBy(baseByte, 6);
//        int result7 = LightSwitcher.moveRightBy(baseByte, 7);
//        int result8 = LightSwitcher.moveRightBy(baseByte, 8);
//        int expected1 = 0b01010101;
//        int expected2 = 0b00101010;
//        int expected3 = 0b00010101;
//        int expected4 = 0b00001010;
//        int expected5 = 0b00000101;
//        int expected6 = 0b00000010;
//        int expected7 = 0b00000001;
//        int expected8 = 0b00000000;
//        Assert.assertEquals(result1, expected1);
//        Assert.assertEquals(result2, expected2);
//        Assert.assertEquals(result3, expected3);
//        Assert.assertEquals(result4, expected4);
//        Assert.assertEquals(result5, expected5);
//        Assert.assertEquals(result6, expected6);
//        Assert.assertEquals(result7, expected7);
//        Assert.assertEquals(result8, expected8);
//    }
//
//    @Test
//    public void testMoveLeftBy() {
//        int result1 = LightSwitcher.moveLeftBy(baseByte, 1);
//        int result2 = LightSwitcher.moveLeftBy(baseByte, 2);
//        int result3 = LightSwitcher.moveLeftBy(baseByte, 3);
//        int result4 = LightSwitcher.moveLeftBy(baseByte, 4);
//        int result5 = LightSwitcher.moveLeftBy(baseByte, 5);
//        int result6 = LightSwitcher.moveLeftBy(baseByte, 6);
//        int result7 = LightSwitcher.moveLeftBy(baseByte, 7);
//        int result8 = LightSwitcher.moveLeftBy(baseByte, 8);
//        int expected1 = 0b01010100;
//        int expected2 = 0b10101000;
//        int expected3 = 0b01010000;
//        int expected4 = 0b10100000;
//        int expected5 = 0b01000000;
//        int expected6 = 0b10000000;
//        int expected7 = 0b00000000;
//        int expected8 = 0b00000000;
//        Assert.assertEquals(result1, expected1);
//        Assert.assertEquals(result2, expected2);
//        Assert.assertEquals(result3, expected3);
//        Assert.assertEquals(result4, expected4);
//        Assert.assertEquals(result5, expected5);
//        Assert.assertEquals(result6, expected6);
//        Assert.assertEquals(result7, expected7);
//        Assert.assertEquals(result8, expected8);
//    }


}