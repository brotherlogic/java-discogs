package com.brotherlogic.discogs.backend;

import com.brotherlogic.discogs.Price;
import com.brotherlogic.discogs.Release;

public interface PriceBackend {
  Price getPrice(Release rel);
}
