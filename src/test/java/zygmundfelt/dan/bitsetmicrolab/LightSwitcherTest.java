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
        allZeroes = LightSwitcher.createFromString("00000000");
        leftHalfOnes = LightSwitcher.createFromString("11110000");
        rightHalfOnes = LightSwitcher.createFromString("00001111");
    }

    @Test
    public void testTurnOnSwitches() {
        BitSet result1 = LightSwitcher.turnOnSwitches(baseByte, leftHalfOnes);
        BitSet expected1 = LightSwitcher.createFromString("11111010");
        BitSet result2 = LightSwitcher.turnOnSwitches(flippedBaseByte, rightHalfOnes);
        BitSet expected2 = LightSwitcher.createFromString("01011111");
        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
    }

    @Test
    public void testTurnOnAllSwitches() {
        BitSet[] results = new BitSet[4];
        results[0] = LightSwitcher.turnOnAllSwitches(baseByte);
        results[1] = LightSwitcher.turnOnAllSwitches(LightSwitcher.createFromString("10000001"));
        results[2] = LightSwitcher.turnOnAllSwitches(allOnes);
        results[3] = LightSwitcher.turnOnAllSwitches(LightSwitcher.createFromString("11011000"));

        for(BitSet result : results) {
            Assert.assertEquals(allOnes, result);
        }
    }

    @Test
    public void testTurnOffSwitches() {
        BitSet result1 = LightSwitcher.turnOffSwitches(baseByte, leftHalfOnes);
        BitSet expected1 = LightSwitcher.createFromString("00001010");
        BitSet result2 = LightSwitcher.turnOffSwitches(flippedBaseByte, rightHalfOnes);
        BitSet expected2 = LightSwitcher.createFromString("01010000");
        Assert.assertEquals(result1, expected1);
        Assert.assertEquals(result2, expected2);
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
        BitSet result1 = LightSwitcher.flipSwitches(baseByte, rightHalfOnes);
        BitSet expected1 = LightSwitcher.createFromString("10100101");
        BitSet result2 = LightSwitcher.flipSwitches(flippedBaseByte, leftHalfOnes);
        BitSet expected2 = LightSwitcher.createFromString("10100101");
        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
    }

    @Test
    public void testFlipAllSwitches() {
        BitSet result1 = LightSwitcher.flipAllSwitches(baseByte);
        BitSet result3 = LightSwitcher.flipAllSwitches(allOnes);
        Assert.assertEquals(result1, flippedBaseByte);
        Assert.assertEquals(result3, allZeroes);
    }

    @Test
    public void testGetSwitchPositionAt() {
        for(int i = 0; i < 4; i++) {
            Assert.assertEquals(false, LightSwitcher.getSwitchPositionAt(baseByte, 2*i));
        }
        for(int i = 0; i < 4; i++) {
            Assert.assertEquals(true, LightSwitcher.getSwitchPositionAt(baseByte, 2*i + 1));
        }
        for(int i = 0; i < 4; i++) {
            Assert.assertEquals(true, LightSwitcher.getSwitchPositionAt(flippedBaseByte, 2*i));
        }
        for(int i = 0; i < 4; i++) {
            Assert.assertEquals(false, LightSwitcher.getSwitchPositionAt(flippedBaseByte, 2*i + 1));
        }
    }

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
//        BitSet result1 = LightSwitcher.moveLeftBy(baseByte, 1);
//        BitSet result2 = LightSwitcher.moveLeftBy(flippedBaseByte, 2);
//        BitSet result3 = LightSwitcher.moveLeftBy(allOnes, 3);
//        BitSet result4 = LightSwitcher.moveLeftBy(allZeroes, 4);
//        BitSet expected1 = LightSwitcher.createFromString("101010100");
//        BitSet expected2 = LightSwitcher.createFromString("0101010100");
//        BitSet expected3 = LightSwitcher.createFromString("11111000");
//        BitSet expected4 = LightSwitcher.createFromString("00000000");
//        Assert.assertEquals(result1, expected1);
//        Assert.assertEquals(result2, expected2);
//        Assert.assertEquals(result3, expected3);
//        Assert.assertEquals(expected4, result4);
//    }

    @Test
    public void testMoveOnesToLeft() {
        int expected = 6;

        int actual = LightSwitcher.moveOnesToLeft(baseByte);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMoveOnesToRight() {
        int expected = 10;

        int actual = LightSwitcher.moveOnesToRight(baseByte);

        Assert.assertEquals(expected, actual);
    }
}