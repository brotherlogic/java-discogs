package com.brotherlogic.discogs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public enum Condition {
  M(5), NM(4), VGP(3), VG(2), G(1), P(0);
  
  private int sortOrder;
  private static Logger logger = Logger.getLogger(Condition.class);
  
  Condition(int srtOrder) {
    sortOrder = srtOrder;
  }

  /**
   * Builds a condition object from the discogs condition string.
   */
  public static Condition getCondition(String condStr) {
    if (condStr.equals("Mint (M)")) {
      return M;
    } else if (condStr.equals("Near Mint (NM or M-)")) {
      return NM;
    } else {
      logger.log(Level.ERROR,"Unknown condition: " + condStr);
      return null;
    }
  }
}
