package com.mday.client.ui.render.unit.ship;

import com.mday.client.ui.Surface;
import com.mday.client.ui.render.unit.AbstractShipRenderer;
import com.mday.common.model.Ship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Color;

import javax.annotation.Nonnull;

/**
 * Responsible for rendering the recon drone.
 */
public class TransportRenderer extends AbstractShipRenderer {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransportRenderer.class);

    @Nonnull
    @Override
    protected Color getColor() {
        return new Color(145, 174, 13);
    }

    @Override
    public void accept(@Nonnull final Ship ship, @Nonnull final Surface surface) {
        super.accept(ship, surface);
    }
}
