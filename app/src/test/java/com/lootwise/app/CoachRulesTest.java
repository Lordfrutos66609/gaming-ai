package com.lootwise.app;
import org.junit.Test;
import static org.junit.Assert.*;
public class CoachRulesTest {
 @Test public void hugeScreenshotIsBounded(){int sample=CoachRules.sampleSize(20000,12000);assertTrue(20000/sample<=1600);assertTrue(sample>=16);}
 @Test public void smallScreenshotRetainsResolution(){assertEquals(1,CoachRules.sampleSize(720,1280));}
 @Test public void profileAndVersionLimitsReachCoach(){String s=CoachRules.system("LoD 1.13 offline Sorceress");assertTrue(s.contains("LoD 1.13 offline Sorceress"));assertTrue(s.contains("no web access"));assertTrue(s.contains("runewords"));}
}
